package mockup.controller;

import java.io.IOException;

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
import mockup.valueobjects.BaoCaoDTO;
import mockup.valueobjects.TaiSanDataTable;

public class ChiTietBaoCaoController extends AbstractController {

	@FXML
	private TextField maHopDongTxt;

	@FXML
	private TextField maBaoCaoTxt;

	@FXML
	private TextField nguoiThucHienTxt;

	@FXML
	private TextField nguoiDuyetTxt;

	@FXML
	private TextField giaTriTxt;

	@FXML
	private DatePicker ngayThucHienDp;

	@FXML
	private ComboBox<String> trangThaiCbb;

	@FXML
	private ComboBox<String> loaiTaiSanCbb;

	@FXML
	private TableView<TaiSanDataTable> taiSanDataTv;

	@FXML
	private TableColumn<TaiSanDataTable, String> cTenTaiSantv;

	@FXML
	private TableColumn<TaiSanDataTable, String> cLoaiTaiSanTv;
	@FXML
	private TableColumn<TaiSanDataTable, String> cPhuongPhapTv;
	@FXML
	private TableColumn<TaiSanDataTable, String> cGiaTriTv;
	@FXML
	private TableColumn<TaiSanDataTable, String> cSoLuongTv;
	@FXML
	private TableColumn<TaiSanDataTable, String> cTongGiaTriTv;

	@FXML
	private TableColumn<TaiSanDataTable, Boolean> cActionTv;

	public void initTaiSanTableView() {
		cTenTaiSantv.setCellValueFactory(cellData -> cellData.getValue().getTenTaiSan());
		cLoaiTaiSanTv.setCellValueFactory(cellData -> cellData.getValue().getLoaiTaiSan());
		cPhuongPhapTv.setCellValueFactory(cellData -> cellData.getValue().getPhuongPhapThamDinh());
		cGiaTriTv.setCellValueFactory(cellData -> cellData.getValue().getGiaTri());
		cSoLuongTv.setCellValueFactory(cellData -> cellData.getValue().getSoLuong());
		cTongGiaTriTv.setCellValueFactory(cellData -> cellData.getValue().getTongGiaTri());

		cActionTv.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<TaiSanDataTable, Boolean>,
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<TaiSanDataTable, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

		cActionTv.setCellFactory(
                new Callback<TableColumn<TaiSanDataTable, Boolean>, TableCell<TaiSanDataTable, Boolean>>() {

            @Override
            public TableCell<TaiSanDataTable, Boolean> call(TableColumn<TaiSanDataTable, Boolean> p) {
                return new ButtonCell();
            }

        });

		taiSanDataTv.setItems(initTaiSanData());
	}

	public ObservableList<TaiSanDataTable> initTaiSanData() {
		ObservableList<TaiSanDataTable> taiSanData = FXCollections.observableArrayList();

		taiSanData.add(new TaiSanDataTable("Máy nông nghiệp", "Máy móc thiết bị", "So sánh", "50000000", "2", "10000000"));

		return taiSanData;
	}

	private Stage dialog;
	private BaoCaoDTO baoCaoDTO;

	public void setDialogStage(Stage dialogStage) {
		// TODO Auto-generated method stub
		this.dialog = dialogStage;
	}

	public void setBaoCao(BaoCaoDTO baoCaoDTO) {
		// TODO Auto-generated method stub
		this.baoCaoDTO = baoCaoDTO;
	}

	public void fillData() {
		// TODO Auto-generated method stub
		if(baoCaoDTO!=null) {

		}
	}

	@FXML
	public void initialize(){
		trangThaiCbb.getItems().addAll("Chờ duyệt", "Sửa", "Hoàn thiện", "Hủy");
		loaiTaiSanCbb.getItems().addAll("Máy móc thiết bị", "Bất động sản - dự án", "Giá trị doanh nghiệp", "Phương tiện vận tải");
	}

	@FXML
	public void taoMoiTaiSan() {
	}

	@FXML
	public void update() {
		this.stage.close();
	}

	public void initData() {
		maHopDongTxt.setText("HD-0001");
		maBaoCaoTxt.setText("BC-0001");
		nguoiThucHienTxt.setText("BC-0001");
		nguoiDuyetTxt.setText("BC-0001");
		giaTriTxt.setText("100000000");
	}

	//Define the button cell
    private class ButtonCell extends TableCell<TaiSanDataTable, Boolean> {
        final Button viewButton = new Button("Chi tiết");
//        final Button deleteButton = new Button("Xóa");

        ButtonCell(){

//        	deleteButton.setOnAction(new EventHandler<ActionEvent>() {
//        		@Override
//        		public void handle(ActionEvent event) {
//        			// TODO Auto-generated method stub
//
//        		}
//			});

        	viewButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    // do something when button clicked
                    //...
                	System.out.println("" + getIndex());
                	TaiSanDataTable curRecord = initTaiSanData().get(getIndex());
                	System.out.println("do something");

                	try {
                    	FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Mockup.class.getResource("/fxml/chi_tiet_may_moc_thiet_bi.fxml"));
            			AnchorPane page = (AnchorPane) loader.load();

            			// Create the dialog Stage.
            	        Stage dialogStage = new Stage();
            	        dialogStage.setTitle("Thông tin tài sản");
            	        dialogStage.initModality(Modality.WINDOW_MODAL);
            	        dialogStage.initOwner(app.primaryStage);
            	        Scene scene = new Scene(page);
            	        dialogStage.setScene(scene);

            	        ChiTietMayMocThietBiController controller = loader.getController();

            	        controller.setTitle("Thông tin tài sản");
            	        controller.setUpdateButtonTitle("Cập nhật");
            	        controller.setStage(dialogStage);
            	        controller.setApp(app);
//            	        controller.setKhachHang(new KhachHangDTO(curRecord.getTenKhachHang().getValue().toString(), curRecord.getDiaChi().getValue().toString(), curRecord.getDienThoai().getValue().toString(), curRecord.getFax().getValue().toString(), curRecord.getDaiDien().getValue().toString(), curRecord.getMaSoThue().getValue().toString()));
//            	        controller.setKhachHangTableViewController(KhachHangTableViewController.this);

            	        dialogStage.showAndWait();

//            	        if(khachHang != null) {
//            	        	curRecord.setTenKhachHang(khachHang.getTenKhachHang());
//                	        curRecord.setDiaChi(khachHang.getDiaChi());
//                	        curRecord.setDienThoai(khachHang.getDienThoai());
//                	        curRecord.setFax(khachHang.getFax());
//                	        curRecord.setDaiDien(khachHang.getDaiDien());
//                	        curRecord.setMaSoThue(khachHang.getMaSoThue());
//            	        }

            		} catch (IOException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(viewButton);
                //setGraphic(deleteButton);
            }
        }
    }

    private Mockup app;
    private Stage stage;

    public void setApp(Mockup obj) {
    	this.app = obj;
    }

    public void setStage(Stage stage) {
    	this.stage = stage;
    }

}
