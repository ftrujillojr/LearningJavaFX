/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.trujillo.francis.fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;

/**
 * FXML Controller class
 *
 * @author ftrujillo
 */
public class LoginController implements Initializable {
@FXML
    private MenuBar menuLogin;

    /**
     *
     * @param url
     * @param rb
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        assert menuLogin != null : "fx:id=\"menuLogin\" was not injected: check your FXML file 'Login.fxml'.";
        
    }    
    
}
