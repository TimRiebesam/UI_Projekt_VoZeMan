package application.Model.Service;

import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class StageResizeService {
	
	private boolean resizing = false;
	
	private long currentTimeMillis;
	
	public void resizeEventHandler(Stage primaryStage, Pane mainPane, Pane quickNotesPane, double menuHeight, double independentQuickNotesHeight) {
		currentTimeMillis = System.currentTimeMillis();
		if(!resizing) {
			resizing = true;
			Thread t1 = new Thread(new Runnable() {
				public void run() {
					while(resizing) {
						if(System.currentTimeMillis() > currentTimeMillis+100) {
							resizing = false;
							resizeStage(primaryStage, mainPane, quickNotesPane, menuHeight, independentQuickNotesHeight);
							Thread.currentThread().interrupt();
						}
						else {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			});
			t1.start();
		}
	}
	
	public void resizeStage(Stage primaryStage, Pane mainPane, Pane quickNotesPane, double menuHeight, double independentQuickNotesHeight) {
		updateMainPane(primaryStage, mainPane, menuHeight);
		updateQuickNotesPane(primaryStage, quickNotesPane, menuHeight, independentQuickNotesHeight);
	}
	
	private void updateMainPane(Stage primaryStage, Pane mainPane, double menuHeight) {	
		switch (mainPane.getChildren().get(0).getId()) {
		case "mainWindowForNotes":
			resizeNotesWindow(primaryStage, mainPane, menuHeight);
			break;

		case "mainWindowForRoomes":
			resizeRoomesWindow(primaryStage, mainPane, menuHeight);
			break;
			
		case "mainWindowForRapla":
			resizeRaplaWindow(primaryStage, mainPane, menuHeight);
			break;
			
		case "mainWindowForMensa":
			resizeMensaWindow(primaryStage, mainPane, menuHeight);
			break;
			
		default:
			resizeMainPane(primaryStage, mainPane, menuHeight);
			((Control)mainPane.getChildren().get(0)).setPrefSize(mainPane.getWidth(), mainPane.getHeight());
			mainPane.getChildren().get(0).autosize();
			break;
		}
	}
	
	private void resizeNotesWindow(Stage primaryStage, Pane mainPane, double menuHeight) {
		resizeMainPane(primaryStage, mainPane, menuHeight);
		Pane content = (Pane)mainPane.getChildren().get(0);
		resizeMainPane(primaryStage, content, menuHeight);
		
		
		Pane left = (Pane)content.getChildren().get(0);
		left.setPrefSize(content.getWidth()*0.35, content.getHeight());
		left.autosize();
		
		Control leftFirstControl = (Control)left.getChildren().get(0);
		leftFirstControl.setPrefSize(left.getWidth()-10, left.getHeight());
		leftFirstControl.autosize();
		
		
		Pane right = (Pane)content.getChildren().get(1);
		right.setPrefSize(content.getWidth()*0.65, content.getHeight());
		right.autosize();
		
		Control rightFirstControl = (Control)right.getChildren().get(0);
		rightFirstControl.setPrefSize(right.getWidth(), right.getHeight()*0.066);
		rightFirstControl.autosize();
		
		Control rightSecondControl = (Control)right.getChildren().get(1);
		rightSecondControl.setPrefSize(right.getWidth(), right.getHeight()*.85);
		rightSecondControl.autosize();
		
		Control rightThirdControl = (Control)right.getChildren().get(2);
		rightThirdControl.setPrefSize(right.getWidth(), right.getHeight()*0.05);
		rightThirdControl.autosize();
	}
	
	private void resizeRoomesWindow(Stage primaryStage, Pane mainPane, double menuHeight) {
		resizeMainPane(primaryStage, mainPane, menuHeight);
		Pane content = (Pane)mainPane.getChildren().get(0);
		resizeMainPane(primaryStage, content, menuHeight);
		
		Pane searchHBox = (Pane)content.getChildren().get(0);
		
		Control searchField = (Control)searchHBox.getChildren().get(0);
		Control searchBtn = (Control)searchHBox.getChildren().get(1);
		searchField.setPrefWidth(content.getWidth()-searchBtn.getWidth()-10);
		searchField.autosize();
		
		Control searchLabel = (Control)content.getChildren().get(1);
		searchLabel.setPrefWidth(content.getWidth());
		searchLabel.autosize();
		
		ImageView image = (ImageView)content.getChildren().get(2);
		image.setFitHeight(content.getHeight()-searchField.getHeight()-searchLabel.getHeight());
		image.autosize();
	}
	
	private void resizeRaplaWindow(Stage primaryStage, Pane mainPane, double menuHeight) {
		resizeMainPane(primaryStage, mainPane, menuHeight);
		Pane content = (Pane)mainPane.getChildren().get(0);
		resizeMainPane(primaryStage, content, menuHeight);
		
		WebView web = (WebView)content.getChildren().get(0);
		web.setPrefSize(content.getWidth(), content.getHeight());
		web.autosize();
	}
	
	private void resizeMensaWindow(Stage primaryStage, Pane mainPane, double menuHeight) {
		resizeMainPane(primaryStage, mainPane, menuHeight);
		Pane content = (Pane)mainPane.getChildren().get(0);
		resizeMainPane(primaryStage, content, menuHeight);
		
		ImageView image = (ImageView)content.getChildren().get(0);
		image.setFitWidth(content.getWidth());
		image.setFitHeight(content.getHeight());
		image.autosize();
	}
	
	private void resizeMainPane(Stage primaryStage, Pane mainPane, double menuHeight) {
		mainPane.setPrefSize((primaryStage.getWidth()-50)*0.7, primaryStage.getHeight()-menuHeight-35);
		mainPane.autosize();
	}
	
	private void updateQuickNotesPane(Stage primaryStage, Pane quickNotesPane, double menuHeight, double independentQuickNotesHeight) {
		quickNotesPane.setPrefSize((primaryStage.getWidth()-50)*0.3, primaryStage.getHeight()-menuHeight-40);
		quickNotesPane.autosize();
		
		Control separator = ((Control)quickNotesPane.getChildren().get(0));
		separator.setPrefHeight(quickNotesPane.getHeight());
		separator.autosize();
		
		VBox quickNotesPaneVbox = ((VBox)quickNotesPane.getChildren().get(1));
		quickNotesPaneVbox.setPrefSize((primaryStage.getWidth()-50)*0.3, quickNotesPane.getHeight());
		quickNotesPaneVbox.autosize();
		
		quickNotesPaneVbox.getChildren().forEach(child -> {
			Control currentchild = ((Control)child);
			currentchild.setPrefWidth((primaryStage.getWidth()-50)*0.3);
			currentchild.autosize();
			if(currentchild.getClass().equals(TextArea.class) || currentchild.getClass().equals(ListView.class)) {
				currentchild.setPrefHeight((quickNotesPaneVbox.getHeight()-independentQuickNotesHeight)/2);
				currentchild.autosize();
			}
		});
		
	}
	
}
