package mockup.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import mockup.valueobjects.HopDongDataTable;

public class HopDongListController extends AbstractController {
	@FXML
	private ComboBox<String> trangThaiCbb;

	@FXML
	private ComboBox<String> trangThaiThanhToanCbb;

	@FXML
	private AnchorPane result_area;

	private Mockup app;

	@FXML
	public void search() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mockup.class.getResource("/fxml/hop_dong_tableview.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			HopDongTableViewController controller = loader.getController();
			controller.setHopDongData(getHopDongData());
			AnchorPane.setTopAnchor(page, 0d);
			AnchorPane.setRightAnchor(page, 0d);
			AnchorPane.setLeftAnchor(page, 0d);
			result_area.getChildren().add(page);
			controller.setApp(app);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void xoaThongTin() {}

	@FXML
	private void login() {
	}

	@FXML
	private void initialize() {
		trangThaiCbb.getItems().addAll(
        		"Chưa xong",
        		"Đã xong",
        		"Hủy"
        		);
		trangThaiCbb.setPromptText("Trạng thái");

		trangThaiThanhToanCbb.getItems().addAll(
        		"Chưa thanh toán",
        		"Chưa thanh toán hết",
        		"Đã thanh toán xong"
        		);
		trangThaiThanhToanCbb.setPromptText("Trạng thái");
	}

	public void setApp(Mockup obj) {
		this.app = obj;
	}

	private ObservableList<HopDongDataTable> hopDongData = FXCollections.observableArrayList();

	public ObservableList<HopDongDataTable> getHopDongData() {
		hopDongData.clear();

		hopDongData.add(new HopDongDataTable("Ten Khach Hang 1","Nguoi Dai Dien 1","Dia Chi 1","01234567890","01234567890","11223301","01234567890","11223301"));
		hopDongData.add(new HopDongDataTable("Ten Khach Hang 2","Nguoi Dai Dien 2","Dia Chi 2","01234567891","01234567891","11223302","01234567890","11223301"));
		hopDongData.add(new HopDongDataTable("Ten Khach Hang 3","Nguoi Dai Dien 3","Dia Chi 3","01234567892","01234567892","11223303","01234567890","11223301"));
		hopDongData.add(new HopDongDataTable("Ten Khach Hang 4","Nguoi Dai Dien 4","Dia Chi 4","01234567893","01234567893","11223304","01234567890","11223301"));
		hopDongData.add(new HopDongDataTable("Ten Khach Hang 5","Nguoi Dai Dien 5","Dia Chi 5","01234567894","01234567894","11223305","01234567890","11223301"));
		hopDongData.add(new HopDongDataTable("Ten Khach Hang 6","Nguoi Dai Dien 6","Dia Chi 6","01234567895","01234567895","11223306","01234567890","11223301"));
		hopDongData.add(new HopDongDataTable("Ten Khach Hang 7","Nguoi Dai Dien 7","Dia Chi 7","01234567896","01234567896","11223307","01234567890","11223301"));
		hopDongData.add(new HopDongDataTable("Ten Khach Hang 8","Nguoi Dai Dien 8","Dia Chi 8","01234567897","01234567897","11223308","01234567890","11223301"));
		hopDongData.add(new HopDongDataTable("Ten Khach Hang 9","Nguoi Dai Dien 9","Dia Chi 9","01234567898","01234567898","11223309","01234567890","11223301"));
		hopDongData.add(new HopDongDataTable("Ten Khach Hang 10","Nguoi Dai Dien 10","Dia Chi 10","01234567899","01234567899","11223310","01234567890","11223301"));

        return hopDongData;
	}

}
