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
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import mockup.valueobjects.BaoCaoDTO;
import mockup.valueobjects.BaoCaoDataTable;
import mockup.valueobjects.HopDongDTO;
import mockup.valueobjects.KhachHangDTO;

public class ChiTietHopDongController extends AbstractController{
	@FXML
	private ComboBox<String> trangThaiCbb;

	@FXML
	private Label tenKhachHangLbl;

	@FXML
	private Label diaChiLbl;

	@FXML
	private Label dienThoaiLbl;

	@FXML
	private Label faxLbl;

	@FXML
	private Label daiDienLbl;

	@FXML
	private Label maSoThueLbl;

	@FXML
	private TextField soHopDongTxt;

	@FXML
	private DatePicker ngayKyDp;

	@FXML
	private TextField giaTriTxt;

	@FXML
	private TextField daThanhToanTxt;

	@FXML
	private TextField nguoiThucHienTxt;

	@FXML
	private TextField nguoiKyTxt;



	@FXML
	private TableView<BaoCaoDataTable> baoCaoTv;
	@FXML
	private TableColumn<BaoCaoDataTable, String> cMaBaoCaoTv;
	@FXML
	private TableColumn<BaoCaoDataTable, String> cTenBaoCaoTv;
	@FXML
	private TableColumn<BaoCaoDataTable, String> cGiaTriTv;
	@FXML
	private TableColumn<BaoCaoDataTable, String> cTrangThaiTv;
	@FXML
	private TableColumn<BaoCaoDataTable, Boolean> cActionTv;

	public void fillBaoCaoDataTableView() {
		ObservableList<BaoCaoDataTable> baoCaoData = FXCollections.observableArrayList();

		baoCaoData.add(new BaoCaoDataTable("BC-20160301-01", "HD-20160301", "Nguyen Van A", "Nguyen Van B", "10000000", "01/03/2016", "Chua thanh toan"));
		baoCaoData.add(new BaoCaoDataTable("BC-20160301-02", "HD-20160301", "Nguyen Van A", "Nguyen Van B", "30000000", "01/03/2016", "Chua thanh toan"));

		cMaBaoCaoTv.setCellValueFactory(cellData -> cellData.getValue().getMaBaoCao());
//		cTenBaoCaoTv.setCellValueFactory(cellData -> cellData.getValue().get);
		cGiaTriTv.setCellValueFactory(cellData -> cellData.getValue().getGiaTri());
		cTrangThaiTv.setCellValueFactory(cellData -> cellData.getValue().getTrangThai());

		cActionTv.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<BaoCaoDataTable, Boolean>,
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BaoCaoDataTable, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

		cActionTv.setCellFactory(
                new Callback<TableColumn<BaoCaoDataTable, Boolean>, TableCell<BaoCaoDataTable, Boolean>>() {

            @Override
            public TableCell<BaoCaoDataTable, Boolean> call(TableColumn<BaoCaoDataTable, Boolean> p) {
                return new ButtonCell();
            }

        });

		baoCaoTv.setItems(baoCaoData);
	}

	public ObservableList<BaoCaoDataTable> initBaoCaoData() {
		ObservableList<BaoCaoDataTable> baoCaoData = FXCollections.observableArrayList();

		baoCaoData.add(new BaoCaoDataTable("BC-20160301-01", "HD-20160301", "Nguyen Van A", "Nguyen Van B", "10000000", "01/03/2016", "Chua thanh toan"));
		baoCaoData.add(new BaoCaoDataTable("BC-20160301-02", "HD-20160301", "Nguyen Van A", "Nguyen Van B", "30000000", "01/03/2016", "Chua thanh toan"));

		return baoCaoData;
	}

