package mockup.valueobjects;

public class HopDongDTO {
	private String maHopDong;
	private String tenKhachHang;
	private String nguoiThucHien;
	private String nguoiKy;
	private String ngayKy;
	private String giaTri;
	private String chuaThanhToan;
	private String trangThai;

	public String getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getNguoiThucHien() {
		return nguoiThucHien;
	}

	public void setNguoiThucHien(String nguoiThucHien) {
		this.nguoiThucHien = nguoiThucHien;
	}

	public String getNguoiKy() {
		return nguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	public String getNgayKy() {
		return ngayKy;
	}

	public void setNgayKy(String ngayKy) {
		this.ngayKy = ngayKy;
	}

	public String getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(String giaTri) {
		this.giaTri = giaTri;
	}

	public String getChuaThanhToan() {
		return chuaThanhToan;
	}

	public void setChuaThanhToan(String chuaThanhToan) {
		this.chuaThanhToan = chuaThanhToan;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public HopDongDTO(String maHopDong, String tenKhachHang, String nguoiThucHien, String nguoiKy, String ngayKy,
			String giaTri, String chuaThanhToan, String trangThai) {
		super();
		this.maHopDong = maHopDong;
		this.tenKhachHang = tenKhachHang;
		this.nguoiThucHien = nguoiThucHien;
		this.nguoiKy = nguoiKy;
		this.ngayKy = ngayKy;
		this.giaTri = giaTri;
		this.chuaThanhToan = chuaThanhToan;
		this.trangThai = trangThai;
	}

}
