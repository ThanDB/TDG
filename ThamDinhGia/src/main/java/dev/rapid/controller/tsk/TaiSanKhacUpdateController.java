package dev.rapid.controller.tsk;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TaiSanKhacUpdateController {
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
	private DatePicker thoiGianTDDp;

	@FXML
	private TextArea ghiChuTA;

	@FXML
	public void createNew() {}

	@FXML
	public void close() {}

}