	@FXML
	private void taoMoiKhachHang() {
		try {
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Mockup.class.getResource("/fxml/chi_tiet_khach_hang.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Tạo mới khách hàng");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(app.primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        ChiTietKhachHangController controller = loader.getController();

	        controller.setTitle("Tạo mới khách hàng");
	        controller.setUpdateButtonTitle("Tạo mới");
	        controller.setDialogStage(dialogStage);
	        controller.setKhachHang(new KhachHangDTO());
	        controller.setChiTietHopDongController(this);

	        dialogStage.showAndWait();

	        tenKhachHangLbl.setText(this.khachHang.getTenKhachHang());
	        diaChiLbl.setText(this.khachHang.getDiaChi());
	        dienThoaiLbl.setText(this.khachHang.getDienThoai());
	        faxLbl.setText(this.khachHang.getFax());
	        daiDienLbl.setText(this.khachHang.getDaiDien());
	        maSoThueLbl.setText(this.khachHang.getMaSoThue());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void timKiemKhachHang() {
        try {
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Mockup.class.getResource("/fxml/khach_hang_list.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Tìm kiếm khách hàng");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(app.primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        KhachHangListController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setApp(app);

	        dialogStage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void suaKhachHang() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Mockup.class.getResource("/fxml/chi_tiet_khach_hang.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Cập nhật thông tin khách hàng");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(app.primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        ChiTietKhachHangController controller = loader.getController();

	        controller.setDialogStage(dialogStage);
	        controller.setChiTietHopDongController(this);

	        dialogStage.showAndWait();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	private void updateHopDong() {
		this.stage.close();
	}

	@FXML
	private void initialize() {
		trangThaiCbb.getItems().addAll(
        		"Chưa xong",
        		"Đã xong",
        		"Hủy"
        		);
		trangThaiCbb.setPromptText("Trạng thái");
	}

	private Mockup app;
	public void setApp(Mockup obj) {
		this.app = obj;
	}

	private KhachHangDTO khachHang;

	public void setKhachHang(KhachHangDTO khachHang) {
		this.khachHang = khachHang;
	}

	private Stage stage;
	private HopDongTableViewController hopDongTableViewController;
	private HopDongDTO hopDongDTO;

	public void setDialogStage(Stage dialogStage) {
		// TODO Auto-generated method stub
		this.stage = dialogStage;
	}

	public void fillData() {
		if (hopDongDTO != null) {
			soHopDongTxt.setText(hopDongDTO.getMaHopDong());
			giaTriTxt.setText(hopDongDTO.getMaHopDong());
			daThanhToanTxt.setText(hopDongDTO.getMaHopDong());
			nguoiThucHienTxt.setText(hopDongDTO.getMaHopDong());
			nguoiKyTxt.setText(hopDongDTO.getMaHopDong());

			tenKhachHangLbl.setText("Nguyen Van A");
			diaChiLbl.setText("Ha noi");
			dienThoaiLbl.setText("01234567890");
			faxLbl.setText("01234567890");
			daiDienLbl.setText("Nguyen Van B");
			maSoThueLbl.setText("01234567890");
		}

	}

	public void setHopDongTableViewController(HopDongTableViewController hopDongTableViewController) {
		// TODO Auto-generated method stub
		this.hopDongTableViewController = hopDongTableViewController;
	}

	public void setHopDong(HopDongDTO hopDongDTO) {
		// TODO Auto-generated method stub
		this.hopDongDTO = hopDongDTO;

	}

	//Define the button cell
    private class ButtonCell extends TableCell<BaoCaoDataTable, Boolean> {
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


                	BaoCaoDataTable curRecord = initBaoCaoData().get(getIndex());
                	System.out.println("do something");

                	try {
                    	FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Mockup.class.getResource("/fxml/chi_tiet_bao_cao.fxml"));
            			AnchorPane page = (AnchorPane) loader.load();

            			// Create the dialog Stage.
            	        Stage dialogStage = new Stage();
            	        dialogStage.setTitle("Thông tin báo cáo");
            	        dialogStage.initModality(Modality.WINDOW_MODAL);
            	        dialogStage.initOwner(app.primaryStage);
            	        Scene scene = new Scene(page);
            	        dialogStage.setScene(scene);

            	        ChiTietBaoCaoController controller = loader.getController();

            	        controller.setTitle("Thông tin báo cáo");
            	        controller.setUpdateButtonTitle("Cập nhật");
            	        controller.setDialogStage(dialogStage);
            	        controller.setBaoCao(new BaoCaoDTO());
            	        controller.fillData();
            	        //controller.setKhachHangTableViewController(ChiTie.this);
            	        controller.initData();
            	        controller.initTaiSanTableView();
            	        controller.setStage(dialogStage);
            	        controller.setApp(app);

            	        dialogStage.showAndWait();

            	        if(khachHang != null) {
//            	        	curRecord.setTenKhachHang(khachHang.getTenKhachHang());
//                	        curRecord.setDiaChi(khachHang.getDiaChi());
//                	        curRecord.setDienThoai(khachHang.getDienThoai());
//                	        curRecord.setFax(khachHang.getFax());
//                	        curRecord.setDaiDien(khachHang.getDaiDien());
//                	        curRecord.setMaSoThue(khachHang.getMaSoThue());
            	        }

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
}
