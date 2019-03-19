package application.client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.helper.DefaultDataLoader;
import application.menu.MenuController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller implements Initializable{
	
	@FXML
    private GridPane mainGridPane;

    @FXML
    private ImageView logo;

    @FXML
    private HBox subMenuHBox;

    @FXML
    private Label subMenuLabel;
    
    @FXML
    private AnchorPane anchorPaneForHBox;
    
    private Stage primaryStage;
    
	private double xOffset = 0; 
	private double yOffset = 0;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			FXMLLoader menu =new FXMLLoader(getClass().getResource("/application/menu/Menu.fxml"));
			Pane menuPane = menu.load();
			GridPane menuLeft = (GridPane)menuPane.getChildren().get(0);
			GridPane menuTop = (GridPane)menuPane.getChildren().get(1);
			mainGridPane.add(menuLeft, 0, 1);
			mainGridPane.add(menuTop, 1, 0);
			
			DefaultDataLoader.loadDefaultData();
			
			((MenuController)menu.getController()).setStartMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void activateMoveHandler() {
		EventHandler<MouseEvent> mousePressed = new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	            xOffset = event.getSceneX();
	            yOffset = event.getSceneY();
	        }
	    };
		
		EventHandler<MouseEvent> mouseDragged = new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	        	if(primaryStage.isMaximized()) {
	        		primaryStage.setMaximized(false);
	        	}
	            primaryStage.setX(event.getScreenX() - xOffset);
	            primaryStage.setY(event.getScreenY() - yOffset);
	        }
	    };
		
	    EventHandler<MouseEvent> doubleClicked = new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent mouseEvent) {
	            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
	                if(mouseEvent.getClickCount() == 2){
	                    primaryStage.setMaximized(!primaryStage.isMaximized());
	                }
	            }
	        }
	    };
	    
	    mainGridPane.getChildren().get(0).setOnMouseClicked(doubleClicked);
		mainGridPane.getChildren().get(0).setOnMousePressed(mousePressed);
        mainGridPane.getChildren().get(0).setOnMouseDragged(mouseDragged);
        
        mainGridPane.getChildren().get(2).setOnMouseClicked(doubleClicked);
        mainGridPane.getChildren().get(2).setOnMousePressed(mousePressed);
        mainGridPane.getChildren().get(2).setOnMouseDragged(mouseDragged);
	}
	
}
