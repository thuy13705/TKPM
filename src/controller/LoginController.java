package controller;

import model.dao.NguoiDungDAO;
import model.pojo.NguoiDung;
import org.mindrot.jbcrypt.BCrypt;
import ui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private NguoiDung nguoiDung;
    private Login loginView;
    private Admin adminView;
    private BanGiamDoc banGiamDocView;
    private KhachHang khachHangView;
    private KiemToanTietKiem kiemToanTietKiemView;
    private KiemSoatVien kiemSoatVienVien;

    public LoginController(Login loginView){
        this.loginView=loginView;
        loginView.addLoginListener((ActionListener) new LoginListener());
    }

    public void showLoginView(){
        loginView.setVisible(true);
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            NguoiDung nguoiDungLogin=loginView.getND();
            NguoiDung nguoiDung= NguoiDungDAO.layNguoiDungUser(nguoiDungLogin.getUsername());
            if (nguoiDung!=null){
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
                            kiemToanTietKiemView=new KiemToanTietKiem();
                            KiemToanTietKiemController KiemToanTietKiemController=new KiemToanTietKiemController(kiemToanTietKiemView,nguoiDung);
                            KiemToanTietKiemController.showKiemToanTietKiemView();
                            loginView.setVisible(false);
                            break;
                        case 3:
                            kiemSoatVienVien=new KiemSoatVien();
                            KiemSoatVienController KiemSoatVienController=new KiemSoatVienController(kiemSoatVienVien,nguoiDung);
                            KiemSoatVienController.showKiemSoatVienView();
                            loginView.setVisible(false);
                            break;
                        case 4:
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
                loginView.showMessage("Username không tồn tại.");
        }
    }
}
