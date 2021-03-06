package dev.rapid.domain;
// Generated Jan 24, 2016 10:48:55 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * LoaiTaiSan generated by hbm2java
 */
@Entity
@Table(name = "loai_tai_san", catalog = "thamdinhgia_db")
public class LoaiTaiSan implements java.io.Serializable {

	private Integer idLoaiTs;
	private String tenLoaiTs;
	private Set<TaiSan> taiSans = new HashSet<TaiSan>(0);

	public LoaiTaiSan() {
	}

	public LoaiTaiSan(String tenLoaiTs, Set<TaiSan> taiSans) {
		this.tenLoaiTs = tenLoaiTs;
		this.taiSans = taiSans;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_LOAI_TS", unique = true, nullable = false)
	public Integer getIdLoaiTs() {
		return this.idLoaiTs;
	}

	public void setIdLoaiTs(Integer idLoaiTs) {
		this.idLoaiTs = idLoaiTs;
	}

	@Column(name = "TEN_LOAI_TS", length = 100)
	public String getTenLoaiTs() {
		return this.tenLoaiTs;
	}

	public void setTenLoaiTs(String tenLoaiTs) {
		this.tenLoaiTs = tenLoaiTs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiTaiSan")
	public Set<TaiSan> getTaiSans() {
		return this.taiSans;
	}

	public void setTaiSans(Set<TaiSan> taiSans) {
		this.taiSans = taiSans;
	}

}
