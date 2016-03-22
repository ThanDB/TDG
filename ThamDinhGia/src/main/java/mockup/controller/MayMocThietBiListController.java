package mockup.controller;

import dev.rapid.util.FXMLConstants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class MayMocThietBiListController {
	@FXML
	private AnchorPane mayMocSearchResultArea;

	@FXML
	public void search() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mockup.class.getResource(FXMLConstants.MMTB_TABLEVIEW));
			AnchorPane page = (AnchorPane) loader.load();

//			BaoCaoTableViewController controller = loader.getController();
//			controller.initTableViewData();
			AnchorPane.setTopAnchor(page, 0d);
			AnchorPane.setRightAnchor(page, 0d);
			AnchorPane.setLeftAnchor(page, 0d);
			mayMocSearchResultArea.getChildren().add(page);
//			controller.setApp(app);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
