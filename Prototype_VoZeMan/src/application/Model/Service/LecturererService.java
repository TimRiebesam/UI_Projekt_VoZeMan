package application.Model.Service;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class LecturererService {

	public void show(Pane mainPane, Label mainWindowLabel) {
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mainWindowLabel);
		mainWindowLabel.setVisible(true);
	}
	
}
