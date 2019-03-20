package application.content.lecturer;

import java.net.URL;
import java.util.ResourceBundle;

import javax.jws.WebParam.Mode;

import application.helper.ModelHandler;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class LecturererController implements Initializable {
	
	@FXML
	private GridPane gridPane;
	
	@FXML
	private Label selectLecturerLabel;
	
	@FXML
	private ComboBox<String> selectLecturerComboBox;
	
	@FXML
	private TextArea showLecturerTextArea;
	
	private LecturerList lecturerList = ModelHandler.getLecturerList();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		selectLecturerComboBox.setItems(lecturerList.getLecturerersAsStringList());
		showLecturerTextArea.setText("Informationen �ber deine Dozenten...");
	}
	
	public void load() {
		selectLecturerComboBox.setItems(lecturerList.getLecturerersAsStringList());
	}
	
	
	private void showLecturerInformation() {
		Lecturer lecturer = new Lecturer();
		for(int i = 0; i < lecturerList.size(); i++) {
			if (selectLecturerComboBox.getSelectionModel().getSelectedItem().toString().equals(lecturerList.getLecturer(i).getName())){
				lecturer.setTitle(lecturerList.getLecturer(i).getTitle());
				lecturer.setName(lecturerList.getLecturer(i).getName());
				lecturer.setAddress(lecturerList.getLecturer(i).getAddress());
				lecturer.setEmail(lecturerList.getLecturer(i).getEmail());
			}		
		}
		showLecturerTextArea.setText(lecturer.toString());	
	}

	
	@FXML
	public void eventComboBox(ActionEvent event) {
		showLecturerInformation();
	}


}
