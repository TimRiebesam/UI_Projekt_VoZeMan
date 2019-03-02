package application.Model.Service;

import java.util.Date;

import application.Model.Note;
import application.Model.NotesList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class NotesService {
	
    private NotesList notes = new NotesList();

	public void addNote(TextField notesTitleTextField, TextArea notesTextArea, ListView<String> notesListview, ListView<String> notesWindowListview) {
		if(!notesTitleTextField.getText().equals("") && !notesTextArea.getText().equals("")) {
    		notes.add(new Note(notesTitleTextField.getText(), notesTextArea.getText(), new Date()));
    		updateNotesView(notesTitleTextField, notesTextArea, notesListview, notesWindowListview);
    	}
	}
	
	public void addNoteOnlyText(String title, String text, Date date) {
		notes.add(new Note(title, text, date));
	}
	
    public void updateNotesView(TextField notesTitleTextField, TextArea notesTextArea, ListView<String> notesListview, ListView<String> notesWindowListView) {
    	notesListview.setItems(notes.getNoteTitles());
    	notesWindowListView.setItems(notes.getNoteTitlesWithTimestamp());
    	notesTextArea.setText("");
    	notesTitleTextField.setText("");
    }
	
    public NotesList getNotesList() {
    	return notes;
    }
    
    public Note getNoteByIndex(int value) {
    	return notes.getNoteByIndex(value);
    }

	public void showNote(int choosenItem, Pane mainPane, HBox mainWindowForNotes, ListView<String> notesWindowListView,
			TextField notesWindowTextField, TextArea notesWindowTextArea, ListView<String> notesListview) {
		
		show(mainPane, mainWindowForNotes, notesWindowListView, notesListview);
		
		notesWindowListView.scrollTo(choosenItem);
		notesWindowListView.getSelectionModel().select(choosenItem);
		notesListview.scrollTo(choosenItem);
		notesListview.getSelectionModel().select(choosenItem);
		
		notesWindowTextField.setText(getNoteByIndex(choosenItem).getTitle());
		notesWindowTextArea.setText(getNoteByIndex(choosenItem).getText());		
	}

	public void show(Pane mainPane, HBox mainWindowForNotes, ListView<String> notesWindowListView, ListView<String> notesListview) {
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mainWindowForNotes);
		mainWindowForNotes.setVisible(true);
		
		notesWindowListView.setItems(getNotesList().getNoteTitlesWithTimestamp());
		notesListview.setItems(notes.getNoteTitles());
	}

	public void updateNote(int selectedIndex, TextField notesWindowTextField, TextArea notesWindowTextArea, Button notesWindowSaveBtn) {
		Note noteToChange = getNoteByIndex(selectedIndex);
		noteToChange.setTitle(notesWindowTextField.getText());
		noteToChange.setText(notesWindowTextArea.getText());
		notesWindowSaveBtn.setDisable(true);
	}
    
}
