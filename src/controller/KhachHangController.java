package controller;

import model.pojo.NguoiDung;
import ui.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class KhachHangController {
    private NguoiDung nguoiDung;
    private KhachHang khachHangView;
    public KhachHangController(KhachHang KhachHangView,NguoiDung nguoiDung){
        this.khachHangView=KhachHangView;
        this.nguoiDung=nguoiDung;
        khachHangView.getTTCNListener(new TTCNListener());
        khachHangView.getQLSoListener(new QLSoListener());
        khachHangView.getQLSoDaTTListener(new QLSoDaTTListener());
        khachHangView.bangLaiSuatListener(new LSListener());
        khachHangView.logoutListener(new LogoutListener());
    }

    public void showKhachHangView(){
        khachHangView.setVisible(true);
    }

    class TTCNListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ThongTinCaNhan thongTinCaNhan=new ThongTinCaNhan(khachHangView);
            TTCNController ttcnController=new TTCNController(nguoiDung,thongTinCaNhan,khachHangView);
            khachHangView.showPanel(thongTinCaNhan);
        }
    }

    class QLSoListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            QuanLySoTietKiem quanLySoTietKiem = new QuanLySoTietKiem(nguoiDung, khachHangView);
            QLSoController qlSoController = new QLSoController(nguoiDung,quanLySoTietKiem);
            khachHangView.showPanel(quanLySoTietKiem);
        }
    }

    class QLSoDaTTListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DanhSachSoDaTT quanLySoTietKiem = new DanhSachSoDaTT(nguoiDung, khachHangView);
            QLSoDaTTController qlSoDaTTController = new QLSoDaTTController(nguoiDung,quanLySoTietKiem);
            khachHangView.showPanel(quanLySoTietKiem);
        }
    }

    class LSListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BangLaiSuat bangLaiSuat=new BangLaiSuat();
            BangLaiSuatController bangLaiSuatController=new BangLaiSuatController(bangLaiSuat);
            khachHangView.showPanel(bangLaiSuat);
        }
    }

    class LogoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int kq=khachHangView.logout();
            if (kq==0){
                khachHangView.setVisible(false);
                Login login=new Login();
                LoginController loginController=new LoginController(login);
                loginController.showLoginView();
            }
        }
    }
}
