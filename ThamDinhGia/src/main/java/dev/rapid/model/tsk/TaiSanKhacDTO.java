package dev.rapid.model.tsk;

import java.time.LocalDate;

public class TaiSanKhacDTO {
	private String tenTaiSan;
	private String loaiHinh;
	private String loaiTaisan;
	private String phapLy;
	private String noiSanXuat;
	private LocalDate namSanXuat;
	private String nguyenGia;
	private String hienTrang;
	private String phuongPhap;
	private String giaTriTD;
	private String ghiChu;

	public TaiSanKhacDTO() {
		super();
	}

	public TaiSanKhacDTO(String tenTaiSan, String loaiHinh, String loaiTaisan, String phapLy, String noiSanXuat,
			LocalDate namSanXuat, String nguyenGia, String hienTrang, String phuongPhap, String giaTriTD,
			String ghiChu) {
		super();
		this.tenTaiSan = tenTaiSan;
		this.loaiHinh = loaiHinh;
		this.loaiTaisan = loaiTaisan;
		this.phapLy = phapLy;
		this.noiSanXuat = noiSanXuat;
		this.namSanXuat = namSanXuat;
		this.nguyenGia = nguyenGia;
		this.hienTrang = hienTrang;
		this.phuongPhap = phuongPhap;
		this.giaTriTD = giaTriTD;
		this.ghiChu = ghiChu;
	}

	public String getTenTaiSan() {
		return tenTaiSan;
	}

	public void setTenTaiSan(String tenTaiSan) {
		this.tenTaiSan = tenTaiSan;
	}

	public String getLoaiHinh() {
		return loaiHinh;
	}

	public void setLoaiHinh(String loaiHinh) {
		this.loaiHinh = loaiHinh;
	}

	public String getLoaiTaisan() {
		return loaiTaisan;
	}

	public void setLoaiTaisan(String loaiTaisan) {
		this.loaiTaisan = loaiTaisan;
	}

	public String getPhapLy() {
		return phapLy;
	}

	public void setPhapLy(String phapLy) {
		this.phapLy = phapLy;
	}

	public String getNoiSanXuat() {
		return noiSanXuat;
	}

	public void setNoiSanXuat(String noiSanXuat) {
		this.noiSanXuat = noiSanXuat;
	}

	public LocalDate getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(LocalDate namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public String getNguyenGia() {
		return nguyenGia;
	}

	public void setNguyenGia(String nguyenGia) {
		this.nguyenGia = nguyenGia;
	}

	public String getHienTrang() {
		return hienTrang;
	}

	public void setHienTrang(String hienTrang) {
		this.hienTrang = hienTrang;
	}

	public String getPhuongPhap() {
		return phuongPhap;
	}

	public void setPhuongPhap(String phuongPhap) {
		this.phuongPhap = phuongPhap;
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
