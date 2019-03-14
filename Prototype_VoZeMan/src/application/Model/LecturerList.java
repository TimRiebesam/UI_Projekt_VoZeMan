/*
 * Klasse ist angelehnt an die NotesList.java und soll die ComboBox im Menü Dozenten mit den 
 * Dozenten füllen
 * HAT NOCH KEINE FUNKTION
 */



package application.Model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LecturerList {

	private ObservableList<Lecturer> lecturer = FXCollections.observableArrayList();
	
	
	public void add(Lecturer pLecturer) {
		lecturer.add(pLecturer);
	}
	
	public int size() {
		return lecturer.size();
	}
	
	public Lecturer getLecturerByIndex(int pIndex) {
		return lecturer.get(pIndex);
	}
	
	public ObservableList<String> getNames() {
		ObservableList<String> lecturerName = FXCollections.observableArrayList();
		lecturer.forEach(lecturer -> {
			lecturerName.add(lecturer.getName()+ " " + lecturer.getLastname());
		});
		return lecturerName;
	}
	
}
