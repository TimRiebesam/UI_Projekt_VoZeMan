package application.controller.mainContent;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.glyphfont.FontAwesome;

import application.model.main.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Label moodleLinkSettingsLabel;
    @FXML
    private TextField enterMoodleLinkSettingsTextfield;
    @FXML
    private Button saveMoodleLinkSettingButton;
    @FXML
    private Label savedMoodleLinkLabel;
    
    
    @FXML
    private Label dualisLinkSettingsLabel;
    @FXML
    private TextField enterDualisLinkSettingsTextfield;
    @FXML
    private Button saveDualisLinkSettingsButton;
    @FXML
    private Label savedDualisLinkLabel;
    
    
	Settings settings = new Settings();
	

	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setGraphicForSaveButton();
		setSaveLabelbsUnvisible();
		
		
	}
	
	
	//Methode um dem SpeichernButton den Icon hinzuzufuegen
	private void setGraphicForSaveButton() {
		saveRaplaLinkSettingButton.setGraphic(new FontAwesome().create(FontAwesome.Glyph.SAVE).color(Color.WHITE).size(23));
		saveMoodleLinkSettingButton.setGraphic(new FontAwesome().create(FontAwesome.Glyph.SAVE).color(Color.WHITE).size(23));
		saveDualisLinkSettingsButton.setGraphic(new FontAwesome().create(FontAwesome.Glyph.SAVE).color(Color.WHITE).size(23));
	}
	//Methode um die saveLabels unsichtbar zu mache
	private void setSaveLabelbsUnvisible() {
		savedRaplaLinkLabel.setVisible(false);
		savedMoodleLinkLabel.setVisible(false);
		savedDualisLinkLabel.setVisible(false);
	}
	
	
	//Methode um RaplaLink zu speichern
	@FXML
	void saveRaplaLink(ActionEvent event) {
		settings.setRaplaUrl(enterRaplaLinkSettingsTextfield.getText());
		enterRaplaLinkSettingsTextfield.setText("");
		savedRaplaLinkLabel.setVisible(true);
	}
	
	//methode um moodle-Link zu speichern
	@FXML
	void saveMoodleLink(ActionEvent event) {
		settings.setMoodleUrl(enterMoodleLinkSettingsTextfield.getText());
		enterMoodleLinkSettingsTextfield.setText("");
		savedMoodleLinkLabel.setVisible(true);

	}
	
	//Methode um Dualis Link zu speichern
	@FXML
	void saveDualisLink(ActionEvent event) {
		settings.setDualisUrl(enterDualisLinkSettingsTextfield.getText());		
		enterDualisLinkSettingsTextfield.setText("");
		savedDualisLinkLabel.setVisible(true);

	}
	
	
	
	
	
	
	

}
