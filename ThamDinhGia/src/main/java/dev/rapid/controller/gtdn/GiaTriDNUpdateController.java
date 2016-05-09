package dev.rapid.controller.gtdn;

import dev.rapid.model.gtdn.GiaTriDNDTO;
import dev.rapid.model.tsk.TaiSanKhacDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GiaTriDNUpdateController {
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
		if (isView) {
			isView = false;
			editBtn.setText("Cập nhật");
			setEditableElements();
		} else {
			dto.setGhiChu(ghiChuTA.getText());
			dto.setGiaTriTD(giaTriTDTxt.getText());
			//dto.setHienTrang(hienTrangTxt.getText());
			dto.setLoaiHinh(loaiHinhCbb.getValue());
			dto.setLoaiTaisan(loaiTaiSanTxt.getText());
			dto.setNamSanXuat(namSanXuatDp.getValue());
			dto.setNguyenGia(nguyenGiaTxt.getText());
			dto.setNoiSanXuat(noiSanXuatTxt.getText());
			dto.setPhapLy(phapLyTxt.getText());
			dto.setPhuongPhap(phuongPhapTDCbb.getValue());
			dto.setTenTaiSan(tenTaiSanTxt.getText());

			if (this.dialogStage != null) {
				this.dialogStage.close();
			}
		}
	}

	@FXML
	public void close() {
		if (this.dialogStage != null) {
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
		tenTaiSanTxt.setText(dto.getTenTaiSan());
		loaiHinhCbb.setValue(dto.getLoaiHinh());
		loaiTaiSanTxt.setText(dto.getLoaiTaisan());
		phapLyTxt.setText(dto.getPhapLy());
		noiSanXuatTxt.setText(dto.getNoiSanXuat());
		namSanXuatDp.setValue(dto.getNamSanXuat());
		nguyenGiaTxt.setText(dto.getNguyenGia());
		hienTrangTxt.setText(dto.getHienTrang());

		phuongPhapTDCbb.setValue(dto.getPhuongPhap());
		giaTriTDTxt.setText(dto.getGiaTriTD());
		ghiChuTA.setText(dto.getGhiChu());
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

	public GiaTriDNDTO getDto() {
		return dto;
	}

	public void setDto(GiaTriDNDTO dto) {
		this.dto = dto;
	}

	private Stage dialogStage;

	private boolean isView = true;

	private GiaTriDNDTO dto;
}
