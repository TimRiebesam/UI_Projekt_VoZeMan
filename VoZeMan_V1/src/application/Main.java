package application;

import application.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Window.fxml"));
			Parent root = (Parent)loader.load();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/view/css/style.css").toExternalForm());
			
			Font.loadFont(getClass().getResourceAsStream("/application/view/font/FontAwesome-Solid"), 14);
			Font.loadFont(getClass().getResourceAsStream("/application/view/font/FontAwesome-Regular"), 14);
			
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			Controller controller = loader.getController();
			controller.setPrimaryStage(primaryStage);
			controller.activateMoveHandler();
				        
			primaryStage.setScene(scene);
			primaryStage.setTitle("VoZeMan - DHBW Karlsruhe");
			primaryStage.setMinHeight(600);
			primaryStage.setMinWidth(800);
			
			ResizeHelper.addResizeListener(primaryStage);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
