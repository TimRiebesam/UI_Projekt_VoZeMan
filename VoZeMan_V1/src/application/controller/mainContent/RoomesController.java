package application.controller.mainContent;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class RoomesController implements Initializable{

	@FXML
	private GridPane gridPaneForRoomes;

	@FXML
	private TextField textfieldForRoomes;

	@FXML
	private Button searchBtnForRoomes;

	@FXML
	private Label searchLabelForRoomes;

	@FXML
	private Label labelForImageResizingForRoomes;

	@FXML
	private ImageView imageViewForRoomes;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageViewForRoomes.fitHeightProperty().bind(labelForImageResizingForRoomes.heightProperty());
		imageViewForRoomes.fitWidthProperty().bind(labelForImageResizingForRoomes.widthProperty());

		imageViewForRoomes.setImage(new Image("application/view/img/dhbw-plan.jpg"));
	}

	@FXML
	void searchForRoom(ActionEvent event) {
		//TODO hier Marcels Methode
		String roomname = textfieldForRoomes.getText();
		if (roomname.matches( "(^)([A-G]|[a-g])([0-5])([0-9])([0-9])($)") == true) {
			char fluegel = roomname.charAt(0);
			fluegel = Character.toUpperCase(fluegel);
			char stockwerk = roomname.charAt(1);
			String raumnummer = roomname.substring(2);
			roomname = String.valueOf(fluegel)+stockwerk+raumnummer;
			searchLabelForRoomes.setText("Ihr gesuchter Raum "+roomname+" sollte sich im "+stockwerk+"ten. Stock des Gebäudeflügels "+fluegel+" befinden.");
		} else {
			searchLabelForRoomes.setText("Ihr gesuchter Raum "+roomname+" erfüllt nicht das Suchpattern im Format [A-G][0-5][00-80]."); 
		}
	}
	
	@FXML
	void onEnter(ActionEvent event) {
		searchForRoom(event);
	}

}
