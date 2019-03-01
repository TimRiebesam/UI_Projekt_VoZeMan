package application.Controller;

import java.util.ArrayList;

import application.Model.Service.MenuService;
import application.Model.Service.NotesService;
import application.Model.Service.StageResizeService;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {

	@FXML
	private Label pageTitle;

	@FXML
	private Button menuRapla;

	@FXML
	private Button menuNotes;

	@FXML
	private Button menuRoomes;

	@FXML
	private Button menuMensa;

	@FXML
	private Button menuLecturers;

	@FXML
	private Button menuSettings;

	private ArrayList<Button> menuButtons = new ArrayList<Button>();

	@FXML
	private Button menuSecondaryBtnOne;

	@FXML
	private Button menuSecondaryBtnTwo;

	@FXML
	private Button menuSecondaryBtnThree;

	@FXML
	private Button menuSecondaryBtnFour;

	@FXML
	private Button menuSecondaryBtnFive;

	@FXML
	private Button menuSecondaryBtnSix;

	private ArrayList<Button> menuSecondaryButtons = new ArrayList<Button>();

	@FXML
	private Label mainWindowLabel;

	@FXML
	private Pane mainPane;
	
	@FXML
	private Pane quickNotesPane;

	@FXML
	private VBox btnSaveNotes;

	@FXML
	private Label quickNotesLabel;

	@FXML
	private TextArea notesTextArea;

	@FXML
	private TextField notesTitleTextField;

	@FXML
	private Label lastSavedNotesLabel;

	@FXML
	private ListView<String> notesListview;

	@FXML
	private Button saveNote;

	@FXML
	private Button showNote;

	MenuService menuModel = new MenuService();

	NotesService notesModel = new NotesService();

	private Stage primaryStage;
	
	private StageResizeService stageResizeService = new StageResizeService();
	
	ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue) -> {
		stageResizeService.ResizeStage(primaryStage, mainPane, quickNotesPane, oldValue, observable.toString().split("name: ")[1].split(",")[0]);
	};
	
	public ChangeListener<Number> getStageSizeListener() {
		return this.stageSizeListener;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	private void checkMenuBtnList() {
		if(menuButtons.size() == 0) {
			menuButtons.add(menuRapla);
			menuButtons.add(menuNotes);
			menuButtons.add(menuRoomes);
			menuButtons.add(menuMensa);
			menuButtons.add(menuLecturers);
			menuButtons.add(menuSettings);
		}
	}

	private void checkMenuSecondaryBtnList() {
		if(menuSecondaryButtons.size() == 0) {
			menuSecondaryButtons.add(menuSecondaryBtnOne);
			menuSecondaryButtons.add(menuSecondaryBtnTwo);
			menuSecondaryButtons.add(menuSecondaryBtnThree);
			menuSecondaryButtons.add(menuSecondaryBtnFour);
			menuSecondaryButtons.add(menuSecondaryBtnFive);
			menuSecondaryButtons.add(menuSecondaryBtnSix);
		}
	}

	@FXML
	void changeMenu(ActionEvent event) {
		checkMenuBtnList();
		menuModel.changeMenu(menuButtons, ((Button)event.getTarget()), menuSecondaryButtons, menuSecondaryBtnOne);
	}

	@FXML
	void changeSecondaryMenu(ActionEvent event) {
		checkMenuSecondaryBtnList();
		menuModel.changeSecondaryMenu(menuSecondaryButtons, ((Button)event.getTarget()));
	}

	@FXML
	void addNote(ActionEvent event) {
		notesModel.addNote(notesTitleTextField, notesTextArea, notesListview);
	}

	@FXML
	void showNote(ActionEvent event) {
		//notesModel.showNote(notesListview, menuModel, menuButtons, menuNotes);
		
		//TODO HIER GEHTS WEITER!
		//Ersetzen des aktuellen mainWindow inhalts gegen Notes Window
		if(notesListview.getSelectionModel().getSelectedIndex() != -1) {
			menuModel.changeMenu(menuButtons, menuNotes, menuSecondaryButtons, menuSecondaryBtnOne);
			mainPane.getChildren().clear();
			mainPane.getChildren().add(mainWindowLabel);
		}
	}

}
