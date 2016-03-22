package dev.rapid.domain;
// Generated Jan 24, 2016 10:48:55 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TaiSan generated by hbm2java
 */
@Entity
@Table(name = "tai_san", catalog = "thamdinhgia_db")
public class TaiSan implements java.io.Serializable {

	private Integer idTs;
	private BatDongSan batDongSan;
	private GiaTriDoanhNghiep giaTriDoanhNghiep;
	private LoaiTaiSan loaiTaiSan;
	private MayMocThietBi mayMocThietBi;
	private PhuongPhap phuongPhap;
	private String tenTs;
	private Double giaTriTd;
	private Date thoiGianTd;
	private int idNth;
	private int idHd;
	private String ghiChu;
	private ChiTietHopDong chiTietHopDong = new ChiTietHopDong();

	public TaiSan() {
	}

	public TaiSan(LoaiTaiSan loaiTaiSan, PhuongPhap phuongPhap, String tenTs, int idNth, int idHd) {
		this.loaiTaiSan = loaiTaiSan;
		this.phuongPhap = phuongPhap;
		this.tenTs = tenTs;
		this.idNth = idNth;
		this.idHd = idHd;
	}

	public TaiSan(BatDongSan batDongSan, GiaTriDoanhNghiep giaTriDoanhNghiep, LoaiTaiSan loaiTaiSan,
			MayMocThietBi mayMocThietBi, PhuongPhap phuongPhap, String tenTs, Double giaTriTd, Date thoiGianTd,
			int idNth, int idHd, String ghiChu, ChiTietHopDong chiTietHopDong) {
		this.batDongSan = batDongSan;
		this.giaTriDoanhNghiep = giaTriDoanhNghiep;
		this.loaiTaiSan = loaiTaiSan;
		this.mayMocThietBi = mayMocThietBi;
		this.phuongPhap = phuongPhap;
		this.tenTs = tenTs;
		this.giaTriTd = giaTriTd;
		this.thoiGianTd = thoiGianTd;
		this.idNth = idNth;
		this.idHd = idHd;
		this.ghiChu = ghiChu;
		this.chiTietHopDong = chiTietHopDong;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_TS", unique = true, nullable = false)
	public Integer getIdTs() {
		return this.idTs;
	}

	public void setIdTs(Integer idTs) {
		this.idTs = idTs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BDS")
	public BatDongSan getBatDongSan() {
		return this.batDongSan;
	}

	public void setBatDongSan(BatDongSan batDongSan) {
		this.batDongSan = batDongSan;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DN")
	public GiaTriDoanhNghiep getGiaTriDoanhNghiep() {
		return this.giaTriDoanhNghiep;
	}

	public void setGiaTriDoanhNghiep(GiaTriDoanhNghiep giaTriDoanhNghiep) {
		this.giaTriDoanhNghiep = giaTriDoanhNghiep;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LOAI_TS", nullable = false)
	public LoaiTaiSan getLoaiTaiSan() {
		return this.loaiTaiSan;
	}

	public void setLoaiTaiSan(LoaiTaiSan loaiTaiSan) {
		this.loaiTaiSan = loaiTaiSan;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MMTB")
	public MayMocThietBi getMayMocThietBi() {
		return this.mayMocThietBi;
	}

	public void setMayMocThietBi(MayMocThietBi mayMocThietBi) {
		this.mayMocThietBi = mayMocThietBi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PP_TD", nullable = false)
	public PhuongPhap getPhuongPhap() {
		return this.phuongPhap;
	}

	public void setPhuongPhap(PhuongPhap phuongPhap) {
		this.phuongPhap = phuongPhap;
	}

	@Column(name = "TEN_TS", nullable = false, length = 100)
	public String getTenTs() {
		return this.tenTs;
	}

	public void setTenTs(String tenTs) {
		this.tenTs = tenTs;
	}

	@Column(name = "GIA_TRI_TD", precision = 22, scale = 0)
	public Double getGiaTriTd() {
		return this.giaTriTd;
	}

	public void setGiaTriTd(Double giaTriTd) {
		this.giaTriTd = giaTriTd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "THOI_GIAN_TD", length = 19)
	public Date getThoiGianTd() {
		return this.thoiGianTd;
	}

	public void setThoiGianTd(Date thoiGianTd) {
		this.thoiGianTd = thoiGianTd;
	}

	@Column(name = "ID_NTH", nullable = false)
	public int getIdNth() {
		return this.idNth;
	}

	public void setIdNth(int idNth) {
		this.idNth = idNth;
	}

	@Column(name = "ID_HD", nullable = false)
	public int getIdHd() {
		return this.idHd;
	}

	public void setIdHd(int idHd) {
		this.idHd = idHd;
	}

	@Column(name = "GHI_CHU", length = 16777215)
	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "taiSan")
	public ChiTietHopDong getChiTietHopDong() {
		return this.chiTietHopDong;
	}

	public void setChiTietHopDong(ChiTietHopDong chiTietHopDong) {
		this.chiTietHopDong = chiTietHopDong;
	}

}