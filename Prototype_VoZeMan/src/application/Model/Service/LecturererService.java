package application.Model.Service;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class LecturererService {

	public void show(Pane mainPane, Pane mainWindowForLecturerer) {
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mainWindowForLecturerer);
		mainWindowForLecturerer.setVisible(true);
	}
	
}
