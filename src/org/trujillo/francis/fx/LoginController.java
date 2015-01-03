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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ftrujillo
 */
public class LoginController implements Initializable, ControlledScene {

    ScenesController myController;

    @FXML
    private TextArea login_error;
    @FXML
    private Button btnExit;
    @FXML
    private PasswordField textFieldPassword;
    @FXML
    private TextField textFieldUserName;

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
        assert login_error != null : "fx:id=\"login_error\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'Login.fxml'.";
        assert textFieldPassword != null : "fx:id=\"textFieldPassword\" was not injected: check your FXML file 'Login.fxml'.";
        assert textFieldUserName != null : "fx:id=\"textFieldUserName\" was not injected: check your FXML file 'Login.fxml'.";

    }

    public void clearAll() {
        textFieldUserName.setText("");
        textFieldPassword.setText("");
    }

    @FXML
    private void gotoRegisterUser(ActionEvent event) {
        System.out.println("TODO: RegisterUser");
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
