/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trujillo.francis.fx;

import org.trujillo.francis.control.ScenesController;
import org.trujillo.francis.control.ControlledScene;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ftrujillo
 */
public class HomeController implements Initializable, ControlledScene {

    ScenesController myController; 

    @Override
    public void setSceneParent(ScenesController screenParent) {
        this.myController = screenParent; 
    }
    
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void gotoLogin(ActionEvent event) {
        FXMLLoader fxmlLoader = this.myController.getFXMLLoader(JavaFXApplicationMain.LOGIN_SCENE);
        LoginController loginController = ((LoginController) fxmlLoader.getController());
        loginController.clearAll();
        this.myController.setScene(JavaFXApplicationMain.LOGIN_SCENE);
    }
}
