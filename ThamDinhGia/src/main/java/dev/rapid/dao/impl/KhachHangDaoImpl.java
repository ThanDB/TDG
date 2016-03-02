package dev.rapid.dao.impl;

import dev.rapid.domain.KhachHang;

public class KhachHangDaoImpl extends BaseDaoImpl<KhachHang> {

	public KhachHangDaoImpl() {
		super(KhachHang.class);
	}

	public static void main(String[] args) {
		KhachHang kh = new KhachHang();
		kh.setTenKh("Hoàng Nam Tiến");
		kh.setDaiDien("Trương Gia Bình");
		kh.setDiaChi("ABCD-EFGH");
		kh.setSdt("0123456568");
		kh.setFax("1594757953");
		kh.setHopDongs(null);
		kh.setMaSoThue("123415435");

		KhachHangDaoImpl cusDao = new KhachHangDaoImpl();
		cusDao.saveOrUpdate(kh);
	}
}
