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

        }
    }

    class QLPTListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class LSListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            QuyDinhLaiSuat quyDinhLaiSuat=new QuyDinhLaiSuat();
            QDLSController qdlsController=new QDLSController(quyDinhLaiSuat);
            kiemSoatVienView.showPanel(quyDinhLaiSuat);
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
