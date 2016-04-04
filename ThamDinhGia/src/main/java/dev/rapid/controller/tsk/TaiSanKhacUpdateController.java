package dev.rapid.controller.tsk;

import dev.rapid.model.tsk.TaiSanKhacDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TaiSanKhacUpdateController {
	@FXML
	private TextField tenTaiSanTxt;

	@FXML
	private ComboBox<String> loaiHinhCbb;

	@FXML
	private TextField loaiTaiSanTxt;
	@FXML
	private TextField phapLyTxt;
	@FXML
	private TextField noiSanXuatTxt;

	@FXML
	private DatePicker namSanXuatDp;

	@FXML
	private TextField nguyenGiaTxt;
	@FXML
	private TextField hienTrangTxt;

	@FXML
	private ComboBox<String> phuongPhapTDCbb;

	@FXML
	private TextField giaTriTDTxt;

	@FXML
	private TextArea ghiChuTA;

	@FXML
	private Button editBtn;

	@FXML
	public void update() {
		if(isView) {
			isView = false;
			editBtn.setText("Cập nhật");
			setEditableElements();
		} else {
			tskDTO.setGhiChu(ghiChuTA.getText());
			tskDTO.setGiaTriTD(giaTriTDTxt.getText());
			tskDTO.setHienTrang(hienTrangTxt.getText());
			tskDTO.setLoaiHinh(loaiHinhCbb.getValue());
			tskDTO.setLoaiTaisan(loaiTaiSanTxt.getText());
			tskDTO.setNamSanXuat(namSanXuatDp.getValue());
			tskDTO.setNguyenGia(nguyenGiaTxt.getText());
			tskDTO.setNoiSanXuat(noiSanXuatTxt.getText());
			tskDTO.setPhapLy(phapLyTxt.getText());
			tskDTO.setPhuongPhap(phuongPhapTDCbb.getValue());
			tskDTO.setTenTaiSan(tenTaiSanTxt.getText());

			if(this.dialogStage != null) {
				this.dialogStage.close();
			}
		}
	}

	@FXML
	public void close() {
		if(this.dialogStage != null) {
			this.dialogStage.close();
		}
	}

	public void setEditableElements() {
		setDisable(false);
	}

	public void setDisableElements() {
		setDisable(true);
	}

	private void setDisable(boolean enableStt) {
		tenTaiSanTxt.setEditable(!enableStt);
		loaiHinhCbb.setDisable(enableStt);
		loaiTaiSanTxt.setEditable(!enableStt);
		phapLyTxt.setEditable(!enableStt);
		noiSanXuatTxt.setEditable(!enableStt);
		namSanXuatDp.setDisable(enableStt);
		nguyenGiaTxt.setEditable(!enableStt);
		hienTrangTxt.setEditable(!enableStt);

		phuongPhapTDCbb.setDisable(enableStt);
		giaTriTDTxt.setEditable(!enableStt);
		ghiChuTA.setEditable(!enableStt);
	}


	public void fillData() {
		tenTaiSanTxt.setText(tskDTO.getTenTaiSan());
		loaiHinhCbb.setValue(tskDTO.getLoaiHinh());
		loaiTaiSanTxt.setText(tskDTO.getLoaiTaisan());
		phapLyTxt.setText(tskDTO.getPhapLy());
		noiSanXuatTxt.setText(tskDTO.getNoiSanXuat());
		namSanXuatDp.setValue(tskDTO.getNamSanXuat());
		nguyenGiaTxt.setText(tskDTO.getNguyenGia());
		hienTrangTxt.setText(tskDTO.getHienTrang());

		phuongPhapTDCbb.setValue(tskDTO.getPhuongPhap());
		giaTriTDTxt.setText(tskDTO.getGiaTriTD());
		ghiChuTA.setText(tskDTO.getGhiChu());
	}

	@FXML
	private void initialize() {
		loaiHinhCbb.getItems().addAll("Tài sản thẩm định", "Tài sản so sánh");
	}
	public void setDialog(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setViewStatus(boolean isView) {
		this.isView = isView;
	}

	public boolean getViewStatus() {
		return isView;
	}

	public void setTaiSanKhacDTO(dev.rapid.model.tsk.TaiSanKhacDTO tskDTO) {
		this.tskDTO = tskDTO;
	}

	public TaiSanKhacDTO getTaiSanKhacDTO() {
		return tskDTO;
	}

	private Stage dialogStage;

	private boolean isView = true;

	private TaiSanKhacDTO tskDTO;
}
