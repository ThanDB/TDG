package mockup.controller;

import java.io.IOException;

import dev.rapid.util.Constants;
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
import mockup.controller.AbstractController.PROCESS_STT;
import mockup.valueobjects.HopDongDTO;
import mockup.valueobjects.HopDongDataTable;

public class HopDongTableViewController {
	@FXML
    private TableView<HopDongDataTable> hopDongTv;

	@FXML
    private TableColumn<HopDongDataTable, String> cMaHopDongTv;
    @FXML
    private TableColumn<HopDongDataTable, String> cTenKhachHangTv;
    @FXML
    private TableColumn<HopDongDataTable, String> cNguoiThucHienTv;
//    @FXML
//    private TableColumn<HopDongDataTable, String> cNguoiKyTv;
    @FXML
    private TableColumn<HopDongDataTable, String> cNgayKyTv;
    @FXML
    private TableColumn<HopDongDataTable, String> cGiaTriTv;
//    @FXML
//    private TableColumn<HopDongDataTable, String> cChuaThanhToanTv;
//    @FXML
//    private TableColumn<HopDongDataTable, String> cTrangThaiTv;

    @FXML
    private TableColumn<HopDongDataTable, Boolean> cActionTv;

    @FXML
    private void initialize() {
    	cMaHopDongTv.setCellValueFactory(cellData -> cellData.getValue().getMaHopDong());
    	cTenKhachHangTv.setCellValueFactory(cellData -> cellData.getValue().getTenKhachHang());
    	cNguoiThucHienTv.setCellValueFactory(cellData -> cellData.getValue().getNguoiThucHien());
    	//cNguoiKyTv.setCellValueFactory(cellData -> cellData.getValue().getNguoiKy());
    	cNgayKyTv.setCellValueFactory(cellData -> cellData.getValue().getNgayKy());
    	cGiaTriTv.setCellValueFactory(cellData -> cellData.getValue().getGiaTri());

//    	cChuaThanhToanTv.setCellValueFactory(cellData -> cellData.getValue().getChuaThanhToan());
//    	cTrangThaiTv.setCellValueFactory(cellData -> cellData.getValue().getTrangThai());

		cActionTv.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<HopDongDataTable, Boolean>,
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<HopDongDataTable, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

		cActionTv.setCellFactory(
                new Callback<TableColumn<HopDongDataTable, Boolean>, TableCell<HopDongDataTable, Boolean>>() {

            @Override
            public TableCell<HopDongDataTable, Boolean> call(TableColumn<HopDongDataTable, Boolean> p) {
                return new ButtonCell();
            }

        });
    }

	public void setHopDongData(ObservableList<HopDongDataTable> hopDongData) {
		this.hopDongData = hopDongData;
		hopDongTv.setItems(this.hopDongData);
	}

	private ObservableList<HopDongDataTable> hopDongData = FXCollections.observableArrayList();

	//Define the button cell
    private class ButtonCell extends TableCell<HopDongDataTable, Boolean> {
        final Button viewButton = new Button(Constants.DETAIL_TEXT);
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
                	HopDongDataTable curRecord = hopDongData.get(getIndex());

                	try {
                    	FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Mockup.class.getResource(Constants.CHI_TIET_HOPDONG_FILE_PATH));
            			AnchorPane page = (AnchorPane) loader.load();

            			// Create the dialog Stage.
            	        Stage dialogStage = new Stage();
            	        dialogStage.setTitle(Constants.DETAIL_HOPDONG_TEXT);
            	        dialogStage.initModality(Modality.WINDOW_MODAL);
            	        dialogStage.initOwner(app.primaryStage);
            	        Scene scene = new Scene(page);
            	        dialogStage.setScene(scene);

            	        ChiTietHopDongController controller = loader.getController();

            	        controller.processStt = PROCESS_STT.DETAIL;
            	        //controller.setTitle(Constants.CHI_TIET_HOPDONG_TEXT);
            	        //controller.setUpdateButtonTitle(Constants.UPDATE_TEXT);
            	        controller.setDialogStage(dialogStage);
            	        controller.setHopDong(new HopDongDTO(curRecord.getMaHopDong().getValue().toString(), curRecord.getTenKhachHang().getValue().toString(), curRecord.getNguoiThucHien().getValue().toString(), curRecord.getNguoiKy().getValue().toString(), curRecord.getNgayKy().getValue().toString(), curRecord.getGiaTri().getValue().toString(), curRecord.getChuaThanhToan().getValue().toString(), curRecord.getTrangThai().getValue().toString()));
            	        controller.fillData();
            	        controller.setUpComponents(Constants.DETAIL_HOPDONG_TEXT, Constants.MODIFY_TEXT);
            	        controller.setHopDongTableViewController(HopDongTableViewController.this);
            	        controller.setApp(app);
            	        //controller.fillBaoCaoDataTableView();

            	        dialogStage.showAndWait();

            	        if(hopDong != null) {
            	        	System.out.println("update hop dong successfully");
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

    private HopDongDTO hopDong;

	public void setKhachHang(HopDongDTO hopDong) {
		this.hopDong = hopDong;
	}
}
