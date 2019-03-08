package application.Controller;

import java.util.ArrayList;

import application.Model.Service.HandleServicesService;
import application.Model.Service.LecturererService;
import application.Model.Service.MensaService;
import application.Model.Service.MenuService;
import application.Model.Service.NotesService;
import application.Model.Service.RaplaService;
import application.Model.Service.RoomesService;
import application.Model.Service.SettingsService;
import application.Model.Service.StageResizeService;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Controller {
	
	//Information Label on Top of Application
	@FXML
	private Label pageTitle;
	
	//Main Menu Boxes and Controls
	@FXML
	private HBox menuHBox;
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
	//List containing all Menu Buttons. Adding Buttons to List at this Point is impossible because they aren't generated yet.
	//Adding Buttons to List in Method "checkMenuBtnList()"
	private ArrayList<Button> menuButtons = new ArrayList<Button>();
	
	//Secondary Menu Boxes and Controls
	@FXML
	private HBox secondaryMenuHBox;
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
	//List containing all Menu Buttons. Adding Buttons to List at this Point is impossible because they aren't generated yet.
	//Adding Buttons to List in Method "checkMenuSecondaryBtnList()"
	private ArrayList<Button> menuSecondaryButtons = new ArrayList<Button>();

	//Pane for Main Content
	@FXML
	private Pane mainPane;
	
	//TODO Delete when Start Page is choosen
	//Label with Text "Main Window"
	@FXML
	private Label mainWindowLabel;
	
	//Quick Notes Pane, Boxes and Controls
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
	
	//Main-Content-Window for Notes Page
	//Boxes and Controls for Notes-Windows
	@FXML
	private HBox mainWindowForNotes;
	@FXML
	private VBox vBoxForNotesWindowListView;
	@FXML
	private ListView<String> notesWindowListView;
	@FXML
	private VBox vBoxForNotesWindowEditArea;
	@FXML
	private TextField notesWindowTextField;
	@FXML
	private TextArea notesWindowTextArea;
	@FXML
	private Button notesWindowSaveBtn;
	
	//Main-Content-Window for Roomes Page
	//ImageView for Roomes
	@FXML
    private VBox mainWindowForRoomes;
    @FXML
    private TextField roomesWindowSearchField;
    @FXML
    private ImageView roomesWindowImageView;
    
    //Main-Content-Window for Rapla Page
  	//WebView for Rapla
    @FXML
    private Pane mainWindowForRapla;
    @FXML
    private WebView raplaWindowWebView;
    
    //Main-Content for Settings Page, Boxes and Controls
    @FXML
    private Pane mainWindowForSettings;
    @FXML
    private TextField raplaWindowTextField;
    @FXML
    private Label raplaWindowEintragenLabel;
    
    
    //Main-Content-Window for Mensa Page
  	//WebView for Mensa
    @FXML
    private Pane mainWindowForMensa;
    @FXML
    private WebView mensaWindowWebView;
	
	//Adding Services to Class (HandleServicesService to make other Services to an Singleton
	private MenuService menuService = HandleServicesService.getMenuService();
	private RaplaService raplaService = HandleServicesService.getRaplaService();
	private NotesService notesService = HandleServicesService.getNotesService();
	private RoomesService roomesService = HandleServicesService.getRoomesService();
	private MensaService mensaService = HandleServicesService.getMensaService();
	private LecturererService lecturererService = HandleServicesService.getLecturererService();
	private SettingsService settingsService = HandleServicesService.getSettingsService();
	private StageResizeService stageResizeService = HandleServicesService.getStageResizeService();

	//Primary-Stage
	private Stage primaryStage;
	//Method called in "Main.java" Class to use primaryStage inside of Controller
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	//Setting-Up Start-Up-Page
	public void loadStartPage() {
		menuService.changeMenu(menuButtons, menuRapla, menuSecondaryButtons, menuSecondaryBtnOne);
		raplaService.show(mainPane, mainWindowForRapla, raplaWindowWebView);
		stageResizeService.resizeStage(primaryStage, mainPane, quickNotesPane, menuHeight, independentQuickNotesHeight);
//		mainPane.getChildren().clear();
//		mainPane.getChildren().add(mainWindowLabel);
//		mainWindowLabel.setVisible(true);
		notesService.updateNotesView(notesTitleTextField, notesTextArea, notesListview, notesWindowListView);
	}
	
	//Variables for Resizing
	private double menuHeight;
	private double independentQuickNotesHeight;
	//Methods for Resizing
	public void calculateHeightsForResizing() {
		menuHeight = pageTitle.getHeight() + menuHBox.getHeight() + secondaryMenuHBox.getHeight() + 20;
		independentQuickNotesHeight = quickNotesLabel.getHeight() + notesTitleTextField.getHeight() +5 + saveNote.getHeight()+10 + lastSavedNotesLabel.getHeight()+15;
	}
	//Listening on Main Window Size
	ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue) -> {
		//stageResizeService.resizeStage(primaryStage, mainPane, quickNotesPane, menuHeight, independentQuickNotesHeight);
		stageResizeService.resizeEventHandler(primaryStage, mainPane, quickNotesPane, menuHeight, independentQuickNotesHeight);
	};
	//Get Listener-Method for "Main.java" Class
	public ChangeListener<Number> getStageSizeListener() {
		return this.stageSizeListener;
	}

	//Method called when User wants to change Menu
	//Setting-up menuButton-List
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

	//Method called when User wants to change Secondary-Menu
	//Setting-up menuSecondaryButton-List
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

	//Listening to Menu-Button clicks
	@FXML
	void changeMenu(ActionEvent event) {
		checkMenuBtnList();
		
		Button target = ((Button)event.getTarget());
		
		menuService.changeMenu(menuButtons, target, menuSecondaryButtons, menuSecondaryBtnOne);
		
		if(target.equals(menuRapla)) {
			//TODO load Rapla mainWindow
			raplaService.show(mainPane, mainWindowForRapla, raplaWindowWebView);
		}
		else if(target.equals(menuNotes)) {
			notesService.show(mainPane, mainWindowForNotes, notesWindowListView, notesListview);
		}
		else if(target.equals(menuRoomes)) {
			//TODO load Roomes mainWindow
			roomesService.show(mainPane, mainWindowForRoomes);
		}
		else if(target.equals(menuMensa)) {
			//TODO load Mensa mainWindow
			mensaService.show(mainPane, mainWindowForMensa, mensaWindowWebView);
		}
		else if(target.equals(menuLecturers)) {
			//TODO load Lectrueres mainWindow
			lecturererService.show(mainPane, mainWindowLabel);
		}
		else if(target.equals(menuSettings)) {
			//TODO load Settings mainWindow
			settingsService.show(mainPane, mainWindowForSettings);
		}
		
		stageResizeService.resizeStage(primaryStage, mainPane, quickNotesPane, menuHeight, independentQuickNotesHeight);
	}

	//Listening to Secondary-Menu-Button clicks
	@FXML
	void changeSecondaryMenu(ActionEvent event) {
		checkMenuSecondaryBtnList();
		menuService.changeSecondaryMenu(menuSecondaryButtons, ((Button)event.getTarget()));
	}

	@FXML
	void addNote(ActionEvent event) {
		notesService.addNote(notesTitleTextField, notesTextArea, notesListview, notesWindowListView);
	}
	
	@FXML
	void notesWindowShowNote(MouseEvent event) {
		int choosenItem = notesWindowListView.getSelectionModel().getSelectedIndex();
		if(choosenItem != -1) {
			notesService.showNote(choosenItem, mainPane, mainWindowForNotes, notesWindowListView, notesWindowTextField, notesWindowTextArea, notesListview);
		}
	}

	@FXML
	void showNote(MouseEvent event) {
		int choosenItem = notesListview.getSelectionModel().getSelectedIndex();
		if(choosenItem != -1) {
			menuService.changeMenu(menuButtons, menuNotes, menuSecondaryButtons, menuSecondaryBtnOne);
			notesService.showNote(choosenItem, mainPane, mainWindowForNotes, notesWindowListView, notesWindowTextField, notesWindowTextArea, notesListview);
			stageResizeService.resizeStage(primaryStage, mainPane, quickNotesPane, menuHeight, independentQuickNotesHeight);
		}
	}
	
	@FXML
	void noteTextChanged(Event event) {
		notesWindowSaveBtn.setDisable(false);
	}
	
	@FXML
	void noteWindowSaveChanges(ActionEvent event) {
		notesService.updateNote(notesListview.getSelectionModel().getSelectedIndex(), notesWindowTextField, notesWindowTextArea, notesWindowSaveBtn);
		notesService.show(mainPane, mainWindowForNotes, notesWindowListView, notesListview);
	}
	 

}
