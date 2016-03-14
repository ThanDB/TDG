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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import mockup.valueobjects.BaoCaoDTO;
import mockup.valueobjects.BaoCaoDataTable;

public class BaoCaoTableViewController {
	@FXML
	private TableView<BaoCaoDataTable> baoCaoTv;

	@FXML
	private TableColumn<BaoCaoDataTable, String> cMaBaoCaoTv;
	@FXML
	private TableColumn<BaoCaoDataTable, String> cMaHopDongTv;
	@FXML
	private TableColumn<BaoCaoDataTable, String> cNguoiThucHienTv;
	@FXML
	private TableColumn<BaoCaoDataTable, String> cNguoiDuyetTv;
	@FXML
	private TableColumn<BaoCaoDataTable, String> cGiaTriTv;
	@FXML
	private TableColumn<BaoCaoDataTable, String> cNgayThucHienTv;
	@FXML
	private TableColumn<BaoCaoDataTable, String> cTrangThaiTv;
	@FXML
	private TableColumn<BaoCaoDataTable, Boolean> cActionTv;

	public void initTableViewData() {
		cMaBaoCaoTv.setCellValueFactory(cellData -> cellData.getValue().getMaBaoCao());
		cMaHopDongTv.setCellValueFactory(cellData -> cellData.getValue().getGiaTri());
		cNguoiThucHienTv.setCellValueFactory(cellData -> cellData.getValue().getTrangThai());
		cNguoiDuyetTv.setCellValueFactory(cellData -> cellData.getValue().getMaBaoCao());
		cGiaTriTv.setCellValueFactory(cellData -> cellData.getValue().getGiaTri());
		cNgayThucHienTv.setCellValueFactory(cellData -> cellData.getValue().getTrangThai());
		cTrangThaiTv.setCellValueFactory(cellData -> cellData.getValue().getMaBaoCao());

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

		baoCaoTv.setItems(initBaoCaoData());
	}

	public ObservableList<BaoCaoDataTable> initBaoCaoData() {
		ObservableList<BaoCaoDataTable> baoCaoData = FXCollections.observableArrayList();

		baoCaoData.add(new BaoCaoDataTable("BC-20160301-01", "HD-20160301", "Nguyen Van A", "Nguyen Van B", "10000000", "01/03/2016", "Chua thanh toan"));
		baoCaoData.add(new BaoCaoDataTable("BC-20160301-02", "HD-20160301", "Nguyen Van A", "Nguyen Van B", "30000000", "01/03/2016", "Chua thanh toan"));

		return baoCaoData;
	}

	public void setApp(Mockup app) {
		this.app = app;

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

}
