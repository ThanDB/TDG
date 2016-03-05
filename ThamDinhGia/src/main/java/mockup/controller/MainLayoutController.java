package mockup.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainLayoutController extends AbstractController{
//	@FXML
//	private Button timKiemHopDong;
//
//	@FXML
//	private Button taoMoiHopDong;
//
//	@FXML
//	private Button timKiemBaoCao;
//
//	@FXML
//	private Button taoMoiBaoCao;
//
//	@FXML
//	private Button timKiemMayMocThietBi;
//
//	@FXML
//	private Button taoMoiMayMocThietBi;
//
//	@FXML
//	private Button timKiemBatDongSan;
//
//	@FXML
//	private Button taoMoiBatDongSan;
//
//	@FXML
//	private Button timKiemGiaTriDoanhNghiep;
//
//	@FXML
//	private Button taoMoiGiaTriDoanhNghiep;
//
//	@FXML
//	private Button timKiemPhuongTienVanTai;
//
//	@FXML
//	private Button taoMoiPhuongTienVanTai;

	private Mockup app;

	@FXML
	private void timKiemHopDong() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource("/fxml/hop_dong_list.fxml"));

			contentArea = (AnchorPane) loaderContent.load();

			app.mainLayout.setRight(contentArea);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	private void taoMoiHopDong() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource("/fxml/chi_tiet_hop_dong.fxml"));

			contentArea = (AnchorPane) loaderContent.load();

			app.mainLayout.setRight(contentArea);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	private void timKiemBaoCao() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource("/fxml/bao_cao_list.fxml"));

			contentArea = (AnchorPane) loaderContent.load();

			app.mainLayout.setRight(contentArea);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	private void taoMoiBaoCao() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource("/fxml/chi_tiet_bao_cao.fxml"));

			contentArea = (AnchorPane) loaderContent.load();

			app.mainLayout.setRight(contentArea);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	private void timKiemMayMocThietBi() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource("/fxml/may_moc_thiet_bi_list.fxml"));

			contentArea = (AnchorPane) loaderContent.load();

			app.mainLayout.setRight(contentArea);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	private void taoMoiMayMocThietBi() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource("/fxml/chi_tiet_may_moc_thiet_bi.fxml"));

			contentArea = (AnchorPane) loaderContent.load();

			app.mainLayout.setRight(contentArea);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	private void timKiemBatDongSan() {

	}

	@FXML
	private void taoMoiBatDongSan() {

	}

	@FXML
	private void timKiemGiaTriDoanhNghiep() {

	}

	@FXML
	private void taoMoiGiaTriDoanhNghiep() {

	}

	@FXML
	private void timKiemPhuongTienVanTai() {

	}

	@FXML
	private void taoMoiPhuongTienVanTai() {

	}

	@FXML
	private void timKiemKhachHang() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource("/fxml/khach_hang_list.fxml"));

			contentArea = (AnchorPane) loaderContent.load();

			app.mainLayout.setRight(contentArea);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	private void taoMoiKhachHang() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource("/fxml/chi_tiet_khach_hang.fxml"));

			contentArea = (AnchorPane) loaderContent.load();

			app.mainLayout.setRight(contentArea);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void setApp(Mockup obj) {
		this.app = obj;
	}

}
