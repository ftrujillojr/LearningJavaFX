/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trujillo.francis.fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author ftrujillo
 */
public class LoginController implements Initializable, ControlledScene {

    ScenesController myController; 
    
    @FXML
    private MenuBar menuBarLogin;
    @FXML
    private Button btnExit;
    @FXML
    private CheckBox chbxDebug;
    @FXML
    private MenuItem menuFileClose;

    @Override
    public void setSceneParent(ScenesController screenParent) {
        this.myController = screenParent; 
    }
    
    /**
     *
     * @param url
     * @param rb
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        assert menuBarLogin != null : "fx:id=\"menuBarLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'Login.fxml'.";
        assert chbxDebug != null : "fx:id=\"chbxDebug\" was not injected: check your FXML file 'Login.fxml'.";
        assert menuFileClose != null : "fx:id=\"menuFileClose\" was not injected: check your FXML file 'Login.fxml'.";

        // You can use Anonymous EventHandler inline
        chbxDebug.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean selected = chbxDebug.isSelected();
                System.out.println("CheckBox Action (selected: " + selected + ")");
            }
        });

    }

    @FXML
    private void gotoHomePage(ActionEvent event) {
        myController.setScene(JavaFXApplicationMain.HOME_SCENE);  
    }
    
    @FXML
    private void exitApplication() {
        System.exit(0);
    }


}
