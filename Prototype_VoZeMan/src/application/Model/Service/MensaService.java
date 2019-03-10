package application.Model.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MensaService {
	
	private Image mensaPlanForToday;

	public void show(Pane mainPane, Pane mainWindowForMensa, ImageView mensaWindowImageView) {
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mainWindowForMensa);
		mainWindowForMensa.setVisible(true);
		
		//TODO wird nicht angezeigt weil direkt überschrieben!
		mensaWindowImageView.setImage(new Image("application/view/img/loading-loop.gif"));
		
		mensaWindowImageView.setImage(getMensaPlanForToday());
	}
	
	private Image getMensaPlanForToday() {
		if(mensaPlanForToday == null) {
			String pathToPdf = "https://www.sw-ka.de/de/essen/?pdf&gen&c=erzberger&p=1&d=" + getDateInYearMonthDateFormat();
			mensaPlanForToday = loadMensaPlanAsImage(pathToPdf);
		}
		return mensaPlanForToday;
	}
	
	private Image loadMensaPlanAsImage(String pathToPdf) {
		try {
			PDDocument pdfFromWeb = PDDocument.load(new URL(pathToPdf));
			
			PDPage pageOne = (PDPage)pdfFromWeb.getDocumentCatalog().getAllPages().get(0);
			
			BufferedImage originalBimg = pageOne.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
			BufferedImage croppedImage = originalBimg.getSubimage(0, 0, originalBimg.getWidth(), originalBimg.getHeight()/2);
			
			pdfFromWeb.close();
			
			return SwingFXUtils.toFXImage(croppedImage, null);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String getDateInYearMonthDateFormat() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
}