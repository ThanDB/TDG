package dev.rapid.controller.tsk;

import java.time.LocalDate;

import dev.rapid.util.FXMLConstants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import mockup.controller.Mockup;

public class TaiSanKhacNewController {
	@FXML
	private TextField tenTaiSanTxt;

	@FXML
	private ComboBox<String> loaiHinhCbb;

	@FXML
	private TextField loaiTaiSanTxt;
	@FXML
	private TextField phapLyTxt;
	@FXML
	private TextField noiSanXuatTxt;

	@FXML
	private DatePicker namSanXuatDp;

	@FXML
	private TextField nguyenGiaTxt;
	@FXML
	private TextField hienTrangTxt;

	@FXML
	private ComboBox<String> phuongPhapTDCbb;

	@FXML
	private TextField giaTriTDTxt;

	@FXML
	private TextArea ghiChuTA;

	@FXML
	public void createNew() {
		String tenTaiSan = tenTaiSanTxt.getText();
		String loaiHinh = loaiHinhCbb.getValue();
		String loaiTaiSan = loaiTaiSanTxt.getText();
		String phapLy = phapLyTxt.getText();
		String noiSanXuat = noiSanXuatTxt.getText();
		LocalDate namSanXuat = namSanXuatDp.getValue();
		String nguyenGia = nguyenGiaTxt.getText();
		String hienTrang = hienTrangTxt.getText();
		String phuongPhap = phuongPhapTDCbb.getValue();
		String giaTriTD = giaTriTDTxt.getText();
		String ghiChu = ghiChuTA.getText();

		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource(FXMLConstants.TSK_LIST));

			AnchorPane contentArea = (AnchorPane) loaderContent.load();

			TaiSanKhacListController controller = loaderContent.getController();

			//controller.setApp(app);
			controller.setKhachHangData(controller.getTaiSanData());
			Mockup.mainLayout.setCenter(contentArea);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void close() {}

	@FXML
	public void initialize() {
		initData();
	}

	public void initData() {
		loaiHinhCbb.getItems().addAll("Tài sản thẩm định", "Tài sản so sánh");
	}

}
