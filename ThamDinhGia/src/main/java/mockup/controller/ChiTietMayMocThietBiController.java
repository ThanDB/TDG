package mockup.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ChiTietMayMocThietBiController extends AbstractController {

	@FXML
	public void update() {
		this.stage.close();
	}

	private Mockup app;
	private Stage stage;

	public void setApp(Mockup obj) {
		this.app = obj;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@Override
	protected void setUpComponentsNew() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setUpComponentsDetail() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setUpComponentsUpdate() {
		// TODO Auto-generated method stub

	}
}
