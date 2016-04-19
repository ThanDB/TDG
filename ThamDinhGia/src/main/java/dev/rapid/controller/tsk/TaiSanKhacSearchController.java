package dev.rapid.controller.tsk;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.rapid.model.tsk.TaiSanKhacDTO;
import dev.rapid.model.tsk.TaiSanKhacDataTable;
import dev.rapid.util.DateFormatUtil;
import dev.rapid.util.FXMLConstants;
import dev.rapid.util.FunctionUtil;
import dev.rapid.util.StringUtil;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import mockup.controller.Mockup;

public class TaiSanKhacSearchController {
	@FXML
	private TextField tenTaiSanTxt;

	@FXML
	private ComboBox<String> loaiHinhCbb;

	@FXML
	private TextField loaiTaiSanTxt;
	@FXML
	private TextField noiSanXuatTxt;

	@FXML
	private DatePicker namSanXuatFromDp;
	@FXML
	private DatePicker namSanXuatToDp;

	@FXML
	private TextField nguyenGiaTxt;

	@FXML
	private ComboBox<String> phuongPhapTDCbb;

	@FXML
	private TextField giaTriTDFromTxt;
	@FXML
	private TextField giaTriTDToTxt;

	@FXML
	private DatePicker thoiGianTDFromDp;
	@FXML
	private DatePicker thoiGianTDToDp;

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

    private ObservableList<TaiSanKhacDataTable> taiSanKhacData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
    	initData();
    	taiSanKhacList = initTSKLit();
    }

    @FXML
    private void search() {
    	String tenTaiSan = tenTaiSanTxt.getText();
    	String loaiHinh = loaiHinhCbb.getValue();
    	/*String loaiTaiSan = loaiTaiSanTxt.getText();
    	String noiSanXuat = noiSanXuatTxt.getText();
    	LocalDate namSanXuatFrom = namSanXuatFromDp.getValue();
    	LocalDate namSanXuatTo = namSanXuatToDp.getValue();
    	String nguyenGia = nguyenGiaTxt.getText();
    	String phuongPhap = phuongPhapTDCbb.getValue();
    	String giaTriTDFrom = giaTriTDFromTxt.getText();
    	String giaTriTDTo = giaTriTDToTxt.getText();
    	LocalDate thoiGianTDFrom = thoiGianTDFromDp.getValue();
    	LocalDate thoiGianTDTo = thoiGianTDToDp.getValue();*/

    	List<TaiSanKhacDTO> resultList = taiSanKhacList;
    	if(!StringUtil.isNullOrEmpty(tenTaiSan)) {
    		resultList = FunctionUtil.filter(resultList, t -> t.getTenTaiSan().contains(tenTaiSan));
    	}

    	if(!StringUtil.isNullOrEmpty(loaiHinh)) {
    		resultList = FunctionUtil.filter(resultList, t -> t.getLoaiHinh().contains(loaiHinh));
    	}

    	/*if(StringUtil.isNullOrEmpty(tenTaiSan)) {
    		FunctionUtil.filter(resultList, t -> t.getTenTaiSan().contains(tenTaiSan));
    	}*/

    	ObservableList<TaiSanKhacDataTable> taiSanKhacDataTableList = FXCollections.observableArrayList();
		TaiSanKhacDataTable dataTblRec = null;
		for(TaiSanKhacDTO dtoRecord: resultList) {
			dataTblRec = convertFromDTO(dtoRecord);
			taiSanKhacDataTableList.add(dataTblRec);
		}

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
		taiSanKhacTv.setItems(taiSanKhacDataTableList);
		this.taiSanKhacData = taiSanKhacDataTableList;

		taiSanKhacTv.getColumns().get(0).setVisible(false);
		taiSanKhacTv.getColumns().get(0).setVisible(true);
    }

    @FXML
    private void clear() {
    	tenTaiSanTxt.setText("");
    	loaiHinhCbb.setValue(null);
    	loaiTaiSanTxt.setText("");
    	noiSanXuatTxt.setText("");
    	namSanXuatFromDp.setValue(null);
    	namSanXuatToDp.setValue(null);
    	nguyenGiaTxt.setText("");
    	phuongPhapTDCbb.setValue(null);
    	giaTriTDFromTxt.setText("");
    	giaTriTDToTxt.setText("");
    	thoiGianTDFromDp.setValue(null);
    	thoiGianTDToDp.setValue(null);
    }

    public TaiSanKhacDataTable convertFromDTO(TaiSanKhacDTO dto) {
    	TaiSanKhacDataTable result = new TaiSanKhacDataTable();

    	result.setGiaTriTD(dto.getGiaTriTD());
    	result.setLoaiHinh(dto.getLoaiHinh());
    	result.setLoaiTaiSan(dto.getLoaiTaisan());
    	result.setNamSanXuat(DateFormatUtil.localDateToString(dto.getNamSanXuat()));
    	result.setNguyenGia(dto.getNguyenGia());
    	result.setNoiSanXuat(dto.getNoiSanXuat());
    	result.setTenTaiSan(dto.getTenTaiSan());

    	return result;
    }

    public static List<TaiSanKhacDTO> taiSanKhacList = new ArrayList<>();

    public List<TaiSanKhacDTO> initTSKLit() {
    	List<TaiSanKhacDTO> resultList = new ArrayList<>();

    	TaiSanKhacDTO record = null;
    	for(int i=1; i<=10; i++) {
    		record = new TaiSanKhacDTO();
    		record.setTenTaiSan("Tài sản " + i);
    		record.setGhiChu("Ghi chú " + i);
    		record.setGiaTriTD(i + "00, 000, 000");
    		record.setHienTrang("Hiện trạng " + i);
    		if(i%2==0) {
    			record.setLoaiHinh("Tài sản so sánh");
    		} else {
    			record.setLoaiHinh("Tài sản thẩm định");
    		}
    		record.setLoaiTaisan("Loại tài sản " + i);
    		record.setNamSanXuat(DateFormatUtil.stringToLocalDate("200" + (i-1)));
    		record.setNguyenGia((i + 3) + "00, 000, 000");
    		record.setNoiSanXuat("Nơi sản xuất " + i);
    		record.setPhapLy("Pháp lý " + i);
    		record.setPhuongPhap("Phương pháp so sánh");
    		resultList.add(record);
    	}

    	return resultList;
    }

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

 						LocalDate namSanXuat = DateFormatUtil.stringToLocalDate(curRecord.getNamSanXuat().getValue());
 						tskDTO.setNamSanXuat(namSanXuat);
 						tskDTO.setNguyenGia(curRecord.getNguyenGia().getValue().toString());
 						tskDTO.setNoiSanXuat(curRecord.getNoiSanXuat().getValue().toString());
 						tskDTO.setPhapLy("Thuộc quyền sở hữu của ông Nguyễn Văn Chung");
 						tskDTO.setPhuongPhap("Đánh giá");
 						tskDTO.setTenTaiSan(curRecord.getTenTaiSan().getValue().toString());
 						controller.setTaiSanKhacDTO(tskDTO);

 						controller.fillData();

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

 	public void initData() {
		loaiHinhCbb.getItems().addAll("Tài sản thẩm định", "Tài sản so sánh");
		phuongPhapTDCbb.getItems().addAll("Phương pháp so sánh", "Phương pháp đối chiếu", "Phương pháp tỷ giá");
	}

 	private Mockup app;

	public void setApp(Mockup app) {
		this.app = app;
	}
}
