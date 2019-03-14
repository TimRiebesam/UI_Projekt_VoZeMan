package application.model.main;

import java.text.SimpleDateFormat;

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
	
	public ObservableList<String> getNoteTitlesWithTimestamp() {
		ObservableList<String> noteTitles = FXCollections.observableArrayList();
		notes.forEach(note -> {
			noteTitles.add(new SimpleDateFormat("dd.MM.yyyy - HH:mm").format(note.getTimestamp()) + "\n" + note.getTitle());
		});
		return noteTitles;
	}
	
	public Note getNoteByIndex(int value) {
		return notes.get(value);
	}
	
	public int size() {
		return notes.size();
	}
	
}
