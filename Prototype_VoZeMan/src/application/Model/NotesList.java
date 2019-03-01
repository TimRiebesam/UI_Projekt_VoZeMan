package application.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NotesList {

	private ObservableList<Note> notes = FXCollections.observableArrayList();
	
	public void add(Note note) {
		notes.add(note);
	}

	public ObservableList<String> getNoteTitles() {
		ObservableList<String> noteTitles = FXCollections.observableArrayList();
		notes.forEach(note -> {
			noteTitles.add(note.getTitle());
		});
		return noteTitles;
	}
	
}
