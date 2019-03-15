package application.controller.mainContent;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.AttributeSet.FontAttribute;

import org.controlsfx.glyphfont.FontAwesome;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class SettingsController implements Initializable {
	
	@FXML
	private GridPane gridPaneForSettings;
	@FXML
	private TextField enterRaplaLinkSettingsTextfield;
	@FXML
	private Button saveRaplaLinkSettingButton;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setGraphicForSaveButton();
		
	}
	
	
	private void setGraphicForSaveButton() {
		saveRaplaLinkSettingButton.setGraphic(new FontAwesome().create(FontAwesome.Glyph.SAVE).color(Color.WHITE).size(23));
	}
	
	
	
	
	
	
	

}
