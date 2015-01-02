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
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ScenesController extends StackPane {

    private HashMap<String, Node> scenes;

    // I needed these for resizing the stage on each scene transistion.
    public Stage stage = null;
    private HashMap<String, Double> height;
    private HashMap<String, Double> width;
    private double xpos;
    private double ypos;

    public ScenesController(Stage stage) {
        this.stage = stage;
        this.scenes = new HashMap<>();
        this.height = new HashMap<>();
        this.width = new HashMap<>();
        this.xpos = 0;
        this.ypos = 0;
    }
    public ScenesController(Stage stage, double xpos, double ypos) {
        this.stage = stage;
        this.scenes = new HashMap<>();
        this.height = new HashMap<>();
        this.width = new HashMap<>();
        this.xpos = xpos;
        this.ypos = ypos;
    }

    /**
     * This method loads the fxml file specified by resource, and it gets the
     * top Node for the screen. We can also get the controller associated to
     * this screen, which allows us to set the parent for the screen, as all the
     * controllers shared the common type ControlledScene.
     *
     * Finally the screen is added to the scenes hash map. As you can see from
     * the code, the loaded fxml file, doesn't get added to the scene graph, so
     * the loaded scene doesn't get displayed or loaded to the screen.
     *
     * @param name
     * @param resource
     * @return
     */
    public boolean loadScene(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent parentScene = (Parent) myLoader.load();
            ControlledScene mySceneController = ((ControlledScene) myLoader.getController());
            mySceneController.setSceneParent(this);
            addScene(name, parentScene);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean setScene(final String name) {
        final int FADE_IN_MILLISECONDS = 500;

        if (scenes.get(name) != null) { //screen loaded 
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
                                resizeStage(name); // This was my addition to the code
                                getChildren().add(0, getNode(name));

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
                resizeStage(name);    // This was my addition to the code
                getChildren().add(getNode(name));
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

// =============================================================================    
    
    /**
     * This class has methods for adding, loading and setting the scenes
     *
     * @param name
     * @param scene
     */
    private void addScene(String name, Node scene) {
        this.scenes.put(name, scene);
        
        // I wanted to pre-parse these values out and store in HashMap in 
        // parallel with name and scene.
        this.height.put(name, scene.prefHeight(Region.USE_PREF_SIZE));
        this.width.put(name, scene.prefWidth(Region.USE_PREF_SIZE));
    }

    
    /**
     * This method will set the Stage (Window) at xpos,ypos.
     * @param name 
     */
    private void resizeStage(String name) {
        // This position the app at  xpos,ypos
        this.stage.setX(this.xpos);
        this.stage.setY(this.ypos);

        StageStyle stageStyle = this.stage.getStyle();
        int extra = 35;
        
        if(stageStyle == StageStyle.TRANSPARENT) {
            extra = 0;
        }
        //this.stage.setResizable(false);
        // The 35 is to take into account the Window title bar height.  TODO: figure out how 
        // to dynamically get this number.
        this.stage.setHeight(this.height.get(name) + extra);
        this.stage.setWidth(this.width.get(name));

    }

    private boolean unloadScene(String name) {
        if (scenes.remove(name) == null) {
            System.out.println("Screen didn't exist");
            return false;
        } else {
            height.remove(name);
            width.remove(name);
            return true;
        }
    }

    private Node getNode(String name) {
        Node node = scenes.get(name);
        return(node);
    }

}
