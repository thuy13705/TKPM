package controller;

import model.dao.NguoiDungDAO;
import model.dao.PhieuGiaoDichDAO;
import model.dao.SoTietKiemDAO;
import model.pojo.NguoiDung;
import model.pojo.PhieuGiaoDich;
import model.pojo.SoTietKiem;
import org.mindrot.jbcrypt.BCrypt;
import ui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LoginController {
    private NguoiDung nguoiDung;
    private Login loginView;
    private Admin adminView;
    private BanGiamDoc banGiamDocView;
    private KhachHang khachHangView;
    private KiemSoatVien kiemSoatVienVien;

    public LoginController(Login loginView){
        this.loginView=loginView;
        loginView.addLoginListener((ActionListener) new LoginListener());
    }

    public void showLoginView(){
        capNhatSo();
        loginView.setVisible(true);
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            NguoiDung nguoiDungLogin=loginView.getND();
            NguoiDung nguoiDung= NguoiDungDAO.layNguoiDungUser(nguoiDungLogin.getUsername());
            if (nguoiDung!=null){
              if (nguoiDung.getTinhTrang()==0){
                  if (BCrypt.checkpw(nguoiDungLogin.getPassword(),nguoiDung.getPassword()))
                  {
                      int loaiND=nguoiDung.getLoaiNd();
                      switch (loaiND){
                          case 0:
                              adminView=new Admin();
                              AdminController adminController=new AdminController(adminView,nguoiDung);
                              adminController.showAdminView();
                              loginView.setVisible(false);
                              break;
                          case 1:
                              banGiamDocView=new BanGiamDoc();
                              BanGiamDocController banGiamDocController=new BanGiamDocController(banGiamDocView,nguoiDung);
                              banGiamDocController.showBanGiamDoc();
                              loginView.setVisible(false);
                              break;
                          case 2:
                              kiemSoatVienVien=new KiemSoatVien();
                              KiemSoatVienController KiemSoatVienController=new KiemSoatVienController(kiemSoatVienVien,nguoiDung);
                              KiemSoatVienController.showKiemSoatVienView();
                              loginView.setVisible(false);
                              break;
                          case 3:
                              khachHangView=new KhachHang();
                              KhachHangController KhachHangController=new KhachHangController(khachHangView,nguoiDung);
                              KhachHangController.showKhachHangView();
                              loginView.setVisible(false);
                              break;
                          default:
                              break;
                      }
                  }
                  else loginView.showMessage("Mật khẩu không chính xác!!!");
              }
              else
                  loginView.showMessage("Tài khoản đã bị khoá.");
            }
            else
                loginView.showMessage("Username không tồn tại.");
        }
    }

    public BigDecimal tinhLaiSuat(SoTietKiem soTietKiem, int soNgayGui) {
        BigDecimal soTienLai = (soTietKiem.getSoTienGui().multiply(BigDecimal.valueOf(soTietKiem.getLoaiSo().getLaiSuat())));
        soTienLai = soTienLai.multiply(BigDecimal.valueOf(soNgayGui));
        soTienLai = soTienLai.divide(BigDecimal.valueOf(36000), 0, RoundingMode.HALF_DOWN);
        return soTienLai;
    }

    public int khoangCach2Ngay(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        return (int) ((c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000));

    }

    public boolean tatToanToiHan(SoTietKiem soTietKiem){
        Date ngayHT = java.util.Calendar.getInstance().getTime();
        Date ngayDenHan = soTietKiem.getNgayDenHan();

        System.out.println(ngayHT);
        System.out.println(ngayDenHan);
        System.out.println(ngayHT.compareTo(ngayDenHan));
        if (ngayHT.compareTo(ngayDenHan) >= 0){

            PhieuGiaoDich phieuRut = new PhieuGiaoDich(ngayHT, tinhLaiSuat(soTietKiem, khoangCach2Ngay(soTietKiem.getNgayMoSo(), soTietKiem.getNgayDenHan())),
                    1, soTietKiem, soTietKiem.getMaND());
            return PhieuGiaoDichDAO.themPhieu(phieuRut);
        }
        return false;
    }

    public void capNhatSo(){
        List<SoTietKiem> list = SoTietKiemDAO.layDSSTK();
        System.out.println(list.size());
        for(SoTietKiem soTietKiem: list){
            if(soTietKiem.getTinhTrang() == 1) {
                if (soTietKiem.getPhieuGDs().size() == 1) {
                    boolean kq = tatToanToiHan(soTietKiem);
                    if (kq == true) {
                        System.out.println("So den han, da tat toan");
                    }
                }
            }
        }
    }
}
