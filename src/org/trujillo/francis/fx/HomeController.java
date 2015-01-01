/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trujillo.francis.fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ftrujillo
 */
public class HomeController implements Initializable, ControlledScreen {

    ScreensController myController; 

    @Override
    public void setScreenParent(ScreensController screenParent) {
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
        myController.setScreen(JavaFXApplicationMain.LOGIN_SCREEN);  
    }
}
