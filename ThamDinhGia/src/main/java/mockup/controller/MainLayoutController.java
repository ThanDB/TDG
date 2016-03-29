package mockup.controller;

import dev.rapid.controller.tsk.TaiSanKhacListController;
import dev.rapid.util.FXMLConstants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MainLayoutController extends AbstractListController{
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
			loaderContent.setLocation(MainLayoutController.class.getResource(FXMLConstants.HD_LIST));

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
			loaderContent.setLocation(Mockup.class.getResource(FXMLConstants.BC_LIST));

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
			loaderContent.setLocation(Mockup.class.getResource(FXMLConstants.BC_DETAIL));

			contentArea = (AnchorPane) loaderContent.load();

			app.mainLayout.setCenter(contentArea);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	private void mayMocThietBi() {

	}
	@FXML
	private void batDongSan() {

	}
	@FXML
	private void giaTriDoanhNghiep() {

	}
	@FXML
	private void phuongTienVanTai() {

	}
	@FXML
	private void taiSanKhac() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource(FXMLConstants.TSK_LIST));

			contentArea = (AnchorPane) loaderContent.load();

			TaiSanKhacListController controller = loaderContent.getController();

			controller.setApp(app);
			controller.setKhachHangData(controller.getTaiSanData());
			app.mainLayout.setCenter(contentArea);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void timKiemMayMocThietBi() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource(FXMLConstants.MMTB_LIST));

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
			loaderContent.setLocation(Mockup.class.getResource(FXMLConstants.MMTB_DETAIL));

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
			loaderContent.setLocation(Mockup.class.getResource(FXMLConstants.KH_LIST));

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
			loaderContent.setLocation(Mockup.class.getResource(FXMLConstants.KH_DETAIL));

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
