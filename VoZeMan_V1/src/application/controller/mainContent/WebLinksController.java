package application.controller.mainContent;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.ModelHandler;
import application.model.main.WebLinks;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebLinksController implements Initializable {

	@FXML
    private GridPane gridPaneForWebLinks;

    @FXML
    private WebView webViewForWebLinks;
    
    private WebLinks WebLinks = ModelHandler.getWebLinks();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadPage();
	}
    
    public void loadPage() {
    	WebEngine webEngineForWebLinks = webViewForWebLinks.getEngine();
    	webEngineForWebLinks.load(WebLinks.getCurrentUrl());
    }
	
}
