package application.helper;

import org.controlsfx.glyphfont.FontAwesome;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

//created by Alexander Berg
public class ResizeHelper {
	
	private static boolean isMax = false;
	private static double stageX;
	private static double stageY;
	private static double stageWidth;
	private static double stageHeight;
	
	private static Button maximizeBtn;
	
	private static Button getMaximizeBtn(Stage stage) {
		if(maximizeBtn == null) {
			maximizeBtn = (Button)stage.getScene().lookup("#maximizeBtn");
		}
		return maximizeBtn;
	}
	
	public static void changeMaximize(Stage stage) {
		if(!isMax) {
			isMax = !isMax;
			
			stageX = stage.getX();
			stageY = stage.getY();
			stageWidth = stage.getWidth();
			stageHeight = stage.getHeight();
			
			Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	    	stage.setX(primaryScreenBounds.getMinX());
	    	stage.setY(primaryScreenBounds.getMinY());

	    	stage.setMaxWidth(primaryScreenBounds.getWidth());
	    	stage.setMinWidth(primaryScreenBounds.getWidth());

	    	stage.setMaxHeight(primaryScreenBounds.getHeight());
	    	stage.setMinHeight(primaryScreenBounds.getHeight());
	    	
	    	getMaximizeBtn(stage).setGraphic(new FontAwesome().create(FontAwesome.Glyph.COMPRESS).color(Color.WHITE).size(18));
		}
		
		else {
			isMax = !isMax;
			
			stage.setX(stageX);
	    	stage.setY(stageY);

	    	stage.setMaxWidth(stageWidth);
	    	stage.setMinWidth(stageWidth);

	    	stage.setMaxHeight(stageHeight);
	    	stage.setMinHeight(stageHeight);
	    	
			getMaximizeBtn(stage).setGraphic(new FontAwesome().create(FontAwesome.Glyph.EXPAND).color(Color.WHITE).size(18));
		}
	}
	
	public static boolean isMaximized() {
		return isMax;
	}

