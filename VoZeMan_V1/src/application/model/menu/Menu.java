package application.model.menu;

import javafx.scene.control.Button;

public class Menu {

	private Button currentMainButton;
	private Button currentTopButton;
	private Object currentContent;

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
	
}
