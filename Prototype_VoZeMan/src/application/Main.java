package application;
	
import application.Model.Service.HandleServicesService;
import application.controller.Controller;
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/view.fxml"));
			Parent root = (Parent)loader.load();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/view/styles/application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("VoZeMan - DHBW Karlsruhe");
			primaryStage.setMinHeight(480);
			primaryStage.setMinWidth(650);
			primaryStage.show();
			
			HandleServicesService.getExamlpeDataService().addExampleDataToApplication();
			
			Controller controller = (Controller)loader.getController();
			controller.setPrimaryStage(primaryStage);
			controller.calculateHeightsForResizing();
			controller.loadStartPage();
		
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