package application.Model.Service;

import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StageResizeService {
	
	public void ResizeStage(Stage primaryStage, Pane mainPane, Pane quickNotesPane, Number oldValue, String direction) {
		updateMainPane(primaryStage, mainPane);
		updateQuickNotesPane(primaryStage, quickNotesPane);
	}
	
	public void updateMainPane(Stage primaryStage, Pane mainPane) {
		//TODO HIER GEHTS AUCH WEITER!!!
		//Anpassen von höhe und breite anhand von oldvalue in %
		((Control)mainPane.getChildren().get(0)).setPrefHeight(primaryStage.getHeight()-105);
		((Control)mainPane.getChildren().get(0)).setPrefWidth(primaryStage.getWidth()*0.7);
	}
	
	public void updateQuickNotesPane(Stage primaryStage, Pane quickNotesPane) {
		((VBox)quickNotesPane.getChildren().get(0)).getChildren().forEach(child -> {
			((Control)child).setPrefWidth(primaryStage.getWidth()*0.3);
			if(child.getClass().equals(TextArea.class) || child.getClass().equals((ListView.class))) {
				((Control)child).setPrefHeight((primaryStage.getHeight()-105)*0.32);
			}
		});
	}
	
}
