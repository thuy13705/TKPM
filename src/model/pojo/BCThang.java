package model.pojo;

import java.math.BigDecimal;

public class BCThang {
    private String tenLoai;
    private BigDecimal tongThu;
    private BigDecimal tongChi;
    private long soMo;
    private long soDong;

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public BigDecimal getTongThu() {
        return tongThu;
    }

    public void setTongThu(BigDecimal tongThu) {
        this.tongThu = tongThu;
    }

    public BigDecimal getTongChi() {
        return tongChi;
    }

    public void setTongChi(BigDecimal tongChi) {
        this.tongChi = tongChi;
    }

    public long getSoMo() {
        return soMo;
    }

    public void setSoMo(int soMo) {
        this.soMo = soMo;
    }

    public long getSoDong() {
        return soDong;
    }

    public void setSoDong(int soDong) {
        this.soDong = soDong;
    }

    public BCThang(String tenLoai, BigDecimal tongThu, BigDecimal tongChi, long soMo, long soDong) {
        this.tenLoai = tenLoai;
        this.tongThu = tongThu;
        this.tongChi = tongChi;
        this.soMo = soMo;
        this.soDong = soDong;
    }

    public BCThang() {
    }
}
