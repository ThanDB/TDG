package dev.rapid.model.tsk;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class TaiSanKhacDataTable {
	private StringProperty tenTaiSan;
	private StringProperty loaiHinh;
	private StringProperty loaiTaiSan;
	private StringProperty noiSanXuat;
	private StringProperty namSanXuat;
	private StringProperty nguyenGia;
	private StringProperty giaTriTD;

	public TaiSanKhacDataTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiSanKhacDataTable(String tenTaiSan, String loaiHinh, String loaiTaiSan, String noiSanXuat,
			String namSanXuat, String nguyenGia, String giaTriTD) {
		super();
		this.tenTaiSan = new SimpleStringProperty(tenTaiSan);
		this.loaiHinh = new SimpleStringProperty(loaiHinh);
		this.loaiTaiSan = new SimpleStringProperty(loaiTaiSan);
		this.noiSanXuat = new SimpleStringProperty(noiSanXuat);
		this.namSanXuat = new SimpleStringProperty(namSanXuat);
		this.nguyenGia = new SimpleStringProperty(nguyenGia);
		this.giaTriTD = new SimpleStringProperty(giaTriTD);
	}

	public StringProperty getTenTaiSan() {
		return tenTaiSan;
	}

	public void setTenTaiSan(String tenTaiSan) {
		this.tenTaiSan = new SimpleStringProperty(tenTaiSan);
	}

	public StringProperty getLoaiHinh() {
		return loaiHinh;
	}

	public void setLoaiHinh(String loaiHinh) {
		this.loaiHinh = new SimpleStringProperty(loaiHinh);
	}

	public StringProperty getLoaiTaiSan() {
		return loaiTaiSan;
	}

	public void setLoaiTaiSan(String loaiTaiSan) {
		this.loaiTaiSan = new SimpleStringProperty(loaiTaiSan);
	}

	public StringProperty getNoiSanXuat() {
		return noiSanXuat;
	}

	public void setNoiSanXuat(String noiSanXuat) {
		this.noiSanXuat = new SimpleStringProperty(noiSanXuat);
	}

	public StringProperty getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(String namSanXuat) {
		this.namSanXuat = new SimpleStringProperty(namSanXuat);
	}

	public StringProperty getNguyenGia() {
		return nguyenGia;
	}

	public void setNguyenGia(String nguyenGia) {
		this.nguyenGia = new SimpleStringProperty(nguyenGia);
	}

	public StringProperty getGiaTriTD() {
		return giaTriTD;
	}

	public void setGiaTriTD(String giaTriTD) {
		this.giaTriTD = new SimpleStringProperty(giaTriTD);
	}

}
