package dev.rapid.controller.tsk;

import dev.rapid.model.tsk.TaiSanKhacDataTable;
import dev.rapid.util.DateFormatUtil;
import dev.rapid.util.FXMLConstants;
import javafx.collections.ObservableList;
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

	private Mockup app;

	@FXML
	public void createNew() {
		TaiSanKhacDataTable taisan = new TaiSanKhacDataTable();
		taisan.setGiaTriTD(giaTriTDTxt.getText());
		taisan.setLoaiHinh(loaiHinhCbb.getValue());
		taisan.setLoaiTaiSan(loaiTaiSanTxt.getText());
		taisan.setNamSanXuat(DateFormatUtil.localDateToString(namSanXuatDp.getValue()));
		taisan.setNguyenGia(nguyenGiaTxt.getText());
		taisan.setNoiSanXuat(noiSanXuatTxt.getText());
		taisan.setTenTaiSan(tenTaiSanTxt.getText());

		backToList(taisan);
	}

	@FXML
	public void close() {
		try {
			backToList(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void backToList(TaiSanKhacDataTable taisan) {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource(FXMLConstants.TSK_LIST));

			AnchorPane contentArea = (AnchorPane) loaderContent.load();

			TaiSanKhacListController controller = loaderContent.getController();

			controller.setApp(app);
			ObservableList<TaiSanKhacDataTable> taisanData = controller.getTaiSanData();
			if(taisan!=null) {
				taisanData.add(0, taisan);
			}
			controller.setTaiSanData(taisanData);
			app.mainLayout.setCenter(contentArea);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initData() {
		loaiHinhCbb.getItems().addAll("Tài sản thẩm định", "Tài sản so sánh");
		phuongPhapTDCbb.getItems().addAll("Phương pháp so sánh", "Phương pháp đối chiếu", "Phương pháp tỷ giá");
	}

	public void setApp(Mockup obj) {
		this.app = obj;
	}
}
