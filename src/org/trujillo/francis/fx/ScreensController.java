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

    private HashMap<String, Node> screens;
    private HashMap<String, Double> height;
    private HashMap<String, Double> width;

    public ScreensController() {
        screens = new HashMap<>();
        height = new HashMap<>();
        width = new HashMap<>();
    }

    /**
     * This class has methods for adding, loading and setting the screens
     *
     * @param name
     * @param screen
     */
    public void addScreen(String name, Node screen) {
        this.screens.put(name, screen);
        this.height.put(name, screen.prefHeight(USE_PREF_SIZE));
        this.width.put(name, screen.prefWidth(USE_PREF_SIZE));
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
                                Node node = screens.get(name);
                                resizeStage(name);
                                getChildren().add(0, node);

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
                Node node = screens.get(name);
                resizeStage(name);
                getChildren().add(node);
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

    // This method took 2 days to write.  The hard part was getting the PREF HEIGHT/WIDTH at load time.
    // See addScreen()
    public void resizeStage(String name) {
        // This position the app at  100,200
        JavaFXApplicationMain.APP_STAGE.setX(100);
        JavaFXApplicationMain.APP_STAGE.setY(200);

        //JavaFXApplicationMain.APP_STAGE.setResizable(false);

        // The 35 is to take into account the Window title bar height.  TODO: figure out how 
        // to dynamically get this number.
        JavaFXApplicationMain.APP_STAGE.setHeight(this.height.get(name) + 35);
        JavaFXApplicationMain.APP_STAGE.setWidth(this.width.get(name));
        
    }

    public boolean unloadScreen(String name) {
        if (screens.remove(name) == null) {
            System.out.println("Screen didn't exist");
            return false;
        } else {
            height.remove(name);
            width.remove(name);
            return true;
        }
    }

}
