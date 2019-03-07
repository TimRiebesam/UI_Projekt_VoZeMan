package application.Model.Service;

import javafx.scene.layout.Pane;

public class RoomesService {

	public void show(Pane mainPane, Pane mainWindowForRoomes) {
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mainWindowForRoomes);
		mainWindowForRoomes.setVisible(true);
	}
	
}
