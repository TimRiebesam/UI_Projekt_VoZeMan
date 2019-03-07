package application.Model.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MensaService {

	public void show(Pane mainPane, Pane mainWindowForRapla, WebView raplaWindowWebView) {
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mainWindowForRapla);
		mainWindowForRapla.setVisible(true);
		
		WebEngine webEngine = raplaWindowWebView.getEngine();
		webEngine.load(loadMensaPlan());
		System.out.println(loadMensaPlan());
	}
	
	private String loadMensaPlan() {
		return "https://www.sw-ka.de/de/essen/?pdf&gen&c=erzberger&p=1&d=" + getDateInYearMonthDateFormat();
	}
	
	private String getDateInYearMonthDateFormat() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
}