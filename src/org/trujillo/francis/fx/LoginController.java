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
public class LoginController implements Initializable {

    @FXML
    private MenuBar menuBarLogin;
    @FXML
    private Button btnExit;
    @FXML
    private CheckBox chbxDebug;
    @FXML
    private MenuItem menuFileClose;

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
        chbxDebug.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        boolean selected = chbxDebug.isSelected();
                        System.out.println("CheckBox Action (selected: " + selected + ")");
                    }
                }
        );

        // Or, you can create method that gets an instance of Anonymous EventHandler
        // Note, that you will still have TWO instances of anonymous EventHandler
        menuFileClose.setOnAction(exitApplication());
        btnExit.setOnAction(exitApplication());

    }

    
    private EventHandler<ActionEvent> exitApplication() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Exit Application");
                System.exit(0);
            }
        };
    }

}
