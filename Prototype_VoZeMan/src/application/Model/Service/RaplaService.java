package application.Model.Service;

import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class RaplaService {

	public void show(Pane mainPane, Pane mainWindowForRapla, WebView raplaWindowWebView) {
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mainWindowForRapla);
		mainWindowForRapla.setVisible(true);
		
		WebEngine webEngine = raplaWindowWebView.getEngine();
		webEngine.load(HandleServicesService.getSettingsService().getRaplaUrl());
	}

}
