package dev.rapid.controller.gtdn;

import java.io.IOException;
import java.time.LocalDate;

import dev.rapid.model.gtdn.GiaTriDNDTO;
import dev.rapid.model.gtdn.GiaTriDNDataTable;
import dev.rapid.util.DateFormatUtil;
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

public class GiaTriDNListController {
	@FXML
	private TableView<GiaTriDNDataTable> tableView;

	@FXML
	private TableColumn<GiaTriDNDataTable, String> tenDoanhNghiepTc;
	@FXML
	private TableColumn<GiaTriDNDataTable, String> loaiHinhTc;
	@FXML
	private TableColumn<GiaTriDNDataTable, String> loaiHinhKDTc;
	@FXML
	private TableColumn<GiaTriDNDataTable, String> namThanhLapTc;

	@FXML
	private TableColumn<GiaTriDNDataTable, String> vonDieuLeTc;
	@FXML
	private TableColumn<GiaTriDNDataTable, String> vonChuSoHuuTc;
	@FXML
	private TableColumn<GiaTriDNDataTable, String> giaTriTSTc;
	@FXML
	private TableColumn<GiaTriDNDataTable, String> giaTriTDTc;
	@FXML
	private TableColumn<GiaTriDNDataTable, Boolean> actionTc;

	@FXML
	private void initialize() {
		/*
		 * taiSanKhacTv.setRowFactory(new
		 * Callback<TableView<GiaTriDNDataTable>,
		 * TableRow<GiaTriDNDataTable>>() {
		 *
		 * @Override public TableRow<GiaTriDNDataTable>
		 * call(TableView<GiaTriDNDataTable> param) { final
		 * TableRow<GiaTriDNDataTable> row = new
		 * TableRow<GiaTriDNDataTable>() {
		 *
		 * @Override protected void updateItem(GiaTriDNDataTable tsk, boolean
		 * empty) { super.updateItem(tsk, empty); if (tsk != null &&
		 * tsk.getLoaiHinh() != null) { if ("Tài sản so sánh"
		 * .equals(tsk.getLoaiHinh().getValue())) { setStyle(
		 * "-fx-font-style: italic;"); } } } };
		 *
		 * return row; } });
		 */

		tenDoanhNghiepTc.setCellValueFactory(cellData -> cellData.getValue().getTenDoanhNghiep());
		loaiHinhTc.setCellValueFactory(cellData -> cellData.getValue().getLoaiHinh());
		loaiHinhKDTc.setCellValueFactory(cellData -> cellData.getValue().getLoaiHinhKD());
		namThanhLapTc.setCellValueFactory(cellData -> cellData.getValue().getNamThanhLap());
		vonDieuLeTc.setCellValueFactory(cellData -> cellData.getValue().getVonDieuLe());
		vonChuSoHuuTc.setCellValueFactory(cellData -> cellData.getValue().getVonChuSoHuu());
		giaTriTSTc.setCellValueFactory(cellData -> cellData.getValue().getGiaTriTS());
		giaTriTDTc.setCellValueFactory(cellData -> cellData.getValue().getGiaTriTD());

		actionTc.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<GiaTriDNDataTable, Boolean>, ObservableValue<Boolean>>() {

					@Override
					public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<GiaTriDNDataTable, Boolean> p) {
						return new SimpleBooleanProperty(p.getValue() != null);
					}
				});

		actionTc.setCellFactory(
				new Callback<TableColumn<GiaTriDNDataTable, Boolean>, TableCell<GiaTriDNDataTable, Boolean>>() {

					@Override
					public TableCell<GiaTriDNDataTable, Boolean> call(TableColumn<GiaTriDNDataTable, Boolean> p) {
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
			GiaTriDNSearchController controller = loaderContent.getController();
			controller.setApp(app);
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

			GiaTriDNNewController controller = loaderContent.getController();
			controller.initData();
			controller.setApp(app);

			app.mainLayout.setCenter(contentArea);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Mockup app;

	public void setApp(Mockup app) {
		this.app = app;
	}

	public void setTaiSanData(ObservableList<GiaTriDNDataTable> taiSanKhacData) {
		this.taiSanKhacData = taiSanKhacData;
		tableView.setItems(this.taiSanKhacData);
	}

	public ObservableList<GiaTriDNDataTable> getTaiSanData() {
		ObservableList<GiaTriDNDataTable> giaTriDNData = FXCollections.observableArrayList();
		giaTriDNData.add(new GiaTriDNDataTable("Tên tài sản 1", "Tài sản thẩm định", "Loại tài sản 1",
				"Hà Nội, Việt Nam", "2009", "10,000,000", "6,000,000"));
		giaTriDNData.add(new GiaTriDNDataTable("Tên tài sản 3", "Tài sản so sánh", "Loại tài sản 3",
				"Hà Nội, Việt Nam", "2009", "100,000,000", "80,000,000"));
		giaTriDNData.add(new GiaTriDNDataTable("Tên tài sản 2", "Tài sản so sánh", "Loại tài sản 2",
				"Hà Nội, Việt Nam", "2009", "10,000,000", "6,000,000"));
		giaTriDNData.add(new GiaTriDNDataTable("Tên tài sản 6", "Tài sản so sánh", "Loại tài sản 6",
				"Hà Nội, Việt Nam", "2009", "10,000,000", "6,000,000"));
		giaTriDNData.add(new GiaTriDNDataTable("Tên tài sản 4", "Tài sản thẩm định", "Loại tài sản 4",
				"Hà Nội, Việt Nam", "2009", "10,000,000", "6,000,000"));
		giaTriDNData.add(new GiaTriDNDataTable("Tên tài sản 5", "Tài sản so sánh", "Loại tài sản 5",
				"Hà Nội, Việt Nam", "2009", "10,000,000", "6,000,000"));

		return giaTriDNData;
	}

	private ObservableList<GiaTriDNDataTable> giaTriDNData = FXCollections.observableArrayList();

	// Define the button cell
	private class ButtonCell extends TableCell<GiaTriDNDataTable, Boolean> {
		final Button viewButton = new Button("Chi tiết tài sản");

		ButtonCell() {
			;

			viewButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent t) {
					// do something when button clicked
					// ...
					System.out.println("" + getIndex());
					GiaTriDNDataTable curRecord = giaTriDNData.get(getIndex());
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

						GiaTriDNUpdateController controller = loader.getController();
						controller.setDialog(dialogStage);
						controller.setDisableElements();
						controller.setViewStatus(true);
						GiaTriDNDTO tskDTO = new GiaTriDNDTO();
						tskDTO.setGhiChu("Có từ năm 1890");
						tskDTO.setGiaTriTD(curRecord.getGiaTriTD().getValue().toString());
						tskDTO.setHienTrang("Không bị hư hại gì");
						tskDTO.setLoaiHinh(curRecord.getLoaiHinh().getValue().toString());
						tskDTO.setLoaiTaisan(curRecord.getLoaiTaiSan().getValue().toString());

						LocalDate namSanXuat = DateFormatUtil.stringToLocalDate(curRecord.getNamSanXuat().getValue());
						tskDTO.setNamSanXuat(namSanXuat);
						tskDTO.setNguyenGia(curRecord.getNguyenGia().getValue().toString());
						tskDTO.setNoiSanXuat(curRecord.getNoiSanXuat().getValue().toString());
						tskDTO.setPhapLy("Thuộc quyền sở hữu của ông Nguyễn Văn Chung");
						tskDTO.setPhuongPhap("Đánh giá");
						tskDTO.setTenTaiSan(curRecord.getTenTaiSan().getValue().toString());
						controller.setGiaTriDNDTO(tskDTO);

						controller.fillData();

						dialogStage.showAndWait();

						if (!controller.getViewStatus()) {
							tskDTO = controller.getGiaTriDNDTO();
							curRecord.setGiaTriTD(tskDTO.getGiaTriTD());
							curRecord.setLoaiHinh(tskDTO.getLoaiHinh());
							curRecord.setLoaiTaiSan(tskDTO.getLoaiTaisan());
							namSanXuat = tskDTO.getNamSanXuat();
							curRecord.setNamSanXuat(namSanXuat.getDayOfMonth() + "/" + namSanXuat.getMonthValue() + "/"
									+ namSanXuat.getYear());
							curRecord.setNguyenGia(tskDTO.getNguyenGia());
							curRecord.setNoiSanXuat(tskDTO.getNoiSanXuat());
							curRecord.setTenTaiSan(tskDTO.getTenTaiSan());

							tableView.getColumns().get(0).setVisible(false);
							tableView.getColumns().get(0).setVisible(true);
						}

					} catch (IOException e) {
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
