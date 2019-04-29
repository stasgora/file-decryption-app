package edu.file.decryption.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FileDecryptionApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout.fxml"));
		Parent root = loader.load();
		stage.setTitle("File Decryption App");
		stage.setScene(new Scene(root, 500, 300));
		stage.show();
		WindowController controller = loader.getController();
		controller.init(stage);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
