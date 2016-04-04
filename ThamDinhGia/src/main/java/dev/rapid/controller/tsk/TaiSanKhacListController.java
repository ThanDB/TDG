package dev.rapid.controller.tsk;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import dev.rapid.model.tsk.TaiSanKhacDTO;
import dev.rapid.model.tsk.TaiSanKhacDataTable;
import dev.rapid.util.FXMLConstants;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import mockup.controller.Mockup;

public class TaiSanKhacListController {
	@FXML
	private TableView<TaiSanKhacDataTable> taiSanKhacTv;

	@FXML
	private TableColumn<TaiSanKhacDataTable, String> tenTaiSanTc;
	@FXML
	private TableColumn<TaiSanKhacDataTable, String> loaiHinhTc;
	@FXML
	private TableColumn<TaiSanKhacDataTable, String> loaiTaiSanTc;
	@FXML
	private TableColumn<TaiSanKhacDataTable, String> noiSanXuatTc;

	@FXML
	private TableColumn<TaiSanKhacDataTable, String> namSanXuatTc;
	@FXML
	private TableColumn<TaiSanKhacDataTable, String> nguyenGiaTc;
	@FXML
	private TableColumn<TaiSanKhacDataTable, String> giaTriTDTc;
	@FXML
	private TableColumn<TaiSanKhacDataTable, Boolean> actionTc;

