package mockup.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mockup.valueobjects.KhachHangDTO;

public class ChiTietKhachHangController extends AbstractController {

	@FXML
	private TextField tenKhachHangTxt;

	@FXML
	private TextField diaChiTxt;

	@FXML
	private TextField dienThoaiTxt;

	@FXML
	private TextField faxTxt;

	@FXML
	private TextField daiDienTxt;

	@FXML
	private TextField maSoThueTxt;

	private Mockup app;

	@FXML
	private boolean update() {
		String tenKhachHang = tenKhachHangTxt.getText();
		String diaChi = diaChiTxt.getText();
		String dienThoai = dienThoaiTxt.getText();
		String fax = faxTxt.getText();
		String daiDien = daiDienTxt.getText();
		String maSoThue = maSoThueTxt.getText();

		khachHang = new KhachHangDTO(tenKhachHang, diaChi, dienThoai, fax, daiDien, maSoThue);

		if(chiTietHopDongController!=null) {
			chiTietHopDongController.setKhachHang(khachHang);
		}

		if(khachHangTableViewController!=null) {
			khachHangTableViewController.setKhachHang(khachHang);
		}

		this.dialogStage.close();
		return true;
	}

	@FXML
	private void cancel() {
		this.dialogStage.close();
	}

	@FXML
	private void delete() {}

	@FXML
	private void initialize() {
//		if(khachHang != null) {
//			tenKhachHangTxt.setText(khachHang.getTenKhachHang());
//			daiDienTxt.setText(khachHang.getDaiDien());
//			diaChiTxt.setText(khachHang.getDiaChi());
//			dienThoaiTxt.setText(khachHang.getDienThoai());
//			faxTxt.setText(khachHang.getFax());
//			maSoThueTxt.setText(khachHang.getMaSoThue());
//		}
	}

	public void fillData() {
		if(khachHang != null) {
			tenKhachHangTxt.setText(khachHang.getTenKhachHang());
			daiDienTxt.setText(khachHang.getDaiDien());
			diaChiTxt.setText(khachHang.getDiaChi());
			dienThoaiTxt.setText(khachHang.getDienThoai());
			faxTxt.setText(khachHang.getFax());
			maSoThueTxt.setText(khachHang.getMaSoThue());
		}
	}

	public void setApp(Mockup obj) {
		this.app = obj;
	}

	private Stage dialogStage;
	private KhachHangDTO khachHang;
	private ChiTietHopDongController chiTietHopDongController;
	private KhachHangTableViewController khachHangTableViewController;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setKhachHang(KhachHangDTO khachHangDTO) {
		khachHang = khachHangDTO;
	}

	public void setChiTietHopDongController(ChiTietHopDongController chiTietHopDongController) {
		this.chiTietHopDongController = chiTietHopDongController;
	}

	public void setKhachHangTableViewController(KhachHangTableViewController khachHangTableViewController) {
		this.khachHangTableViewController = khachHangTableViewController;
	}



}
