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
		
	
	}
	
	public void load() {
		selectLecturerComboBox.setItems(lecturerList.getLecturerersAsStringList());
	}
	
	private void showLecturerInformation() {
		showLecturerTextArea.setText(showLecturerTextArea.getText()+ "\n" + selectLecturerComboBox.getSelectionModel().getSelectedItem());
		
	}
	
	@FXML
	public void eventComboBox(ActionEvent event) {
		showLecturerInformation();
	}


}