	@FXML
	private void initialize() {
		/*
		 * taiSanKhacTv.setRowFactory(new
		 * Callback<TableView<TaiSanKhacDataTable>,
		 * TableRow<TaiSanKhacDataTable>>() {
		 *
		 * @Override public TableRow<TaiSanKhacDataTable>
		 * call(TableView<TaiSanKhacDataTable> param) { final
		 * TableRow<TaiSanKhacDataTable> row = new
		 * TableRow<TaiSanKhacDataTable>() {
		 *
		 * @Override protected void updateItem(TaiSanKhacDataTable tsk, boolean
		 * empty) { super.updateItem(tsk, empty); if (tsk != null &&
		 * tsk.getLoaiHinh() != null) { if ("Tài sản so sánh"
		 * .equals(tsk.getLoaiHinh().getValue())) { setStyle(
		 * "-fx-font-style: italic;"); } } } };
		 *
		 * return row; } });
		 */

		tenTaiSanTc.setCellValueFactory(cellData -> cellData.getValue().getTenTaiSan());
		loaiHinhTc.setCellValueFactory(cellData -> cellData.getValue().getLoaiHinh());
		loaiTaiSanTc.setCellValueFactory(cellData -> cellData.getValue().getLoaiTaiSan());
		noiSanXuatTc.setCellValueFactory(cellData -> cellData.getValue().getNoiSanXuat());
		namSanXuatTc.setCellValueFactory(cellData -> cellData.getValue().getNamSanXuat());
		nguyenGiaTc.setCellValueFactory(cellData -> cellData.getValue().getNguyenGia());
		giaTriTDTc.setCellValueFactory(cellData -> cellData.getValue().getGiaTriTD());
		;

		actionTc.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<TaiSanKhacDataTable, Boolean>, ObservableValue<Boolean>>() {

					@Override
					public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<TaiSanKhacDataTable, Boolean> p) {
						return new SimpleBooleanProperty(p.getValue() != null);
					}
				});

		actionTc.setCellFactory(
				new Callback<TableColumn<TaiSanKhacDataTable, Boolean>, TableCell<TaiSanKhacDataTable, Boolean>>() {

					@Override
					public TableCell<TaiSanKhacDataTable, Boolean> call(TableColumn<TaiSanKhacDataTable, Boolean> p) {
						return new ButtonCell();
					}

				});
	}

	@FXML
	private void search() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource(FXMLConstants.TSK_SEARCH));

			AnchorPane contentArea = (AnchorPane) loaderContent.load();

			app.mainLayout.setCenter(contentArea);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void create() {
		try {
			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource(FXMLConstants.TSK_NEW));

			AnchorPane contentArea = (AnchorPane) loaderContent.load();

			app.mainLayout.setCenter(contentArea);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Mockup app;

	public void setApp(Mockup app) {
		this.app = app;
	}

	public void setKhachHangData(ObservableList<TaiSanKhacDataTable> taiSanKhacData) {
		this.taiSanKhacData = taiSanKhacData;
		taiSanKhacTv.setItems(this.taiSanKhacData);
	}

	public ObservableList<TaiSanKhacDataTable> getTaiSanData() {
		ObservableList<TaiSanKhacDataTable> taiSanKhacData = FXCollections.observableArrayList();
		taiSanKhacData.add(new TaiSanKhacDataTable("Tên tài sản 1", "Tài sản thẩm định", "Loại tài sản 1",
				"Hà Nội, Việt Nam", "2009", "10,000,000", "6,000,000"));
		taiSanKhacData.add(new TaiSanKhacDataTable("Tên tài sản 3", "Tài sản so sánh", "Loại tài sản 3",
				"Hà Nội, Việt Nam", "2009", "100,000,000", "80,000,000"));
		taiSanKhacData.add(new TaiSanKhacDataTable("Tên tài sản 2", "Tài sản so sánh", "Loại tài sản 2",
				"Hà Nội, Việt Nam", "2009", "10,000,000", "6,000,000"));
		taiSanKhacData.add(new TaiSanKhacDataTable("Tên tài sản 6", "Tài sản so sánh", "Loại tài sản 6",
				"Hà Nội, Việt Nam", "2009", "10,000,000", "6,000,000"));
		taiSanKhacData.add(new TaiSanKhacDataTable("Tên tài sản 4", "Tài sản thẩm định", "Loại tài sản 4",
				"Hà Nội, Việt Nam", "2009", "10,000,000", "6,000,000"));
		taiSanKhacData.add(new TaiSanKhacDataTable("Tên tài sản 5", "Tài sản so sánh", "Loại tài sản 5",
				"Hà Nội, Việt Nam", "2009", "10,000,000", "6,000,000"));

		return taiSanKhacData;
	}

	private ObservableList<TaiSanKhacDataTable> taiSanKhacData = FXCollections.observableArrayList();

	// Define the button cell
	private class ButtonCell extends TableCell<TaiSanKhacDataTable, Boolean> {
		final Button viewButton = new Button("Chi tiết tài sản");

		ButtonCell() {
			;

			viewButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent t) {
					// do something when button clicked
					// ...
					System.out.println("" + getIndex());
					TaiSanKhacDataTable curRecord = taiSanKhacData.get(getIndex());
					try {
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(Mockup.class.getResource(FXMLConstants.TSK_UPDATE));
						AnchorPane page = (AnchorPane) loader.load();

						// Create the dialog Stage.
						Stage dialogStage = new Stage();
						dialogStage.setTitle("Chi tiết tài sản");
						dialogStage.initModality(Modality.WINDOW_MODAL);
						dialogStage.initOwner(app.primaryStage);
						Scene scene = new Scene(page);
						dialogStage.setScene(scene);

						TaiSanKhacUpdateController controller = loader.getController();
						controller.setDialog(dialogStage);
						controller.setDisableElements();
						controller.setViewStatus(true);
						TaiSanKhacDTO tskDTO = new TaiSanKhacDTO();
						tskDTO.setGhiChu("Có từ năm 1890");
						tskDTO.setGiaTriTD(curRecord.getGiaTriTD().getValue().toString());
						tskDTO.setHienTrang("Không bị hư hại gì");
						tskDTO.setLoaiHinh(curRecord.getLoaiHinh().getValue().toString());
						tskDTO.setLoaiTaisan(curRecord.getLoaiTaiSan().getValue().toString());
						LocalDate namSanXuat = LocalDate
								.of(Integer.valueOf(curRecord.getNamSanXuat().getValue().toString()), Month.JANUARY, 1);
						tskDTO.setNamSanXuat(namSanXuat);
						tskDTO.setNguyenGia(curRecord.getNguyenGia().getValue().toString());
						tskDTO.setNoiSanXuat(curRecord.getNoiSanXuat().getValue().toString());
						tskDTO.setPhapLy("Thuộc quyền sở hữu của ông Nguyễn Văn Chung");
						tskDTO.setPhuongPhap("Đánh giá");
						tskDTO.setTenTaiSan(curRecord.getTenTaiSan().getValue().toString());
						controller.setTaiSanKhacDTO(tskDTO);

						controller.fillData();

						// controller.setTitle("Thông tin khách hàng");
						// controller.setUpdateButtonTitle("Cập nhật");
						// controller.setDialogStage(dialogStage);
						// controller.setKhachHang(new
						// KhachHangDTO(curRecord.getTenKhachHang().getValue().toString(),
						// curRecord.getDiaChi().getValue().toString(),
						// curRecord.getDienThoai().getValue().toString(),
						// curRecord.getFax().getValue().toString(),
						// curRecord.getDaiDien().getValue().toString(),
						// curRecord.getMaSoThue().getValue().toString()));
						// controller.fillData();
						// controller.setKhachHangTableViewController(KhachHangTableViewController.this);

						dialogStage.showAndWait();

						if (!controller.getViewStatus()) {
							tskDTO = controller.getTaiSanKhacDTO();
							curRecord.setGiaTriTD(tskDTO.getGiaTriTD());
							curRecord.setLoaiHinh(tskDTO.getLoaiHinh());
							curRecord.setLoaiTaiSan(tskDTO.getLoaiTaisan());
							namSanXuat = tskDTO.getNamSanXuat();
							curRecord.setNamSanXuat(namSanXuat.getDayOfMonth() + "/" + namSanXuat.getMonthValue() + "/"
									+ namSanXuat.getYear());
							curRecord.setNguyenGia(tskDTO.getNguyenGia());
							curRecord.setNoiSanXuat(tskDTO.getNoiSanXuat());
							curRecord.setTenTaiSan(tskDTO.getTenTaiSan());

							taiSanKhacTv.getColumns().get(0).setVisible(false);
							taiSanKhacTv.getColumns().get(0).setVisible(true);
						}

						// if(khachHang != null) {
						// curRecord.setTenKhachHang(khachHang.getTenKhachHang());
						// curRecord.setDiaChi(khachHang.getDiaChi());
						// curRecord.setDienThoai(khachHang.getDienThoai());
						// curRecord.setFax(khachHang.getFax());
						// curRecord.setDaiDien(khachHang.getDaiDien());
						// curRecord.setMaSoThue(khachHang.getMaSoThue());
						// }

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

		// Display button if the row is not empty
		@Override
		protected void updateItem(Boolean t, boolean empty) {
			super.updateItem(t, empty);
			if (!empty) {
				setGraphic(viewButton);
				// setGraphic(deleteButton);
			}
		}
	}
}
