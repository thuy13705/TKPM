package controller;

import model.pojo.NguoiDung;
import ui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController {
    private NguoiDung nguoiDung;
    private Admin adminView;
    public AdminController(Admin adminView,NguoiDung nguoiDung){
        this.adminView=adminView;
        this.nguoiDung=nguoiDung;
        adminView.getTTCNListener(new TTCNListener());
        adminView.qlngListener(new QLNDListener());
        adminView.bangLSListener(new LSListener());
        adminView.logoutListener(new LogoutListener());
    }

    public void showAdminView(){
        adminView.setVisible(true);
    }

    class TTCNListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ThongTinCaNhan thongTinCaNhan=new ThongTinCaNhan(adminView);
            TTCNController ttcnController=new TTCNController(nguoiDung,thongTinCaNhan,adminView);
            adminView.showPanel(thongTinCaNhan);
        }
    }

    class QLNDListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            QuanLyDSNguoiDung quanLyDSNguoiDung=new QuanLyDSNguoiDung(adminView);
            QLNDController qlndController=new QLNDController(nguoiDung,quanLyDSNguoiDung);
            adminView.showPanel(quanLyDSNguoiDung);
        }
    }
    class LSListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BangLaiSuat bangLaiSuat=new BangLaiSuat();
            BangLaiSuatController bangLaiSuatController=new BangLaiSuatController(bangLaiSuat);
            adminView.showPanel(bangLaiSuat);
        }
    }

    class LogoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int kq=adminView.logout();
            if (kq==0){
                adminView.setVisible(false);
                Login login=new Login();
                LoginController loginController=new LoginController(login);
                loginController.showLoginView();
            }
        }
    }
}