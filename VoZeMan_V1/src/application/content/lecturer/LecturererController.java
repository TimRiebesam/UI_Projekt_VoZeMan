package application.content.lecturer;

import java.net.URL;
import java.util.ResourceBundle;

import application.helper.ModelHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LecturererController implements Initializable {
	
	@FXML
	private GridPane gridPane;
	
	@FXML
	private Label selectLecturerLabel;
	
	@FXML
	private ComboBox<String> selectLecturerComboBox;
	
    @FXML
    private Label labelForNameAndTitle;

    @FXML
    private Label labelForLecture;

    @FXML
    private ImageView imageViewForPic;

    @FXML
    private Label labelForAdress;

    @FXML
    private Label labelForPhone;

    @FXML
    private Label labelForMail;
	
	private LecturerList lecturerList = ModelHandler.getLecturerList();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		selectLecturerComboBox.setItems(lecturerList.getLecturerersAsStringList());
		labelForNameAndTitle.setText("Informationen über deine Dozenten...");
	}
	
	public void load() {
		selectLecturerComboBox.setItems(lecturerList.getLecturerersAsStringList());
	}
	
	
	private void showLecturerInformation() {
		if(selectLecturerComboBox.getSelectionModel().getSelectedIndex() != -1) {
			Lecturer lecturer = lecturerList.getLecturer(selectLecturerComboBox.getSelectionModel().getSelectedIndex());
			labelForNameAndTitle.setText(lecturer.getTitle() + " " + lecturer.getName());
			imageViewForPic.setImage(new Image(lecturer.getPathToImage()));
			labelForLecture.setText("Vorlesung: " + lecturer.getLecture());
			labelForAdress.setText("Standort: " + lecturer.getAddress());
			labelForPhone.setText("Telefon: " + lecturer.getPhone());
			labelForMail.setText("E-Mail: " + lecturer.getEmail());
		}
	}

	
	@FXML
	public void eventComboBox(ActionEvent event) {
		showLecturerInformation();
	}


}
