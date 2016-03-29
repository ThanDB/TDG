package dev.rapid.controller.tsk;

import dev.rapid.model.tsk.TaiSanKhacDataTable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private TableColumn<TaiSanKhacDataTable, String> actionTc;

    @FXML
    private void initialize() {
    	/*cTenKhachHangTV.setCellValueFactory(cellData -> cellData.getValue().getTenKhachHang());
		cNguoiDaiDienTv.setCellValueFactory(cellData -> cellData.getValue().getDaiDien());
		cMaSoThueTv.setCellValueFactory(cellData -> cellData.getValue().getMaSoThue());
		cDiaChiTv.setCellValueFactory(cellData -> cellData.getValue().getDiaChi());
		cSoDienThoaiTv.setCellValueFactory(cellData -> cellData.getValue().getDienThoai());
		cFaxTv.setCellValueFactory(cellData -> cellData.getValue().getFax());

		cActionTv.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<KhachHangDataTable, Boolean>,
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<KhachHangDataTable, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

		cActionTv.setCellFactory(
                new Callback<TableColumn<KhachHangDataTable, Boolean>, TableCell<KhachHangDataTable, Boolean>>() {

            @Override
            public TableCell<KhachHangDataTable, Boolean> call(TableColumn<KhachHangDataTable, Boolean> p) {
                return new ButtonCell();
            }

        });*/
    }

    @FXML
    private void search() {}

    @FXML
    private void clear() {
    	tenTaiSanTxt.setText("");
    	//loaiHinhCbb
    	loaiTaiSanTxt.setText("");
    	noiSanXuatTxt.setText("");
    	//namSanXuatFromDp
    	//namSanXuatToDp
    	nguyenGiaTxt.setText("");
    	//phuongPhapTDCbb
    	giaTriTDFromTxt.setText("");
    	giaTriTDToTxt.setText("");
    	//thoiGianTDFromDp
    	//thoiGianTDToDp
    }
}
