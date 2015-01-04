/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.trujillo.francis.other;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.trujillo.francis.fx.ControlledScene;
import org.trujillo.francis.fx.ScenesController;

/**
 * FXML Controller class
 *
 * @author ftrujillo
 */
public class TestController implements Initializable, ControlledScene {

    ScenesController myController; 

    @Override
    public void setSceneParent(ScenesController screenParent) {
        this.myController = screenParent; 
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
