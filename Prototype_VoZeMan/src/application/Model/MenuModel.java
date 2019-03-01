package application.Model;

import java.util.ArrayList;

import javafx.scene.control.Button;

public class MenuModel {
	
	public void changeMenu(ArrayList<Button> menuButtons, Button target, ArrayList<Button> menuSecondaryButtons, Button targetSecondary) {
		menuButtons.forEach(btn -> {
    		btn.getStyleClass().remove("btn-menu-not-active");
    		btn.getStyleClass().remove("btn-menu-active");
    		btn.getStyleClass().add("btn-menu-not-active");
    	});

    	target.getStyleClass().remove("btn-menu-not-active");
    	target.getStyleClass().add("btn-menu-active");
    	changeSecondaryMenu(menuSecondaryButtons, targetSecondary);
	}
	
	public void changeSecondaryMenu(ArrayList<Button> menuSecondaryButtons, Button target) {
		menuSecondaryButtons.forEach(btn -> {
    		btn.getStyleClass().remove("btn-secondary-edge-active");
    		btn.getStyleClass().remove("btn-secondary-edge");
    		btn.getStyleClass().add("btn-secondary-edge");
    	});

		target.getStyleClass().remove("btn-secondary-edge");
		target.getStyleClass().add("btn-secondary-edge-active");
	}
	
}
