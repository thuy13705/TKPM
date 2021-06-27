package model.pojo;

import java.math.BigDecimal;

public class BCNgay {
    private String tenLoai;
    private BigDecimal tongThu;
    private BigDecimal tongChi;

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

    public BCNgay() {
    }

    public BCNgay(String tenLoai, BigDecimal tongThu, BigDecimal tongChi) {
        this.tenLoai = tenLoai;
        this.tongThu = tongThu;
        this.tongChi = tongChi;
    }
}
