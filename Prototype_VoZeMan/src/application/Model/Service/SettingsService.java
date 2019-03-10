package application.Model.Service;

import application.controller.Controller;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class SettingsService {

	private String raplaUrl;

	public void show(Pane mainPane, Pane mainWindowForSettings) {
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mainWindowForSettings);
		mainWindowForSettings.setVisible(true);
	}
	
	public void setRaplaUrl(String raplaUrl) {
		this.raplaUrl = raplaUrl;
	}

	public String getRaplaUrl() {
		return raplaUrl;
	}
	
}
