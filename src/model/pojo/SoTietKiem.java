package model.pojo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class SoTietKiem {
    private int maSo;
    private Date ngayMoSo;
    private BigDecimal soTienGui;
    private LoaiSTK loaiSo;
    private NguoiDung maND;

    public NguoiDung getMaND() {
        return maND;
    }

    public void setMaND(NguoiDung maND) {
        this.maND = maND;
    }

    public LoaiSTK getLoaiSo() {
        return loaiSo;
    }

    public void setLoaiSo(LoaiSTK loaiSo) {
        this.loaiSo = loaiSo;
    }


    public int getMaSo() {
        return maSo;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    public Date getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo(Date ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    public BigDecimal getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(BigDecimal soTienGui) {
        this.soTienGui = soTienGui;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoTietKiem that = (SoTietKiem) o;
        return maSo == that.maSo && Objects.equals(ngayMoSo, that.ngayMoSo) && Objects.equals(soTienGui, that.soTienGui);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSo, ngayMoSo, soTienGui);
    }
}
