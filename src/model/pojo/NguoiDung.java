package model.pojo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NguoiDung {
    private int maNd;
    private String tenNd;
    private String diaChi;
    private String cmnd;
    private String sdt;
    private String username;
    private String password;
    private int loaiNd;
    private String email;
    private Integer tinhTrang;
    private BigDecimal soDu;
    private Set<SoTietKiem> soTKs=new HashSet<>(0);
    private Set<PhieuGiaoDich> nguoiGDs;


    public Set<PhieuGiaoDich> getNguoiGDs() {
        return nguoiGDs;
    }

    public void setNguoiGDs(Set<PhieuGiaoDich> nguoiGDs) {
        this.nguoiGDs = nguoiGDs;
    }

    public Set<SoTietKiem> getSoTKs() {
        return soTKs;
    }

    public void setSoTKs(Set<SoTietKiem> soTKs) {
        this.soTKs = soTKs;
    }


    public BigDecimal getSoDu() {
        return soDu;
    }

    public void setSoDu(BigDecimal soDu) {
        this.soDu = soDu;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMaNd() {
        return maNd;
    }

    public void setMaNd(int maNd) {
        this.maNd = maNd;
    }

    public String getTenNd() {
        return tenNd;
    }

    public void setTenNd(String tenNd) {
        this.tenNd = tenNd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoaiNd() {
        return loaiNd;
    }

    public void setLoaiNd(int loaiNd) {
        this.loaiNd = loaiNd;
    }

    public NguoiDung() {
    }

    public NguoiDung(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public NguoiDung(String tenNd, String diaChi, String cmnd, String sdt,String email, String username, String password, int loaiNd,  BigDecimal soDu) {
        this.tenNd = tenNd;
        this.diaChi = diaChi;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.username = username;
        this.password = password;
        this.loaiNd = loaiNd;
        this.email = email;
        this.soDu = soDu;
        this.tinhTrang=0;
    }

    public NguoiDung(String tenNd, String diaChi,String email, String cmnd, String sdt) {
        this.tenNd = tenNd;
        this.diaChi = diaChi;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NguoiDung nguoiDung = (NguoiDung) o;
        return maNd == nguoiDung.maNd && loaiNd == nguoiDung.loaiNd && Objects.equals(tenNd, nguoiDung.tenNd) && Objects.equals(diaChi, nguoiDung.diaChi) && Objects.equals(cmnd, nguoiDung.cmnd) && Objects.equals(sdt, nguoiDung.sdt) && Objects.equals(username, nguoiDung.username) && Objects.equals(password, nguoiDung.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNd, tenNd, diaChi, cmnd, sdt, username, password, loaiNd);
    }
}
