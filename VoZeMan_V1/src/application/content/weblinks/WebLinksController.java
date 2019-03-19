package application.content.weblinks;

import java.net.URL;
import java.util.ResourceBundle;

import application.helper.ModelHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebLinksController implements Initializable {

	@FXML
    private GridPane gridPaneForWebLinks;

    @FXML
    private WebView webViewForWebLinks;
    
    @FXML
    private Label labelForWebPageTitleForWebLinks;
    
    private WebLinks webLinks = ModelHandler.getWebLinks();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadPage();
	}
    
    public void loadPage() {
    	labelForWebPageTitleForWebLinks.setText(webLinks.getCurrentPageTitle());
    	WebEngine webEngineForWebLinks = webViewForWebLinks.getEngine();
    	webEngineForWebLinks.load(webLinks.getCurrentUrl());
    }
	
}
