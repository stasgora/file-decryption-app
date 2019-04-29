package edu.file.decryption.app;

import edu.file.protocol.component.enums.ConnectionStatus;
import edu.file.protocol.component.interfaces.ConnectionEventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FileEventHandler implements ConnectionEventHandler {

	private static final Logger LOGGER = Logger.getLogger(FileEventHandler.class.getName());

	private ProgressBar sendProgressBar;
	private Label stateLabel;

	public FileEventHandler(ProgressBar sendProgressBar, Label stateLabel) {
		this.sendProgressBar = sendProgressBar;
		this.stateLabel = stateLabel;
	}

	@Override
	public void reportTransferProgress(double progress) {
		sendProgressBar.setProgress(progress);
	}

	@Override
	public void reportStatus(ConnectionStatus connectionStatus) {
		stateLabel.setText("Status: " + connectionStatus.name());
		LOGGER.log(Level.WARNING, "Status message received: " + connectionStatus.name());
	}
}
