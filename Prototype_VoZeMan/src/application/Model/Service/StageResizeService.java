package application.Model.Service;

import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StageResizeService {
	
	public void ResizeStage(Stage primaryStage, Pane mainPane, Pane quickNotesPane, Number oldValue, String direction) {
		boolean isHeight;
		double percentage;
		
		if(direction.equals("height")) {
			isHeight = true;
			percentage = (primaryStage.getHeight()-160)/(oldValue.doubleValue()-160);
		}
		else {
			isHeight = false;
			percentage = primaryStage.getWidth()/oldValue.doubleValue();
		}
		
		updateMainPane(primaryStage, mainPane, isHeight, percentage);
		updateQuickNotesPane(primaryStage, quickNotesPane, isHeight, percentage);
	}
	
	public void updateMainPane(Stage primaryStage, Pane mainPane, boolean isHeight, double percentage) {
		if(isHeight) {
			mainPane.setPrefHeight(primaryStage.getHeight()-110-10);
			mainPane.getChildren().forEach(child -> {
				Control currentchild = ((Control)child);
				currentchild.setPrefHeight(currentchild.getHeight()*percentage);
			});
		}
		else {
			mainPane.setPrefWidth((primaryStage.getWidth()-50)*0.7);
			mainPane.getChildren().forEach(child -> {
				((Control)child).setPrefWidth((primaryStage.getWidth()-50)*0.7);
			});
		}
	}
	
	public void updateQuickNotesPane(Stage primaryStage, Pane quickNotesPane, boolean isHeight, double percentage) {
		if(isHeight) {			
			quickNotesPane.setPrefHeight(primaryStage.getHeight()-110-10);
			VBox quickNotesPaneVbox = ((VBox)quickNotesPane.getChildren().get(0));
			quickNotesPaneVbox.setPrefHeight(quickNotesPane.getHeight());
			quickNotesPaneVbox.getChildren().forEach(child -> {
				Control currentchild = ((Control)child);
				if(currentchild.getClass().equals(TextArea.class) || currentchild.getClass().equals(ListView.class)) {
					//TODO: Zu hohe abhängigkeit von Werten!!! auchan anderen Stellen besser machen
					currentchild.setPrefHeight((quickNotesPaneVbox.getHeight()-25-25-5-30-10-30-15-30-10)/2);
				}
			});
			
		}
		else {
			quickNotesPane.setPrefWidth((primaryStage.getWidth()-50)*0.3);
			VBox quickNotesPaneVbox = ((VBox)quickNotesPane.getChildren().get(0));
			quickNotesPaneVbox.setPrefWidth((primaryStage.getWidth()-50)*0.3);
			quickNotesPaneVbox.getChildren().forEach(child -> {
				((Control)child).setPrefWidth((primaryStage.getWidth()-50)*0.3);
			});
		}
		
	}
	
}
