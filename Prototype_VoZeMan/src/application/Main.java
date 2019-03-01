package application;
	
import application.Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Hier anpassen um anderen Prototype zu testen!!!
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/prototype2.fxml"));
			Parent root = (Parent)loader.load();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/styles/application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("VoZeMan - DHBW Karlsruhe");
			primaryStage.show();
			
			Controller controller = (Controller)loader.getController();
			controller.setPrimaryStage(primaryStage);
		
			primaryStage.widthProperty().addListener(controller.getStageSizeListener());
			primaryStage.heightProperty().addListener(controller.getStageSizeListener());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}