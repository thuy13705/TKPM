package model.pojo;

import java.util.Objects;

public class BangThamSo {
    private int maThamSo;
    private String tenThamSo;
    private String kieu;
    private String giaTri;
    private byte tinhTrang;

    public int getMaThamSo() {
        return maThamSo;
    }

    public void setMaThamSo(int maThamSo) {
        this.maThamSo = maThamSo;
    }

    public String getTenThamSo() {
        return tenThamSo;
    }

    public void setTenThamSo(String tenThamSo) {
        this.tenThamSo = tenThamSo;
    }

    public String getKieu() {
        return kieu;
    }

    public void setKieu(String kieu) {
        this.kieu = kieu;
    }

    public String getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(String giaTri) {
        this.giaTri = giaTri;
    }

    public byte getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(byte tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BangThamSo that = (BangThamSo) o;
        return maThamSo == that.maThamSo && tinhTrang == that.tinhTrang && Objects.equals(tenThamSo, that.tenThamSo) && Objects.equals(kieu, that.kieu) && Objects.equals(giaTri, that.giaTri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maThamSo, tenThamSo, kieu, giaTri, tinhTrang);
    }
}
