package application.Model;

import java.util.Date;

import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NotesModel {

	public void addNote(TextField notesTitleTextField, TextArea notesTextArea, NotesList notes, ListView<String> notesListview) {
		if(!notesTitleTextField.getText().equals("") && !notesTextArea.getText().equals("")) {
    		notes.add(new Note(notesTitleTextField.getText(), notesTextArea.getText(), new Date()));
    		updateNotesView(notesTitleTextField, notesTextArea, notes, notesListview);
    	}
	}
	
    private void updateNotesView(TextField notesTitleTextField, TextArea notesTextArea, NotesList notes, ListView<String> notesListview) {
    	notesListview.setItems(notes.getNoteTitles());
    	notesTextArea.setText("");
    	notesTitleTextField.setText("");
    }
	
}
