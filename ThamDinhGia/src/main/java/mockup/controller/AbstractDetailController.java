package mockup.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import mockup.controller.AbstractDetailController.PROCESS_STT;

public abstract class AbstractDetailController {
	public enum PROCESS_STT {
		NEW, DETAIL, UPDATE
	}

	protected PROCESS_STT processStt;

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

	protected void setUpComponents(String text, String updateBtnTxt) {
		setTitle(text);
		setUpdateButtonTitle(updateBtnTxt);

		if(processStt == null) {
			return;
		}

		if(PROCESS_STT.NEW.equals(processStt)) {
			setUpComponentsNew();
			return;
		}

		if(PROCESS_STT.UPDATE.equals(processStt)) {
			setUpComponentsUpdate();
			return;
		}

		if(PROCESS_STT.DETAIL.equals(processStt)) {
			setUpComponentsDetail();
		}
	}

	protected abstract void setUpComponentsNew();
	protected abstract void setUpComponentsDetail();
	protected abstract void setUpComponentsUpdate();

	protected boolean updateStatus;
}