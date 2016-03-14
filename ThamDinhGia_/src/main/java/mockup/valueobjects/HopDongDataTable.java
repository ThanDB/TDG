package mockup.valueobjects;

import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HopDongDataTable {
	private StringProperty maHopDong;
	private StringProperty tenKhachHang;
	private StringProperty nguoiThucHien;
	private StringProperty nguoiKy;
	private StringProperty ngayKy;
	private StringProperty giaTri;
	private StringProperty chuaThanhToan;
	private StringProperty trangThai;

	public HopDongDataTable() {
		this(null, null, null, null, null, null, null, null);
	}

	public HopDongDataTable(String maHopDong, String tenKhachHang, String nguoiThucHien,
			String nguoiKy, String ngayKy, String giaTri, String chuaThanhToan,
			String trangThai) {
		super();
		this.maHopDong = new SimpleStringProperty(maHopDong);
		this.tenKhachHang = new SimpleStringProperty(tenKhachHang);
		this.nguoiThucHien = new SimpleStringProperty(nguoiThucHien);
		this.nguoiKy = new SimpleStringProperty(nguoiKy);
		this.ngayKy = new SimpleStringProperty(ngayKy);
		this.giaTri = new SimpleStringProperty(giaTri);
		this.chuaThanhToan = new SimpleStringProperty(chuaThanhToan);
		this.trangThai = new SimpleStringProperty(trangThai);

	}

	public StringProperty getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(String maHopDong) {
		this.maHopDong = new SimpleStringProperty(maHopDong);
	}

	public StringProperty getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = new SimpleStringProperty(tenKhachHang);
	}

	public StringProperty getNguoiThucHien() {
		return nguoiThucHien;
	}

	public void setNguoiThucHien(String nguoiThucHien) {
		this.nguoiThucHien = new SimpleStringProperty(nguoiThucHien);
	}

	public StringProperty getNguoiKy() {
		return nguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = new SimpleStringProperty(nguoiKy);
	}

	public StringProperty getNgayKy() {
		return ngayKy;
	}

	public void setNgayKy(String ngayKy) {
		this.ngayKy = new SimpleStringProperty(ngayKy);
	}

	public StringProperty getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(String giaTri) {
		this.giaTri = new SimpleStringProperty(giaTri);
	}

	public StringProperty getChuaThanhToan() {
		return chuaThanhToan;
	}

	public void setChuaThanhToan(String chuaThanhToan) {
		this.chuaThanhToan = new SimpleStringProperty(chuaThanhToan);
	}

	public StringProperty getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = new SimpleStringProperty(trangThai);
	}

	public BooleanExpression getDaiDien() {
		// TODO Auto-generated method stub
		return null;
	}

}
