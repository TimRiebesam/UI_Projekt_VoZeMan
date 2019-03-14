package application.controller.menu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.glyphfont.FontAwesome;

import application.model.ModelHandler;
import application.model.menu.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuController implements Initializable{

	@FXML
	private GridPane menuTop;

	@FXML
	private Button raplaBtn;

	@FXML
	private Button moodleBtn;

	@FXML
	private Button dualisBtn;

	@FXML
	private Pane paneForMinimize;

	@FXML
	private Pane paneForMaximize;

	@FXML
	private Pane paneForClose;

	@FXML
	private GridPane menuLeft;

	@FXML
	private Button weblinksBtn;

	@FXML
	private Button notesBtn;

	@FXML
	private Button roomesBtn;

	@FXML
	private Button mensaBtn;

	@FXML
	private Button lecturerBtn;

	@FXML
	private Button settingsBtn;

	@FXML
	private Label copyrightLabel;

	Pane webLinksPane;
	Pane notesPane; 
	Pane roomesPane;
	Pane mensaPane;
	Pane lecturerPane;
	Pane settingsPane;

	Menu menu = ModelHandler.getMenu();

	List<Button> menuButtons = new ArrayList<Button>();
	List<Button> menuTopButtons = new ArrayList<Button>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			webLinksPane = FXMLLoader.load(getClass().getResource("/application/view/mainContent/WebLinks.fxml"));
			notesPane = FXMLLoader.load(getClass().getResource("/application/view/mainContent/Notes.fxml"));
			roomesPane = FXMLLoader.load(getClass().getResource("/application/view/mainContent/Roomes.fxml"));
			mensaPane = FXMLLoader.load(getClass().getResource("/application/view/mainContent/Mensa.fxml"));
			lecturerPane = FXMLLoader.load(getClass().getResource("/application/view/mainContent/Lecturer.fxml"));
			settingsPane = FXMLLoader.load(getClass().getResource("/application/view/mainContent/Settings.fxml"));

			menuButtons.add(weblinksBtn);
			menuButtons.add(notesBtn);
			menuButtons.add(roomesBtn);
			menuButtons.add(lecturerBtn);
			menuButtons.add(settingsBtn);
			menuButtons.add(mensaBtn);

			menuTopButtons.add(raplaBtn);
			menuTopButtons.add(moodleBtn);
			menuTopButtons.add(dualisBtn);
			
			setControlBtns();
			setGraphicsForMenuBtns();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setControlBtns() {
		Button minimizeBtn = new Button();
		minimizeBtn.setGraphic(new FontAwesome().create(FontAwesome.Glyph.MINUS).color(Color.WHITE).size(18));
		minimizeBtn.getStyleClass().add("control-btn");
		minimizeBtn.setCursor(Cursor.HAND);
		minimizeBtn.setOnAction((event) -> {
			((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
		});
		
		Button maximizeBtn = new Button();
		maximizeBtn.setGraphic(new FontAwesome().create(FontAwesome.Glyph.EXPAND).color(Color.WHITE).size(18));
		maximizeBtn.getStyleClass().add("control-btn");
		maximizeBtn.setCursor(Cursor.HAND);
		maximizeBtn.setOnAction((event) -> {
			Stage stage = ((Stage)((Button)event.getSource()).getScene().getWindow());
			stage.setMaximized(!stage.isMaximized());
		});
		
		Button closeBtn = new Button();
		closeBtn.setGraphic(new FontAwesome().create(FontAwesome.Glyph.TIMES).color(Color.WHITE).size(18));
		closeBtn.getStyleClass().add("control-btn");
		closeBtn.setCursor(Cursor.HAND);
		closeBtn.setOnAction((event) -> {
			((Stage)((Button)event.getSource()).getScene().getWindow()).close();
		});
		
		paneForMinimize.getChildren().add(minimizeBtn);
		paneForMaximize.getChildren().add(maximizeBtn);
		paneForClose.getChildren().add(closeBtn);
	}

	private void setGraphicsForMenuBtns(){
		weblinksBtn.setGraphic(new FontAwesome().create(FontAwesome.Glyph.LINK).color(Color.WHITE).size(26));
		notesBtn.setGraphic(new FontAwesome().create(FontAwesome.Glyph.LIST).color(Color.WHITE).size(26));
		roomesBtn.setGraphic(new FontAwesome().create(FontAwesome.Glyph.HOME).color(Color.WHITE).size(26));
		mensaBtn.setGraphic(new FontAwesome().create(FontAwesome.Glyph.COFFEE).color(Color.WHITE).size(26));
		lecturerBtn.setGraphic(new FontAwesome().create(FontAwesome.Glyph.USER).color(Color.WHITE).size(26));
		settingsBtn.setGraphic(new FontAwesome().create(FontAwesome.Glyph.SLIDERS).color(Color.WHITE).size(26));

	}
	
	@FXML
	void setMainWindow(ActionEvent event) {
		Button source = ((Button)event.getSource());
		GridPane mainPane = getMainPaneFromMenuBtnEvent(event);

		if(menu.getCurrentContent() != null) {
			mainPane.getChildren().remove(menu.getCurrentContent());
		}

		if(source.equals(weblinksBtn)) {
			updateMainWindowAndMenu(mainPane, webLinksPane, source, raplaBtn);
		}
		else if (source.equals(notesBtn)) {
			updateMainWindowAndMenu(mainPane, notesPane, source);
		}
		else if (source.equals(roomesBtn)) {
			updateMainWindowAndMenu(mainPane, roomesPane, source);
		}
		else if (source.equals(mensaBtn)) {
			updateMainWindowAndMenu(mainPane, mensaPane, source);
		}
		else if (source.equals(lecturerBtn)) {
			updateMainWindowAndMenu(mainPane, lecturerPane, source);
		}
		else if (source.equals(settingsBtn)) {
			updateMainWindowAndMenu(mainPane, settingsPane, source);
		}
		else if (source.equals(raplaBtn)) {
			updateTopMenu(source);
		}
		else if (source.equals(moodleBtn)) {
			updateTopMenu(source);
		}
		else if (source.equals(dualisBtn)) {
			updateTopMenu(source);
		}		
	}

	private void updateMainWindowAndMenu(GridPane mainPane, Pane newContentPane, Button newMenuBtn, Button newTopMenuBtn) {
		mainPane.add(newContentPane, 1, 1);

		updateMenuButtons(newMenuBtn);
		updateMenuTopButtons(newTopMenuBtn);

		menu.setCurrentContent(newContentPane);
		menu.setCurrentMainButton(newMenuBtn);
		menu.setCurrentTopButton(newTopMenuBtn);
	}

	private void updateTopMenu(Button newTopMenuBtn) {
		updateMenuTopButtons(newTopMenuBtn);
	}

	private void updateMainWindowAndMenu(GridPane mainPane, Pane newContentPane, Button newMenuBtn) {
		mainPane.add(newContentPane, 1, 1);

		updateMenuButtons(newMenuBtn);
		updateMenuTopButtons(null);

		menu.setCurrentContent(newContentPane);
		menu.setCurrentMainButton(newMenuBtn);
		menu.setCurrentTopButton(null);
	}

	private void updateMenuButtons(Button btn) {
		if(menu.getCurrentMainButton() != null) {
			menu.getCurrentMainButton().getStyleClass().remove("bg-darkgrey");
		}
		menu.setCurrentMainButton(btn);
		btn.getStyleClass().add("bg-darkgrey");
	}

	private void updateMenuTopButtons(Button btn) {
		if(menu.getCurrentTopButton() != null) {
			menu.getCurrentTopButton().getStyleClass().remove("underline");
		}
		menu.setCurrentTopButton(btn);
		if(btn != null) {
			btn.getStyleClass().add("underline");
		}
	}

	private GridPane getMainPaneFromMenuBtnEvent(ActionEvent event) {
		return (GridPane)((Button)event.getSource()).getParent().getParent();
	}

}
