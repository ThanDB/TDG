package mockup.valueobjects;

public class KhachHangDTO {
	private String tenKhachHang;
	private String diaChi;
	private String dienThoai;
	private String fax;
	private String daiDien;
	private String maSoThue;

	public KhachHangDTO(String tenKhachHang, String diaChi, String dienThoai, String fax, String daiDien,
			String maSoThue) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.fax = fax;
		this.daiDien = daiDien;
		this.maSoThue = maSoThue;
	}

	public KhachHangDTO() {
		super();
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getDaiDien() {
		return daiDien;
	}

	public void setDaiDien(String daiDien) {
		this.daiDien = daiDien;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
}