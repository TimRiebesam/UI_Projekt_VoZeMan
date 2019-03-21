package application.content.lecturer;

import java.net.URL;
import java.util.ResourceBundle;

import application.helper.ModelHandler;
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
		
		//Sch�nere Alternative:
		if(selectLecturerComboBox.getSelectionModel().getSelectedIndex() != -1) {
			lecturer = lecturerList.getLecturer(selectLecturerComboBox.getSelectionModel().getSelectedIndex());
		}
		
		//Falls du trotzdem die forSchleife verwenden m�chtest (nicht so gut, angenommen sehr lange Liste m�ssen alle durchgegangen werden, oben nur genau ein index aufgerufen)
		//Au�erdem brauchst du vor der for-Schleife noch "if(selectLecturerComboBox.getSelectionModel().getSelectedItem() != -1)" (Pr�ft ob �berhaupt ein Index ausgew�hlt ist. load Methode macht n�mlich einen Reset der Auswahl daher auch die Exception)
		
//		for(int i = 0; i <= lecturerList.size(); i++) {
//			if (selectLecturerComboBox.getSelectionModel().getSelectedItem().toString().equals(lecturerList.getLecturer(i).getName())){
//				lecturer.setTitle(lecturerList.getLecturer(i).getTitle());
//				lecturer.setName(lecturerList.getLecturer(i).getName());
//				lecturer.setAddress(lecturerList.getLecturer(i).getAddress());
//				lecturer.setEmail(lecturerList.getLecturer(i).getEmail());
//			}		
//		}
		
		showLecturerTextArea.setText(lecturer.toString());	
	}

	
	@FXML
	public void eventComboBox(ActionEvent event) {
		showLecturerInformation();
	}


}
