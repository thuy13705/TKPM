package model.pojo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class PhieuGiaoDich {
    private int maPhieu;
    private Date ngayGiaoDich;
    private BigDecimal soTien;
    private int loaiPhieu;
    private NguoiDung nguoiGiaoDich;
    private NguoiDung maND;
    private SoTietKiem maSo;

    public SoTietKiem getMaSo() {
        return maSo;
    }

    public void setMaSo(SoTietKiem maSo) {
        this.maSo = maSo;
    }

    public NguoiDung getMaND() {
        return maND;
    }

    public void setMaND(NguoiDung maND) {
        this.maND = maND;
    }

    public NguoiDung getNguoiGiaoDich() {
        return nguoiGiaoDich;
    }

    public void setNguoiGiaoDich(NguoiDung nguoiGiaoDich) {
        this.nguoiGiaoDich = nguoiGiaoDich;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public BigDecimal getSoTien() {
        return soTien;
    }

    public void setSoTien(BigDecimal soTien) {
        this.soTien = soTien;
    }

    public int getLoaiPhieu() {
        return loaiPhieu;
    }

    public void setLoaiPhieu(int loaiPhieu) {
        this.loaiPhieu = loaiPhieu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhieuGiaoDich that = (PhieuGiaoDich) o;
        return maPhieu == that.maPhieu && loaiPhieu == that.loaiPhieu && Objects.equals(ngayGiaoDich, that.ngayGiaoDich) && Objects.equals(soTien, that.soTien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhieu, ngayGiaoDich, soTien, loaiPhieu);
    }
}
