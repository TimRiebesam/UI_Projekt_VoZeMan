package application.Model.Service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MensaService {

	public void show(Pane mainPane, Pane mainWindowForMensa, ImageView mensaWindowImageView) {
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mainWindowForMensa);
		mainWindowForMensa.setVisible(true);
		
		
		
		mensaWindowImageView.setImage(loadMensaPlanAsImage().iterator().next());
	}
	
	private List<Image> loadMensaPlanAsImage() {
		List<Image> images = new ArrayList<>();
		String pathToPdf = "https://www.sw-ka.de/de/essen/?pdf&gen&c=erzberger&p=1&d=" + getDateInYearMonthDateFormat();
		
		try {
			PDDocument document = PDDocument.loadNonSeq(new File(pathToPdf), null);
			List<PDPage> pdPages = document.getDocumentCatalog().getAllPages();
			
			int page = 0;
			for (PDPage pdPage : pdPages)
			{ 
			    ++page;
			    BufferedImage bimg = pdPage.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
			    images.add(SwingFXUtils.toFXImage(bimg, null));
			}
			document.close();
			return images;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String getDateInYearMonthDateFormat() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
}