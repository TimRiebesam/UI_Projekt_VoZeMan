package application.Model.Service;

import java.util.Date;

import application.Model.Note;
import application.Model.NotesList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NotesService {
	
    private NotesList notes = new NotesList();

	public void addNote(TextField notesTitleTextField, TextArea notesTextArea, ListView<String> notesListview) {
		if(!notesTitleTextField.getText().equals("") && !notesTextArea.getText().equals("")) {
    		notes.add(new Note(notesTitleTextField.getText(), notesTextArea.getText(), new Date()));
    		updateNotesView(notesTitleTextField, notesTextArea, notesListview);
    	}
	}
	
    private void updateNotesView(TextField notesTitleTextField, TextArea notesTextArea, ListView<String> notesListview) {
    	notesListview.setItems(notes.getNoteTitles());
    	notesTextArea.setText("");
    	notesTitleTextField.setText("");
    }
	
}
