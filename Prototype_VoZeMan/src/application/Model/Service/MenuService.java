package application.Model.Service;

import java.util.ArrayList;

import javafx.scene.control.Button;

public class MenuService {
	
	public void changeMenu(ArrayList<Button> menuButtons, Button target, ArrayList<Button> menuSecondaryButtons, Button targetSecondary) {
		menuButtons.forEach(btn -> {
    		btn.getStyleClass().remove("btn-menu-not-active");
    		btn.getStyleClass().remove("btn-menu-active");
    		btn.getStyleClass().add("btn-menu-not-active");
    	});

    	target.getStyleClass().remove("btn-menu-not-active");
    	target.getStyleClass().add("btn-menu-active");
    	changeSecondaryMenu(menuSecondaryButtons, targetSecondary, target);
	}
	
	public void changeSecondaryMenu(ArrayList<Button> menuSecondaryButtons, Button targetSecondary, Button targetFirst) {
		menuSecondaryButtons.forEach(btn -> {
    		btn.getStyleClass().remove("btn-secondary-edge-active");
    		btn.getStyleClass().remove("btn-secondary-edge");
    		btn.getStyleClass().add("btn-secondary-edge");
    	});

		targetSecondary.getStyleClass().remove("btn-secondary-edge");
		targetSecondary.getStyleClass().add("btn-secondary-edge-active");
		
		updateSecondaryMenuLabels(menuSecondaryButtons, targetSecondary, targetFirst);
	}
	
	public Button getcurrentMenuOption(ArrayList<Button> btnList) {		
		for(Button button : btnList) {
			if(button.getStyleClass().contains("btn-menu-active")) {
				return button;
			}
		}
		return null;
	}
	
	public Button getcurrentMenuOptionSecondary(ArrayList<Button> btnList) {		
		for(Button button : btnList) {
			if(button.getStyleClass().contains("btn-secondary-edge-active")) {
				return button;
			}
		}
		return null;
	}

	private void updateSecondaryMenuLabels(ArrayList<Button> menuSecondaryButtons, Button targetSecondary, Button targetFirst) {
		switch (targetFirst.getId()) {
		case "menuRapla":
			setSecondaryButtonsForRapla(menuSecondaryButtons);
			break;

		default:
			setAllSecondaryButtonsInvisible(menuSecondaryButtons);
			break;
		}
	}
	
	private void setAllSecondaryButtonsInvisible(ArrayList<Button> menuSecondaryButtons) {
		menuSecondaryButtons.forEach(button -> {
			button.setVisible(false);
		});
		menuSecondaryButtons.get(0).setText("Main");
		menuSecondaryButtons.get(0).setVisible(true);
	}
	
	private void setSecondaryButtonsForRapla(ArrayList<Button> menuSecondaryButtons) {
		menuSecondaryButtons.get(0).setText("Rapla");
		menuSecondaryButtons.get(1).setText("Moodle");
		menuSecondaryButtons.get(2).setText("Dualis");
		
		menuSecondaryButtons.get(0).setVisible(true);
		menuSecondaryButtons.get(1).setVisible(true);
		menuSecondaryButtons.get(2).setVisible(true);
		menuSecondaryButtons.get(3).setVisible(false);
		menuSecondaryButtons.get(4).setVisible(false);
		menuSecondaryButtons.get(5).setVisible(false);
	}
	
}
