package application.menu;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Menu {

	private Button currentMainButton;
	private Button currentTopButton;
	private Object currentContent;
	private Pane currentPane;
	private Object currentController;

	public Button getCurrentMainButton() {
		return currentMainButton;
	}
	public void setCurrentMainButton(Button currentMainButton) {
		this.currentMainButton = currentMainButton;
	}
	public Button getCurrentTopButton() {
		return currentTopButton;
	}
	public void setCurrentTopButton(Button currentTopButton) {
		this.currentTopButton = currentTopButton;
	}
	public Object getCurrentContent() {
		return currentContent;
	}
	public void setCurrentContent(Object currentContent) {
		this.currentContent = currentContent;
	}
	public Pane getCurrentPane() {
		return currentPane;
	}
	public void setCurrentPane(Pane currentPane) {
		this.currentPane = currentPane;
	}
	public Object getCurrentController() {
		return currentController;
	}
	public void setCurrentController(Object currentController) {
		this.currentController = currentController;
	}
	
}
