package model.pojo;

import java.util.Objects;

public class LoaiSTK {
    private int loaiSo;
    private String tenLoai;
    private double laiSuat;
    private Integer tinhTrang;

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public LoaiSTK(int loaiSo, String tenLoai, double laiSuat, Integer tinhTrang) {
        this.loaiSo = loaiSo;
        this.tenLoai = tenLoai;
        this.laiSuat = laiSuat;
        this.tinhTrang = tinhTrang;
    }

    public LoaiSTK() {

    }

    public int getLoaiSo() {
        return loaiSo;
    }

    public void setLoaiSo(int loaiSo) {
        this.loaiSo = loaiSo;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoaiSTK loaiSTK = (LoaiSTK) o;
        return loaiSo == loaiSTK.loaiSo && Double.compare(loaiSTK.laiSuat, laiSuat) == 0 && Objects.equals(tenLoai, loaiSTK.tenLoai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loaiSo, tenLoai, laiSuat);
    }
}
