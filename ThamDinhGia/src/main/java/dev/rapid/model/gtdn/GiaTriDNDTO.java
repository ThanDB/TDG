package dev.rapid.model.gtdn;

import java.time.LocalDate;

public class GiaTriDNDTO {
	private String tenDoanhNghiep;
	private String loaiHinh;
	private String phapLy;
	private String loaiHinhKD;
	private String namThanhLap;
	private LocalDate vonDieuLe;
	private String vonChuSoHuu;
	private String giaTriTaiSan;
	private String phuongPhap;
	private String moTaChung;
	private String giaTriTD;
	private String ghiChu;

	public GiaTriDNDTO() {
		super();
	}

	public GiaTriDNDTO(String tenDoanhNghiep, String loaiHinh, String loaiHinhKD, String phapLy, String namThanhLap,
			LocalDate vonDieuLe, String vonChuSoHuu, String giaTriTaiSan, String phuongPhap, String moTaChung,
			String giaTriTD, String ghiChu) {
		super();
		this.tenDoanhNghiep = tenDoanhNghiep;
		this.loaiHinh = loaiHinh;
		this.loaiHinhKD = loaiHinhKD;
		this.phapLy = phapLy;
		this.namThanhLap = namThanhLap;
		this.vonDieuLe = vonDieuLe;
		this.vonChuSoHuu = vonChuSoHuu;
		this.giaTriTaiSan = giaTriTaiSan;
		this.phuongPhap = phuongPhap;
		this.moTaChung = moTaChung;
		this.giaTriTD = giaTriTD;
		this.ghiChu = ghiChu;
	}

	public String getTenDoanhNghiep() {
		return tenDoanhNghiep;
	}

	public void setTenDoanhNghiep(String tenDoanhNghiep) {
		this.tenDoanhNghiep = tenDoanhNghiep;
	}

	public String getLoaiHinh() {
		return loaiHinh;
	}

	public void setLoaiHinh(String loaiHinh) {
		this.loaiHinh = loaiHinh;
	}

	public String getLoaiHinhKD() {
		return loaiHinhKD;
	}

	public void setLoaiHinhKD(String loaiHinhKD) {
		this.loaiHinhKD = loaiHinhKD;
	}

	public String getPhapLy() {
		return phapLy;
	}

	public void setPhapLy(String phapLy) {
		this.phapLy = phapLy;
	}

	public String getNamThanhLap() {
		return namThanhLap;
	}

	public void setNamThanhLap(String namThanhLap) {
		this.namThanhLap = namThanhLap;
	}

	public LocalDate getVonDieuLe() {
		return vonDieuLe;
	}

	public void setVonDieuLe(LocalDate vonDieuLe) {
		this.vonDieuLe = vonDieuLe;
	}

	public String getVonChuSoHuu() {
		return vonChuSoHuu;
	}

	public void setVonChuSoHuu(String vonChuSoHuu) {
		this.vonChuSoHuu = vonChuSoHuu;
	}

	public String getGiaTriTaiSan() {
		return giaTriTaiSan;
	}

	public void setGiaTriTaiSan(String giaTriTaiSan) {
		this.giaTriTaiSan = giaTriTaiSan;
	}

	public String getPhuongPhap() {
		return phuongPhap;
	}

	public void setPhuongPhap(String phuongPhap) {
		this.phuongPhap = phuongPhap;
	}

	public String getMoTaChung() {
		return moTaChung;
	}

	public void setMoTaChung(String moTaChung) {
		this.moTaChung = moTaChung;
	}

	public String getGiaTriTD() {
		return giaTriTD;
	}

	public void setGiaTriTD(String giaTriTD) {
		this.giaTriTD = giaTriTD;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
