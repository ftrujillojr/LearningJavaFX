/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trujillo.francis.fx;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

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

        ListIterator<Menu> menusItr = menuBarLogin.getMenus().listIterator();

        while (menusItr.hasNext()) {
            Menu menu = menusItr.next();
        }

        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("btnExit  Event Handler pressed.");
            }
        });

        chbxDebug.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean selected = chbxDebug.isSelected();
                System.out.println("CheckBox Action (selected: " + selected + ")");
            }
        });

    }
}
