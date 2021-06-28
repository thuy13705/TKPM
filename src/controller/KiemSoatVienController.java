package controller;

import model.pojo.NguoiDung;
import ui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiemSoatVienController {
    private NguoiDung nguoiDung;
    private KiemSoatVien kiemSoatVienView;
    public KiemSoatVienController(KiemSoatVien KiemSoatVienView,NguoiDung nguoiDung){
        this.kiemSoatVienView=KiemSoatVienView;
        this.nguoiDung=nguoiDung;
        kiemSoatVienView.getTTCN(new TTCNListener());
        kiemSoatVienView.qLDuyetSo(new QLDSListener());
        kiemSoatVienView.qLPhongToa(new QLPTListener());
        kiemSoatVienView.bangLaiSuatListener(new LSListener());
        kiemSoatVienView.logoutListener(new LogoutListener());
    }

    public void showKiemSoatVienView(){
        kiemSoatVienView.setVisible(true);
    }

    class TTCNListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ThongTinCaNhan thongTinCaNhan=new ThongTinCaNhan(kiemSoatVienView);
            TTCNController ttcnController=new TTCNController(nguoiDung,thongTinCaNhan,kiemSoatVienView);
            kiemSoatVienView.showPanel(thongTinCaNhan);
        }
    }

    class QLDSListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DanhSachChoDuyet danhSachChoDuyet = new DanhSachChoDuyet(kiemSoatVienView);
            DuyetSoController duyetSoController = new DuyetSoController(danhSachChoDuyet);
            kiemSoatVienView.showPanel(danhSachChoDuyet);
        }
    }

    class QLPTListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            PhongToaSo phongToaSo = new PhongToaSo(kiemSoatVienView);
            PhongToaController phongToaController = new PhongToaController(phongToaSo);
            kiemSoatVienView.showPanel(phongToaSo);
        }
    }

    class LSListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BangLaiSuat bangLaiSuat=new BangLaiSuat();
            BangLaiSuatController bangLaiSuatController=new BangLaiSuatController(bangLaiSuat);
            kiemSoatVienView.showPanel(bangLaiSuat);
        }
    }

    class LogoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int kq=kiemSoatVienView.logout();
            if (kq==0){
                kiemSoatVienView.setVisible(false);
                Login login=new Login();
                LoginController loginController=new LoginController(login);
                loginController.showLoginView();
            }
        }
    }
}
