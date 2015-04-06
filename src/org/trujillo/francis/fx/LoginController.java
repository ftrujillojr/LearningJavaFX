package org.trujillo.francis.fx;

import org.trujillo.francis.control.ScenesController;
import org.trujillo.francis.control.ControlledScene;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private Label lblLogin;
    @FXML
    private TextArea textAreaMessages;
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
        assert lblLogin != null : "fx:id=\"lblLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert textAreaMessages != null : "fx:id=\"textAreaMessages\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'Login.fxml'.";
        assert textFieldPassword != null : "fx:id=\"textFieldPassword\" was not injected: check your FXML file 'Login.fxml'.";
        assert textFieldUserName != null : "fx:id=\"textFieldUserName\" was not injected: check your FXML file 'Login.fxml'.";

    }

    public void clearAll() {
        textFieldUserName.setText("");
        textFieldPassword.setText("");
        textAreaMessages.setText("");
    }
    
    public void setTextAreaMessages(String msg) {
        textAreaMessages.setText(msg);
    }
    
    @FXML
    private void gotoRegisterUser(ActionEvent event) {
        myController.setScene(JavaFXApplicationMain.REGISTER_SCENE);
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
