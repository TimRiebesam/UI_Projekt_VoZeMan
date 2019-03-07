package application.Model.Service;

import application.Controller.Controller;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class SettingsService {
	
	private String raplaUrl = "https://rapla.dhbw-karlsruhe.de/rapla?page=calendar&user=brockmans&file=WWI17B1";

	public void show(Pane mainPane, Pane mainWindowLabel) {
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mainWindowLabel);
		mainWindowLabel.setVisible(true);
	}
	
	public void setRaplaUrl(String raplaUrl) {
		this.raplaUrl = raplaUrl;
	}

	public String getRaplaUrl() {
		return raplaUrl;
	}
	
}
