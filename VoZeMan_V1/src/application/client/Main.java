package application.client;

import application.helper.ResizeHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/client/Window.fxml"));
			Parent root = (Parent)loader.load();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/client/style.css").toExternalForm());
			
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			
			Controller controller = loader.getController();
			controller.setPrimaryStage(primaryStage);
			controller.activateMoveHandler();
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("VoZeMan - DHBW Karlsruhe");
			primaryStage.setMinHeight(600);
			primaryStage.setMinWidth(900);
			
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
