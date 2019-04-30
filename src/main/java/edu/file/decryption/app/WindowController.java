package edu.file.decryption.app;

import edu.file.encryption.component.CryptoComponent;
import edu.file.encryption.component.interfaces.ICryptoComponent;
import edu.file.protocol.component.FileReceiver;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WindowController {

	private static final Logger LOGGER = Logger.getLogger(WindowController.class.getName());

	public Button loginButton;
	public TextField loginField;
	public PasswordField passwordField; // Temporary like this
	public ProgressBar receiveProgressBar;
	public Label loggedInLabel;
	public Label stateLabel;
	private Stage stage;

	private ICryptoComponent cryptoComponent = new CryptoComponent();
	private FileReceiver fileReceiver;

	private static final String BASE_USER_LOGGED_TEXT = "Logged as: ";

	public void init(Stage stage) {
		this.stage = stage;
		fileReceiver = new FileReceiver(new FileEventHandler(receiveProgressBar, stateLabel), cryptoComponent, this::fileReceived);
	}

	private void fileReceived(byte[] bytes) {
		Platform.runLater(() -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save File");
			File file = fileChooser.showSaveDialog(stage);
			try {
				if(file == null || !file.createNewFile()) {
					return;
				}
				try(FileOutputStream output = new FileOutputStream(file)) {
					output.write(bytes);
				}
			} catch (IOException e) {
				LOGGER.log(Level.WARNING, "File saving error", e);
			}
		});
	}

	public void userLogin(ActionEvent event){
		boolean successLogin = false;

		successLogin = true; // Just to check if it works
		if(successLogin) {
			loggedInLabel.setText(BASE_USER_LOGGED_TEXT + "Tomasz Dziubich");
			cryptoComponent.loginUser(loginField.getText(), passwordField.getText());
		}
	}


	public void exit(ActionEvent actionEvent) {
		Platform.exit();
	}
}
