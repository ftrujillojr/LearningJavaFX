/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trujillo.francis.fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author ftrujillo
 */
public class JavaFXApplicationMain extends Application {

    public static final String LOGIN_SCENE = "Login";
    public static final String LOGIN_SCENE_FXML = "Login.fxml";
    public static final String HOME_SCENE = "Home";
    public static final String HOME_SCENE_FXML = "Home.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        try {
            ScenesController mainContainer = new ScenesController(stage, 100, 200);
            mainContainer.loadScreen(
                    JavaFXApplicationMain.LOGIN_SCENE,
                    JavaFXApplicationMain.LOGIN_SCENE_FXML
            );
            mainContainer.loadScreen(
                    JavaFXApplicationMain.HOME_SCENE,
                    JavaFXApplicationMain.HOME_SCENE_FXML
            );

            mainContainer.setScene(JavaFXApplicationMain.LOGIN_SCENE);
            Group root = new Group();
            root.getChildren().addAll(mainContainer);
            Scene scene = new Scene(root);

            //stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("My First JavaFX app");

            stage.getIcons().add(new Image(getClass().getResourceAsStream("images/javafx.jpg")));

            stage.setScene(scene);
            stage.show();
        } catch (NullPointerException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
