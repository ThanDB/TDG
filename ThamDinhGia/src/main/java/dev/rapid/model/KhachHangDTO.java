package dev.rapid.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Rapid
 *
 */
public class KhachHangDTO {

    private final StringProperty tenKhachHang;
    private final StringProperty diaChi;
    private final StringProperty dienThoai;
    private final SimpleStringProperty fax;
    private final StringProperty daiDien;
    private final StringProperty maSoThue;

    /**
     * Default constructor.
     */
    public KhachHangDTO() {
        this(null, null, null, null, null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param firstName
     * @param lastName
     */
    public KhachHangDTO(String tenKhachHang, String diaChi, String dienThoai, String fax, String daiDien, String maSoThue) {
        this.tenKhachHang = new SimpleStringProperty(tenKhachHang);
        this.diaChi = new SimpleStringProperty(diaChi);
        this.dienThoai = new SimpleStringProperty(dienThoai);
        this.fax = new SimpleStringProperty(fax);
        this.daiDien = new SimpleStringProperty(daiDien);
        this.maSoThue = new SimpleStringProperty(maSoThue);
    }

    public StringProperty tenKhachHangProperty() {
        return tenKhachHang;
    }

    public StringProperty diaChiProperty() {
        return diaChi;
    }

    public StringProperty dienThoaiProperty() {
        return dienThoai;
    }

    public StringProperty faxProperty() {
        return fax;
    }

    public StringProperty daiDienProperty() {
        return daiDien;
    }

    public StringProperty maSoThueProperty() {
        return maSoThue;
    }

    public String getTenKhachHang() {
        return tenKhachHang.get();
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang.set(tenKhachHang);
    }

    public String getDiaChi() {
        return diaChi.get();
    }

    public void setDiaChi(String diaChi) {
        this.diaChi.set(diaChi);
    }

    public String getDienThoai() {
        return dienThoai.get();
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai.set(dienThoai);
    }

    public String getFax() {
        return fax.get();
    }

    public void setFax(String fax) {
        this.fax.set(fax);
    }

    public String getDaiDien() {
        return daiDien.get();
    }

    public void setDaiDien(String daiDien) {
        this.daiDien.set(daiDien);
    }

    public String getMaSoThue() {
        return maSoThue.get();
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue.set(maSoThue);
    }
}