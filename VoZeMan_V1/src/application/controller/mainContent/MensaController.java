package application.controller.mainContent;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;

public class MensaController implements Initializable{

    @FXML
    private GridPane gridPaneForMensa;

    @FXML
    private ImageView imageViewForMensa;
    
    private Image mensaPlanForToday;
    
    private static final int TOLERANCE_THRESHOLD = 0xFF;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageViewForMensa.fitHeightProperty().bind(gridPaneForMensa.heightProperty());
		imageViewForMensa.fitWidthProperty().bind(gridPaneForMensa.widthProperty());
		
		imageViewForMensa.setImage(new Image("application/view/img/loader.gif"));
	}
    
    public void loadMensaPlan() {
    	setMensaPlanAsync(imageViewForMensa);
    }
    
	private void setMensaPlanAsync(ImageView imageViewForMensa) {
		Thread setMensaPlan = new Thread(new Runnable() {
			@Override
			public void run() {				
				Image mensaPlan = getMensaPlanForToday();
				
				Runnable updateImageView = new Runnable() {
					@Override
					public void run() {
						imageViewForMensa.setImage(mensaPlan);
					}
				};
				
				Platform.runLater(updateImageView);
				
				Thread.currentThread().interrupt();
			}
		});
		
		setMensaPlan.setDaemon(true);
		setMensaPlan.start();
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
			
			Image image = SwingFXUtils.toFXImage(croppedImage, null);
		
			return makeTransparent(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private Image makeTransparent(Image inputImage) {
        int W = (int) inputImage.getWidth();
        int H = (int) inputImage.getHeight();
        WritableImage outputImage = new WritableImage(W, H);
        PixelReader reader = inputImage.getPixelReader();
        PixelWriter writer = outputImage.getPixelWriter();
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                int argb = reader.getArgb(x, y);

                int r = (argb >> 16) & 0xFF;
                int g = (argb >> 8) & 0xFF;
                int b = argb & 0xFF;

                if (r >= TOLERANCE_THRESHOLD 
                        && g >= TOLERANCE_THRESHOLD 
                        && b >= TOLERANCE_THRESHOLD) {
                    argb &= 0x00FFFFFF;
                }

                writer.setArgb(x, y, argb);
            }
        }

        return outputImage;
    }
	
	private String getDateInYearMonthDateFormat() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
    
}
