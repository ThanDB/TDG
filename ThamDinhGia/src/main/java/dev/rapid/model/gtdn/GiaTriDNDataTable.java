package dev.rapid.model.gtdn;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class GiaTriDNDataTable {
	private StringProperty tenDoanhNghiep;
	private StringProperty loaiHinh;
	private StringProperty loaiHinhKD;
	private StringProperty namThanhLap;
	private StringProperty vonDieuLe;
	private StringProperty vonChuSoHuu;
	private StringProperty giaTriTS;
	private StringProperty giaTriTD;

	public GiaTriDNDataTable() {
		super();
	}

	public GiaTriDNDataTable(String tenDoanhNghiep, String loaiHinh, String loaiHinhKD, String namThanhLap,
			String vonDieuLe, String vonChuSoHuu, String giaTriTS, String giaTriTD) {
		super();
		this.tenDoanhNghiep = new SimpleStringProperty(tenDoanhNghiep);
		this.loaiHinh = new SimpleStringProperty(loaiHinh);
		this.loaiHinhKD = new SimpleStringProperty(loaiHinhKD);
		this.namThanhLap = new SimpleStringProperty(namThanhLap);
		this.vonDieuLe = new SimpleStringProperty(vonDieuLe);
		this.vonChuSoHuu = new SimpleStringProperty(vonChuSoHuu);
		this.giaTriTS = new SimpleStringProperty(giaTriTS);
		this.giaTriTD = new SimpleStringProperty(giaTriTD);
	}

	public StringProperty getTenDoanhNghiep() {
		return tenDoanhNghiep;
	}

	public void setTenDoanhNghiep(String tenDoanhNghiep) {
		this.tenDoanhNghiep = new SimpleStringProperty(tenDoanhNghiep);
	}

	public StringProperty getLoaiHinh() {
		return loaiHinh;
	}

	public void setLoaiHinh(String loaiHinh) {
		this.loaiHinh = new SimpleStringProperty(loaiHinh);
	}

	public StringProperty getLoaiHinhKD() {
		return loaiHinhKD;
	}

	public void setLoaiHinhKD(String loaiHinhKD) {
		this.loaiHinhKD = new SimpleStringProperty(loaiHinhKD);
	}

	public StringProperty getNamThanhLap() {
		return namThanhLap;
	}

	public void setNamThanhLap(String namThanhLap) {
		this.namThanhLap = new SimpleStringProperty(namThanhLap);
	}

	public StringProperty getVonDieuLe() {
		return vonDieuLe;
	}

	public void setVonDieuLe(String vonDieuLe) {
		this.vonDieuLe = new SimpleStringProperty(vonDieuLe);
	}

	public StringProperty getVonChuSoHuu() {
		return vonChuSoHuu;
	}

	public void setVonChuSoHuu(String vonChuSoHuu) {
		this.vonChuSoHuu = new SimpleStringProperty(vonChuSoHuu);
	}

	public StringProperty getGiaTriTS() {
		return giaTriTS;
	}

	public void setGiaTriTS(String giaTriTS) {
		this.giaTriTD = new SimpleStringProperty(giaTriTS);
	}

	public StringProperty getGiaTriTD() {
		return giaTriTD;
	}

	public void setGiaTriTD(String giaTriTD) {
		this.giaTriTD = new SimpleStringProperty(giaTriTD);
	}

}
