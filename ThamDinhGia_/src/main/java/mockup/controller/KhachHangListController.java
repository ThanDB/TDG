package mockup.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mockup.valueobjects.KhachHangDataTable;

public class KhachHangListController {
	private Mockup app;

	@FXML
	private AnchorPane searchKhachHangResultArea;

	@FXML
	private void search() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mockup.class.getResource("/fxml/khach_hang_tableview.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			KhachHangTableViewController controller = loader.getController();
			controller.setKhachHangData(getKhachHangData());
			AnchorPane.setTopAnchor(page, 0d);
			AnchorPane.setRightAnchor(page, 0d);
			AnchorPane.setLeftAnchor(page, 0d);
			searchKhachHangResultArea.getChildren().add(page);
			controller.setApp(app);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void initialize() {
	}

	public void setApp(Mockup obj) {
		this.app = obj;
	}

	public void setDialogStage(Stage dialogStage) {

	}

	private ObservableList<KhachHangDataTable> khachHangData = FXCollections.observableArrayList();

	public ObservableList<KhachHangDataTable> getKhachHangData() {
		khachHangData.clear();

		khachHangData.add(new KhachHangDataTable("Ten Khach Hang 1","Nguoi Dai Dien 1","Dia Chi 1","01234567890","01234567890","11223301"));
		khachHangData.add(new KhachHangDataTable("Ten Khach Hang 2","Nguoi Dai Dien 2","Dia Chi 2","01234567891","01234567891","11223302"));
		khachHangData.add(new KhachHangDataTable("Ten Khach Hang 3","Nguoi Dai Dien 3","Dia Chi 3","01234567892","01234567892","11223303"));
		khachHangData.add(new KhachHangDataTable("Ten Khach Hang 4","Nguoi Dai Dien 4","Dia Chi 4","01234567893","01234567893","11223304"));
		khachHangData.add(new KhachHangDataTable("Ten Khach Hang 5","Nguoi Dai Dien 5","Dia Chi 5","01234567894","01234567894","11223305"));
		khachHangData.add(new KhachHangDataTable("Ten Khach Hang 6","Nguoi Dai Dien 6","Dia Chi 6","01234567895","01234567895","11223306"));
		khachHangData.add(new KhachHangDataTable("Ten Khach Hang 7","Nguoi Dai Dien 7","Dia Chi 7","01234567896","01234567896","11223307"));
		khachHangData.add(new KhachHangDataTable("Ten Khach Hang 8","Nguoi Dai Dien 8","Dia Chi 8","01234567897","01234567897","11223308"));
		khachHangData.add(new KhachHangDataTable("Ten Khach Hang 9","Nguoi Dai Dien 9","Dia Chi 9","01234567898","01234567898","11223309"));
		khachHangData.add(new KhachHangDataTable("Ten Khach Hang 10","Nguoi Dai Dien 10","Dia Chi 10","01234567899","01234567899","11223310"));

        return khachHangData;
	}
}
