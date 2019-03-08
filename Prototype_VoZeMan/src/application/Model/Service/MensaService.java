package application.Model.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MensaService {

	public void show(Pane mainPane, Pane mainWindowForMensa, ImageView mensaWindowImageView) {
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mainWindowForMensa);
		mainWindowForMensa.setVisible(true);
		
		
	}
	
	private Image loadMensaPlanAsImage() {
		String pathToPdf = "https://www.sw-ka.de/de/essen/?pdf&gen&c=erzberger&p=1&d=" + getDateInYearMonthDateFormat();
		
		
		
		return null;
	}
	
	private String getDateInYearMonthDateFormat() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
}