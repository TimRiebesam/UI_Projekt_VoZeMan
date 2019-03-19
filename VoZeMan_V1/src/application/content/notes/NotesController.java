package application.content.notes;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import org.controlsfx.glyphfont.FontAwesome;

import application.helper.ModelHandler;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class NotesController implements Initializable{

    @FXML
    private GridPane gridPaneForNotes;

    @FXML
    private TextField textfieldForNotesTitle;

    @FXML
    private Button newBtnForNotes;

    @FXML
    private Button saveBtnForNotes;

    @FXML
    private TextArea textareaForNotesText;

    @FXML
    private ListView<String> listViewForNotes;
    
    private NotesList notes = ModelHandler.getNotesList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		newBtnForNotes.setGraphic(new FontAwesome().create(FontAwesome.Glyph.PLUS).color(Color.WHITE).size(24));
		saveBtnForNotes.setGraphic(new FontAwesome().create(FontAwesome.Glyph.SAVE).color(Color.WHITE).size(24));
		saveBtnForNotes.setDisable(true);
		loadNotes();
	}
	
	private void loadNotes() {
		listViewForNotes.setItems(notes.getNoteTitlesWithTimestamp());
	}
    
	
	@FXML
	void saveNote(ActionEvent event) {
		int choosenItem = listViewForNotes.getSelectionModel().getSelectedIndex();
		if(choosenItem != -1) {
			Note noteToUpdate = notes.getNoteByIndex(choosenItem);
			noteToUpdate.setTitle(textfieldForNotesTitle.getText());
			noteToUpdate.setText(textareaForNotesText.getText());
		}
		else {
			notes.add(new Note(textfieldForNotesTitle.getText(), textareaForNotesText.getText(), new Date()));
			textfieldForNotesTitle.clear();
			textareaForNotesText.clear();
		}
		saveBtnForNotes.setDisable(true);
		loadNotes();
	}
	
	@FXML
	void newNote(ActionEvent event) {
		textfieldForNotesTitle.clear();
		textareaForNotesText.clear();
		saveBtnForNotes.setDisable(true);
		loadNotes();
		listViewForNotes.getSelectionModel().clearSelection();
	}
    
	@FXML
	void showNote(MouseEvent event) {
		int choosenItem = listViewForNotes.getSelectionModel().getSelectedIndex();
		if(choosenItem != -1) {
			Note choosenNote = notes.getNoteByIndex(choosenItem);
			textfieldForNotesTitle.setText(choosenNote.getTitle());
			textareaForNotesText.setText(choosenNote.getText());
		}
	}
	
	@FXML
	void checkForChanges(Event event) {
		if(!textareaForNotesText.getText().equals("") && !textfieldForNotesTitle.getText().equals("")) {
			saveBtnForNotes.setDisable(false);
		}
	}

}