    public static void addResizeListener(Stage stage) {
        ResizeListener resizeListener = new ResizeListener(stage);
        stage.getScene().addEventHandler(MouseEvent.MOUSE_MOVED, resizeListener);
        stage.getScene().addEventHandler(MouseEvent.MOUSE_PRESSED, resizeListener);
        stage.getScene().addEventHandler(MouseEvent.MOUSE_DRAGGED, resizeListener);
        stage.getScene().addEventHandler(MouseEvent.MOUSE_EXITED, resizeListener);
        stage.getScene().addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, resizeListener);
        ObservableList<Node> children = stage.getScene().getRoot().getChildrenUnmodifiable();
        for (Node child : children) {
            addListenerDeeply(child, resizeListener);
        }
    }

    public static void addListenerDeeply(Node node, EventHandler<MouseEvent> listener) {
        node.addEventHandler(MouseEvent.MOUSE_MOVED, listener);
        node.addEventHandler(MouseEvent.MOUSE_PRESSED, listener);
        node.addEventHandler(MouseEvent.MOUSE_DRAGGED, listener);
        node.addEventHandler(MouseEvent.MOUSE_EXITED, listener);
        node.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, listener);
        if (node instanceof Parent) {
            Parent parent = (Parent) node;
            ObservableList<Node> children = parent.getChildrenUnmodifiable();
            for (Node child : children) {
                addListenerDeeply(child, listener);
            }
        }
    }

    static class ResizeListener implements EventHandler<MouseEvent> {
        private Stage stage;
        private Cursor cursorEvent = Cursor.DEFAULT;
        private int border = 4;
        private double startX = 0;
        private double startY = 0;

        public ResizeListener(Stage stage) {
            this.stage = stage;
        }

        @Override
        public void handle(MouseEvent mouseEvent) {
            EventType<? extends MouseEvent> mouseEventType = mouseEvent.getEventType();
            Scene scene = stage.getScene();

            double mouseEventX = mouseEvent.getSceneX(), 
                   mouseEventY = mouseEvent.getSceneY(),
                   sceneWidth = scene.getWidth(),
                   sceneHeight = scene.getHeight();

            if (MouseEvent.MOUSE_MOVED.equals(mouseEventType) == true) {
                if (mouseEventX < border && mouseEventY < border) {
                    cursorEvent = Cursor.NW_RESIZE;
                } else if (mouseEventX < border && mouseEventY > sceneHeight - border) {
                    cursorEvent = Cursor.SW_RESIZE;
                } else if (mouseEventX > sceneWidth - border && mouseEventY < border) {
                    cursorEvent = Cursor.NE_RESIZE;
                } else if (mouseEventX > sceneWidth - border && mouseEventY > sceneHeight - border) {
                    cursorEvent = Cursor.SE_RESIZE;
                } else if (mouseEventX < border) {
                    cursorEvent = Cursor.W_RESIZE;
                } else if (mouseEventX > sceneWidth - border) {
                    cursorEvent = Cursor.E_RESIZE;
                } else if (mouseEventY < border) {
                    cursorEvent = Cursor.N_RESIZE;
                } else if (mouseEventY > sceneHeight - border) {
                    cursorEvent = Cursor.S_RESIZE;
                } else {
                    cursorEvent = Cursor.DEFAULT;
                }
                scene.setCursor(cursorEvent);
            } else if(MouseEvent.MOUSE_EXITED.equals(mouseEventType) || MouseEvent.MOUSE_EXITED_TARGET.equals(mouseEventType)){
                scene.setCursor(Cursor.DEFAULT);
            } else if (MouseEvent.MOUSE_PRESSED.equals(mouseEventType) == true) {
                startX = stage.getWidth() - mouseEventX;
                startY = stage.getHeight() - mouseEventY;
            } else if (MouseEvent.MOUSE_DRAGGED.equals(mouseEventType) == true) {
                if (Cursor.DEFAULT.equals(cursorEvent) == false) {
                    if (Cursor.W_RESIZE.equals(cursorEvent) == false && Cursor.E_RESIZE.equals(cursorEvent) == false) {
                        double minHeight = stage.getMinHeight() > (border*2) ? stage.getMinHeight() : (border*2);
                        if (Cursor.NW_RESIZE.equals(cursorEvent) == true || Cursor.N_RESIZE.equals(cursorEvent) == true || Cursor.NE_RESIZE.equals(cursorEvent) == true) {
                            if (stage.getHeight() > minHeight || mouseEventY < 0) {
                                stage.setHeight(stage.getY() - mouseEvent.getScreenY() + stage.getHeight());
                                stage.setY(mouseEvent.getScreenY());
                            }
                        } else {
                            if (stage.getHeight() > minHeight || mouseEventY + startY - stage.getHeight() > 0) {
                                stage.setHeight(mouseEventY + startY);
                            }
                        }
                    }

                    if (Cursor.N_RESIZE.equals(cursorEvent) == false && Cursor.S_RESIZE.equals(cursorEvent) == false) {
                        double minWidth = stage.getMinWidth() > (border*2) ? stage.getMinWidth() : (border*2);
                        if (Cursor.NW_RESIZE.equals(cursorEvent) == true || Cursor.W_RESIZE.equals(cursorEvent) == true || Cursor.SW_RESIZE.equals(cursorEvent) == true) {
                            if (stage.getWidth() > minWidth || mouseEventX < 0) {
                                stage.setWidth(stage.getX() - mouseEvent.getScreenX() + stage.getWidth());
                                stage.setX(mouseEvent.getScreenX());
                            }
                        } else {
                            if (stage.getWidth() > minWidth || mouseEventX + startX - stage.getWidth() > 0) {
                                stage.setWidth(mouseEventX + startX);
                            }
                        }
                    }
                }

            }
        }
    }
}
