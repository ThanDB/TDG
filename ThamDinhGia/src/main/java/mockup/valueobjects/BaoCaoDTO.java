package mockup.valueobjects;

public class BaoCaoDTO {
	private String maBaoCao;
	private String maHopDong;
	private String nguoiThucHien;
	private String nguoiDuyet;
	private String giaTri;
	private String ngayThucHien;
	private String trangThai;

	public String getMaBaoCao() {
		return maBaoCao;
	}

	public void setMaBaoCao(String maBaoCao) {
		this.maBaoCao = maBaoCao;
	}

	public String getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}

	public String getNguoiThucHien() {
		return nguoiThucHien;
	}

	public void setNguoiThucHien(String nguoiThucHien) {
		this.nguoiThucHien = nguoiThucHien;
	}

	public String getNguoiDuyet() {
		return nguoiDuyet;
	}

	public void setNguoiDuyet(String nguoiDuyet) {
		this.nguoiDuyet = nguoiDuyet;
	}

	public String getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(String giaTri) {
		this.giaTri = giaTri;
	}

	public String getNgayThucHien() {
		return ngayThucHien;
	}

	public void setNgayThucHien(String ngayThucHien) {
		this.ngayThucHien = ngayThucHien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public BaoCaoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaoCaoDTO(String maBaoCao, String maHopDong, String nguoiThucHien, String nguoiDuyet, String giaTri,
			String ngayThucHien, String trangThai) {
		super();
		this.maBaoCao = maBaoCao;
		this.maHopDong = maHopDong;
		this.nguoiThucHien = nguoiThucHien;
		this.nguoiDuyet = nguoiDuyet;
		this.giaTri = giaTri;
		this.ngayThucHien = ngayThucHien;
		this.trangThai = trangThai;
	}

}
