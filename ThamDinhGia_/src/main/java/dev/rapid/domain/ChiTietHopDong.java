package dev.rapid.domain;
// Generated Jan 24, 2016 10:48:55 PM by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * ChiTietHopDong generated by hbm2java
 */
@Entity
@Table(name = "chi_tiet_hop_dong", catalog = "thamdinhgia_db")
public class ChiTietHopDong implements java.io.Serializable {

	private ChiTietHopDongId id;
	private HopDong hopDong;
	private TaiSan taiSan;
	private int soLuong;

	public ChiTietHopDong() {
	}

	public ChiTietHopDong(ChiTietHopDongId id, HopDong hopDong, TaiSan taiSan, int soLuong) {
		this.id = id;
		this.hopDong = hopDong;
		this.taiSan = taiSan;
		this.soLuong = soLuong;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idTs", column = @Column(name = "ID_TS", nullable = false) ),
			@AttributeOverride(name = "idHd", column = @Column(name = "ID_HD", nullable = false) ) })
	public ChiTietHopDongId getId() {
		return this.id;
	}

	public void setId(ChiTietHopDongId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_HD", nullable = false, insertable = false, updatable = false)
	public HopDong getHopDong() {
		return this.hopDong;
	}

	public void setHopDong(HopDong hopDong) {
		this.hopDong = hopDong;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TS", nullable = false, insertable = false, updatable = false)
	public TaiSan getTaiSan() {
		return this.taiSan;
	}

	public void setTaiSan(TaiSan taiSan) {
		this.taiSan = taiSan;
	}

	@Column(name = "SO_LUONG", nullable = false)
	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
