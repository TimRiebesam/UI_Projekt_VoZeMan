package application;
	
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
			Parent root = FXMLLoader.load(getClass().getResource("/view/prototype2.fxml"));
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/styles/application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("VoZeMan - DHBW Karlsruhe");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}