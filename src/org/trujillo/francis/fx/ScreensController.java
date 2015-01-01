package org.trujillo.francis.fx;

import java.io.IOException;
import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class ScreensController extends StackPane {

    private HashMap<String, Node> screens = new HashMap<>();
    public ScreensController() {

    }

    /**
     * This class has methods for adding, loading and setting the screens
     *
     * @param name
     * @param screen
     */
    public void addScreen(String name, Node screen) {
        this.screens.put(name, screen);
    }

    /**
     * This method loads the fxml file specified by resource, and it gets the
     * top Node for the screen. We can also get the controller associated to
     * this screen, which allows us to set the parent for the screen, as all the
     * controllers shared the common type ControlledScreen.
     *
     * Finally the screen is added to the screens hash map. As you can see from
     * the code, the loaded fxml file, doesn't get added to the scene graph, so
     * the loaded screen doesn't get displayed or loaded to the screen.
     *
     * @param name
     * @param resource
     * @return
     */
    public boolean loadScreen(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController());
            myScreenControler.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setScreen(final String name) {

        final int FADE_IN_MILLISECONDS = 500;
        
        if (screens.get(name) != null) { //screen loaded 
            final DoubleProperty opacity = opacityProperty();

            //Is there is more than one screen 
            if (!getChildren().isEmpty()) {
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO,
                                new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(FADE_IN_MILLISECONDS), new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                //remove displayed screen 
                                getChildren().remove(0);
                                //add new screen 
                                getChildren().add(0, screens.get(name));
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO,
                                                new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(100),
                                                new KeyValue(opacity, 1.0)));
                                fadeIn.play();
                            }
                        }, new KeyValue(opacity, 0.0)));
                fade.play();
            } else {
                //no one else been displayed, then just show 
                setOpacity(0.0);
                getChildren().add(screens.get(name));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO,
                                new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(FADE_IN_MILLISECONDS),
                                new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            System.out.println("screen hasn't been loaded!\n");
            return false;
        }
    }
    
    public boolean unloadScreen(String name) { 
     if(screens.remove(name) == null) { 
       System.out.println("Screen didn't exist"); 
       return false; 
     } else { 
       return true; 
     } 
   } 

}
