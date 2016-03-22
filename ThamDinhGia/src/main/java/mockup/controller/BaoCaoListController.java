package mockup.controller;

import dev.rapid.util.FXMLConstants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

public class BaoCaoListController {
	@FXML
	private ComboBox<String> trangThaiBaoCaoCbb;

	@FXML
	private AnchorPane baoCaoSearchResultArea;

	@FXML
	public void search() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mockup.class.getResource(FXMLConstants.BC_TABLEVIEW));
			AnchorPane page = (AnchorPane) loader.load();

			BaoCaoTableViewController controller = loader.getController();
			controller.initTableViewData();
			AnchorPane.setTopAnchor(page, 0d);
			AnchorPane.setRightAnchor(page, 0d);
			AnchorPane.setLeftAnchor(page, 0d);
			baoCaoSearchResultArea.getChildren().add(page);
			controller.setApp(app);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void initialize() {
		trangThaiBaoCaoCbb.getItems().addAll("Chưa duyệt", "Sửa", "Hoàn thiện", "Hủy");
	}

	private Mockup app;

	public void setApp(Mockup obj) {
		this.app = obj;
	}

}
