package application.model.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LecturerList {

private ObservableList<Lecturer> lecturers = FXCollections.observableArrayList();
	
	public void add(Lecturer lecturer) {
		lecturers.add(lecturer);
	}

	public ObservableList<String> getLecturerersAsStringList() {
		ObservableList<String> lecturersAsStringList = FXCollections.observableArrayList();
		lecturers.forEach(lecturer -> {
			lecturersAsStringList.add(lecturer.getAddress() + " " + lecturer.getTitle() + " " + lecturer.getName());
		});
		return lecturersAsStringList;
	}
	
	public Lecturer getLecturer(int value) {
		return lecturers.get(value);
	}
	
	public int size() {
		return lecturers.size();
	}
	
}
