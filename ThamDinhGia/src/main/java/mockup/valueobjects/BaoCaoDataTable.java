package mockup.valueobjects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BaoCaoDataTable {
	private StringProperty maBaoCao;
	private StringProperty maHopDong;
	private StringProperty nguoiThucHien;
	private StringProperty nguoiDuyet;
	private StringProperty giaTri;
	private StringProperty ngayThucHien;
	private StringProperty trangThai;

	public BaoCaoDataTable() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BaoCaoDataTable(String maBaoCao, String maHopDong, String nguoiThucHien,
			String nguoiDuyet, String giaTri, String ngayThucHien, String trangThai) {
		super();
		this.maBaoCao = new SimpleStringProperty(maBaoCao);
		this.maHopDong = new SimpleStringProperty(maHopDong);
		this.nguoiThucHien = new SimpleStringProperty(nguoiThucHien);
		this.nguoiDuyet = new SimpleStringProperty(nguoiDuyet);
		this.giaTri = new SimpleStringProperty(giaTri);
		this.ngayThucHien = new SimpleStringProperty(ngayThucHien);
		this.trangThai = new SimpleStringProperty(trangThai);
	}
	public StringProperty getMaBaoCao() {
		return maBaoCao;
	}

	public void setMaBaoCao(String maBaoCao) {
		this.maBaoCao = new SimpleStringProperty(maBaoCao);
	}

	public StringProperty getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(String maHopDong) {
		this.maHopDong = new SimpleStringProperty(maHopDong);
	}

	public StringProperty getNguoiThucHien() {
		return nguoiThucHien;
	}

	public void setNguoiThucHien(String nguoiThucHien) {
		this.nguoiThucHien = new SimpleStringProperty(nguoiThucHien);
	}

	public StringProperty getNguoiDuyet() {
		return nguoiDuyet;
	}

	public void setNguoiDuyet(String nguoiDuyet) {
		this.nguoiDuyet = new SimpleStringProperty(nguoiDuyet);
	}

	public StringProperty getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(String giaTri) {
		this.giaTri = new SimpleStringProperty(giaTri);
	}

	public StringProperty getNgayThucHien() {
		return ngayThucHien;
	}

	public void setNgayThucHien(String ngayThucHien) {
		this.ngayThucHien = new SimpleStringProperty(ngayThucHien);
	}

	public StringProperty getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = new SimpleStringProperty(trangThai);
	}

}
