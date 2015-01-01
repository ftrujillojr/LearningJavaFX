/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trujillo.francis.fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ftrujillo
 */
public class JavaFXApplicationMain extends Application {

    public static final String LOGIN_SCREEN = "Login";
    public static final String LOGIN_SCREEN_FXML = "Login.fxml";
    public static final String HOME_SCREEN = "Home";
    public static final String HOME_SCREEN_FXML = "Home.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(
                JavaFXApplicationMain.LOGIN_SCREEN,
                JavaFXApplicationMain.LOGIN_SCREEN_FXML
        );
        mainContainer.loadScreen(
                JavaFXApplicationMain.HOME_SCREEN,
                JavaFXApplicationMain.HOME_SCREEN_FXML
        );

        mainContainer.setScreen(JavaFXApplicationMain.LOGIN_SCREEN);
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
