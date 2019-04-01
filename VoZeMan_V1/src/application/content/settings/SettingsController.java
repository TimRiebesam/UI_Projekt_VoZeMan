package application.content.settings;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.glyphfont.FontAwesome;

import application.helper.ModelHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class SettingsController implements Initializable {
	
	@FXML
	private GridPane gridPaneForSettings;
	
	@FXML
    private Label raplaLinkSettingsLabel;
	@FXML
	private TextField enterRaplaLinkSettingsTextfield;
	@FXML
	private Button saveRaplaLinkSettingButton;
	@FXML
	private Label savedRaplaLinkLabel;
	
    

    @FXML
    private Label moodleSignInLabel;

    @FXML
    private TextField enterMoodleUserTextfield;

    @FXML
    private PasswordField enterMoodlePasswordPasswordfield;

    @FXML
    private Button signInMoodleButton;
    
    @FXML
    private Label settingsWindowNiceLabel;
    
    
	Settings settings = ModelHandler.getSettings();
	

	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setGraphicForSaveButton();
		setSaveLabelbsUnvisible();
		
		
	}
	
	
	//Methode um dem SpeichernButton den Icon hinzuzufuegen
	private void setGraphicForSaveButton() {
		saveRaplaLinkSettingButton.setGraphic(new FontAwesome().create(FontAwesome.Glyph.SAVE).color(Color.WHITE).size(23));
		
	}
	//Methode um die saveLabels unsichtbar zu mache
	private void setSaveLabelbsUnvisible() {
		savedRaplaLinkLabel.setVisible(false);
		
	}
	
	
	//Methode um RaplaLink zu speichern
	@FXML
	void saveRaplaLink(ActionEvent event) {
		if (!enterRaplaLinkSettingsTextfield.getText().equals("")) {
			settings.setRaplaUrl(enterRaplaLinkSettingsTextfield.getText());
			enterRaplaLinkSettingsTextfield.setText("");
			savedRaplaLinkLabel.setVisible(true);
			saveRaplaLinkSettingButton.setVisible(false);
		}
		else {
			//ToDo Neues Label/Textfeld erstellen
			enterRaplaLinkSettingsTextfield.setText("Bitte URL eintragen");
		}
	
		

	}
	
	//Mehthode um die Anmeldung durchzuführen
	@FXML
	void signInMoodle (ActionEvent event) {
		
		if (!enterMoodleUserTextfield.getText().equals("") || !enterMoodlePasswordPasswordfield.getText().equals("")) {
			settings.setUsernameForMoodleAndDualis(enterMoodleUserTextfield.getText());
			settings.setPasswordForMoodleAndDualis(enterMoodlePasswordPasswordfield.getText());
		}
		else {
			//ToDo Neues Label/TF mit Hinweis anlegen und dann hier sichtbar machen
		}
		
		
	}
	
	
	
	
	
	

}
