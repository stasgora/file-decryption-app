package edu.file.decryption.app;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WindowController {

    public Button receiveButton;
    public Button loginButton;
    public TextField loginText;
    public TextField passwordText; // Temporary like this
    public ProgressBar receiveProgressBar;
    public Label loggedInLabel;
    public Label stateLabel;
    private Stage stage;

    private static final String BASE_USER_LOGGED_TEXT = "Logged as: ";

    public void init(Stage stage) {
        this.stage = stage;
    }
    public void userLogin(ActionEvent event){
        boolean successLogin = false;

        successLogin = true; // Just to check if it works
        if(successLogin){
            setUIComponentActiveState(true);
            loggedInLabel.setText(BASE_USER_LOGGED_TEXT + "Tomasz Dziubich");
        }
    }

    private void setUIComponentActiveState(boolean active) {
        receiveButton.setDisable(!active);
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
