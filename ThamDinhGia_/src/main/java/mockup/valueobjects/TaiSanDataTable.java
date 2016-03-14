package mockup.valueobjects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TaiSanDataTable {
	private StringProperty tenTaiSan;
	private StringProperty loaiTaiSan;
	private StringProperty phuongPhapThamDinh;
	private StringProperty giaTri;
	private StringProperty soLuong;
	private StringProperty tongGiaTri;

	public TaiSanDataTable() {
		this(null, null, null, null, null, null);
	}

	public TaiSanDataTable(String tenTaiSan, String loaiTaiSan, String phuongPhapThamDinh, String giaTri,
			String soLuong, String tongGiaTri) {
		super();
		this.tenTaiSan = new SimpleStringProperty(tenTaiSan);
		this.loaiTaiSan = new SimpleStringProperty(loaiTaiSan);
		this.phuongPhapThamDinh = new SimpleStringProperty(phuongPhapThamDinh);
		this.giaTri = new SimpleStringProperty(giaTri);
		this.soLuong = new SimpleStringProperty(soLuong);
		this.tongGiaTri = new SimpleStringProperty(tongGiaTri);
	}

	public StringProperty getTenTaiSan() {
		return tenTaiSan;
	}

	public void setTenTaiSan(String tenTaiSan) {
		this.tenTaiSan = new SimpleStringProperty(tenTaiSan);
	}

	public StringProperty getLoaiTaiSan() {
		return loaiTaiSan;
	}

	public void setLoaiTaiSan(String loaiTaiSan) {
		this.loaiTaiSan = new SimpleStringProperty(loaiTaiSan);
	}

	public StringProperty getPhuongPhapThamDinh() {
		return phuongPhapThamDinh;
	}

	public void setPhuongPhapThamDinh(String phuongPhapThamDinh) {
		this.phuongPhapThamDinh = new SimpleStringProperty(phuongPhapThamDinh);
	}

	public StringProperty getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(String giaTri) {
		this.giaTri = new SimpleStringProperty(giaTri);
	}

	public StringProperty getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(String soLuong) {
		this.soLuong = new SimpleStringProperty(soLuong);
	}

	public StringProperty getTongGiaTri() {
		return tongGiaTri;
	}

	public void setTongGiaTri(String tongGiaTri) {
		this.tongGiaTri = new SimpleStringProperty(tongGiaTri);
	}

}
