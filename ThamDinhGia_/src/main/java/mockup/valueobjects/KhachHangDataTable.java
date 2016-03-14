package mockup.valueobjects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class KhachHangDataTable {
	private StringProperty tenKhachHang;
	private StringProperty diaChi;
	private StringProperty dienThoai;
	private StringProperty fax;
	private StringProperty daiDien;
	private StringProperty maSoThue;

	public KhachHangDataTable() {
		this(null, null, null, null, null, null);
	}

	public KhachHangDataTable(String tenKhachHang, String daiDien, String maSoThue, String diaChi, String dienThoai, String fax) {
		this.tenKhachHang = new SimpleStringProperty(tenKhachHang);
		this.diaChi = new SimpleStringProperty(diaChi);
		this.dienThoai = new SimpleStringProperty(dienThoai);
		this.fax = new SimpleStringProperty(fax);
		this.daiDien = new SimpleStringProperty(daiDien);
		this.maSoThue = new SimpleStringProperty(maSoThue);
	}

	public StringProperty getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = new SimpleStringProperty(tenKhachHang);
	}

	public StringProperty getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = new SimpleStringProperty(diaChi);
	}

	public StringProperty getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = new SimpleStringProperty(dienThoai);
	}

	public StringProperty getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = new SimpleStringProperty(fax);
	}

	public StringProperty getDaiDien() {
		return daiDien;
	}

	public void setDaiDien(String daiDien) {
		this.daiDien = new SimpleStringProperty(daiDien);
	}

	public StringProperty getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = new SimpleStringProperty(maSoThue);
	}

}
