package application.Model.Service; 

import java.util.List;

import application.Model.Lecturer;
import application.Model.LecturerList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public class LecturererService {
	
	private LecturerList lecturerList = new LecturerList();
	
	public void addLecturerToList(Lecturer pLecturer) {
		lecturerList.add(pLecturer);
	}
	
	
	//Methode, um später die Namen der Dozenten in die ComboBox hinzuzufügen
	public void updateComboBox() {
		
	}
	
	

	public void show(Pane mainPane, Pane mainWindowForLecturerer) {
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mainWindowForLecturerer);
		mainWindowForLecturerer.setVisible(true);
	}
	

	
}
