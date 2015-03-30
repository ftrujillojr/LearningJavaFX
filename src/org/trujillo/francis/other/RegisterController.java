/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trujillo.francis.other;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.trujillo.francis.control.ControlledScene;
import org.trujillo.francis.control.ScenesController;
import org.trujillo.francis.fx.JavaFXApplicationMain;

/**
 * FXML Controller class
 *
 * @author ftrujillo
 */
public class RegisterController implements Initializable, ControlledScene {

    ScenesController myController;

    @Override
    public void setSceneParent(ScenesController screenParent) {
        this.myController = screenParent;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnCreateNewUser;

    @FXML
    private PasswordField pwdPassword;

    @FXML
    private PasswordField pwdVerifyPassword;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textFirstName;

    @FXML
    private TextField textLastName;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'Register.fxml'.";
        assert btnCreateNewUser != null : "fx:id=\"btnCreateNewUser\" was not injected: check your FXML file 'Register.fxml'.";
        assert pwdPassword != null : "fx:id=\"pwdPassword\" was not injected: check your FXML file 'Register.fxml'.";
        assert pwdVerifyPassword != null : "fx:id=\"pwdVerifyPassword\" was not injected: check your FXML file 'Register.fxml'.";
        assert textEmail != null : "fx:id=\"textEmail\" was not injected: check your FXML file 'Register.fxml'.";
        assert textFirstName != null : "fx:id=\"textFirstName\" was not injected: check your FXML file 'Register.fxml'.";
        assert textLastName != null : "fx:id=\"textLastName\" was not injected: check your FXML file 'Register.fxml'.";

    }

    @FXML
    void actionCreateNewUser(ActionEvent event) {
    }

    @FXML
    void actionGotoLogin(ActionEvent event) {
        myController.setScene(JavaFXApplicationMain.LOGIN_SCENE);
    }
}
