package mockup.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MainLayoutController extends AbstractListController{
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

	@FXML
	private Label welcomeLbl;

	private Mockup app;

	private static int countClick = 0;

	@FXML
	private void logout() {}

	@FXML
	private void timKiemHopDong() {
		setWelcomeLbl("Xin chào: Nguyễn Văn A");

		try {
			System.out.println("Clicked: " + (countClick++));
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(MainLayoutController.class.getResource("/fxml/hop_dong_list.fxml"));

			contentArea = (AnchorPane) loaderContent.load();

			HopDongListController controller = loaderContent.getController();

			controller.setApp(app);

			app.mainLayout.setCenter(contentArea);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//	@FXML
//	private void taoMoiHopDong() {
//		try {
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(Mockup.class.getResource("/fxml/chi_tiet_hop_dong.fxml"));
//
//			contentArea = (AnchorPane) loader.load();
//
//			ChiTietHopDongController controller = loader.getController();
//			controller.setTitle("Tạo mới hợp đồng");
//			controller.setUpdateButtonTitle("Tạo mới");
//			controller.setApp(app);
//
//			app.mainLayout.setCenter(contentArea);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}

	@FXML
	private void timKiemBaoCao() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource("/fxml/bao_cao_list.fxml"));

			contentArea = (AnchorPane) loaderContent.load();
			BaoCaoListController controller = loaderContent.getController();
			controller.setApp(app);

			app.mainLayout.setCenter(contentArea);
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

			app.mainLayout.setCenter(contentArea);
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

			app.mainLayout.setCenter(contentArea);
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

			app.mainLayout.setCenter(contentArea);
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

			app.mainLayout.setCenter(contentArea);
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

			app.mainLayout.setCenter(contentArea);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void setApp(Mockup obj) {
		this.app = obj;
	}

	public void setWelcomeLbl(String welcome) {
		welcomeLbl.setText(welcome);
	}

}
