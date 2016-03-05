package mockup.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChiTietHopDongController extends AbstractController{
	@FXML
	private void taoMoiKhachHang() {
		System.out.println("ChitietHopDongController::taoMoiKhachHang()");
	}

	@FXML
	private void timKiemKhachHang() {
        try {
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Mockup.class.getResource("/fxml/khach_hang_list.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(app.primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        KhachHangListController controller = loader.getController();

	        controller.setDialogStage(dialogStage);

	        dialogStage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void suaKhachHang() {}

	@FXML
	private void updateHopDong() {}

	@FXML
	private void initialize() {
	}

	private Mockup app;
	public void setApp(Mockup obj) {
		this.app = obj;
	}
}
