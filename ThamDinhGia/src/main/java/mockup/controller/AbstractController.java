package mockup.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public abstract class AbstractController {
	protected AnchorPane contentArea;

	protected AnchorPane searchResultArea;

	protected AnchorPane searchResultTableView;

	@FXML
	private Label title;

	@FXML
	private Button updateBtn;

	protected void setTitle(String titleStr) {
		title.setText(titleStr);
	}

	protected void setUpdateButtonTitle(String titleStr) {
		updateBtn.setText(titleStr);
	}

	protected boolean updateStatus;
}