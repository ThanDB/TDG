package mockup.controller;

import java.io.IOException;

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
import mockup.valueobjects.KhachHangDTO;
import mockup.valueobjects.KhachHangDataTable;

public class KhachHangTableViewController {
	@FXML
    private TableView<KhachHangDataTable> khachHangTv;

	@FXML
    private TableColumn<KhachHangDataTable, String> cTenKhachHangTV;
    @FXML
    private TableColumn<KhachHangDataTable, String> cNguoiDaiDienTv;
    @FXML
    private TableColumn<KhachHangDataTable, String> cMaSoThueTv;
    @FXML
    private TableColumn<KhachHangDataTable, String> cDiaChiTv;
    @FXML
    private TableColumn<KhachHangDataTable, String> cSoDienThoaiTv;
    @FXML
    private TableColumn<KhachHangDataTable, String> cFaxTv;
    @FXML
    private TableColumn<KhachHangDataTable, Boolean> cActionTv;

    @FXML
    private void initialize() {
    	cTenKhachHangTV.setCellValueFactory(cellData -> cellData.getValue().getTenKhachHang());
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

        });
    }

	public void setKhachHangData(ObservableList<KhachHangDataTable> khachHangData) {
		this.khachHangData = khachHangData;
		khachHangTv.setItems(this.khachHangData);
	}

	private ObservableList<KhachHangDataTable> khachHangData = FXCollections.observableArrayList();

	//Define the button cell
    private class ButtonCell extends TableCell<KhachHangDataTable, Boolean> {
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
                	KhachHangDataTable curRecord = khachHangData.get(getIndex());
                	System.out.println("do something");

                	try {
                    	FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Mockup.class.getResource(FXMLConstants.KH_DETAIL));
            			AnchorPane page = (AnchorPane) loader.load();

            			// Create the dialog Stage.
            	        Stage dialogStage = new Stage();
            	        dialogStage.setTitle("Tạo mới khách hàng");
            	        dialogStage.initModality(Modality.WINDOW_MODAL);
            	        dialogStage.initOwner(app.primaryStage);
            	        Scene scene = new Scene(page);
            	        dialogStage.setScene(scene);

            	        ChiTietKhachHangController controller = loader.getController();

            	        controller.setTitle("Thông tin khách hàng");
            	        controller.setUpdateButtonTitle("Cập nhật");
            	        controller.setDialogStage(dialogStage);
            	        controller.setKhachHang(new KhachHangDTO(curRecord.getTenKhachHang().getValue().toString(), curRecord.getDiaChi().getValue().toString(), curRecord.getDienThoai().getValue().toString(), curRecord.getFax().getValue().toString(), curRecord.getDaiDien().getValue().toString(), curRecord.getMaSoThue().getValue().toString()));
            	        controller.fillData();
            	        controller.setKhachHangTableViewController(KhachHangTableViewController.this);

            	        dialogStage.showAndWait();

            	        if(khachHang != null) {
            	        	curRecord.setTenKhachHang(khachHang.getTenKhachHang());
                	        curRecord.setDiaChi(khachHang.getDiaChi());
                	        curRecord.setDienThoai(khachHang.getDienThoai());
                	        curRecord.setFax(khachHang.getFax());
                	        curRecord.setDaiDien(khachHang.getDaiDien());
                	        curRecord.setMaSoThue(khachHang.getMaSoThue());
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

    private Mockup app;

    public void setApp(Mockup app) {
    	this.app = app;
    }

    private KhachHangDTO khachHang;

	public void setKhachHang(KhachHangDTO khachHang) {
		this.khachHang = khachHang;
	}
}
