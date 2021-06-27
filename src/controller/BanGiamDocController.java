package controller;

import model.pojo.NguoiDung;
import ui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BanGiamDocController {
    private NguoiDung nguoiDung;
    private BanGiamDoc banGiamDocView;
    public BanGiamDocController(BanGiamDoc banGiamDocView,NguoiDung nguoiDung){
        this.banGiamDocView=banGiamDocView;
        this.nguoiDung=nguoiDung;
        banGiamDocView.getTTCNListener(new TTCNListener());
        banGiamDocView.baoCaoListener(new BaoCaoListener());
        banGiamDocView.bangLaiSuatListener(new LSListener());
        banGiamDocView.logoutListener(new LogoutListener());
    }

    public void showBanGiamDoc(){
        banGiamDocView.setVisible(true);
    }

    class TTCNListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ThongTinCaNhan thongTinCaNhan=new ThongTinCaNhan(banGiamDocView);
            TTCNController ttcnController=new TTCNController(nguoiDung,thongTinCaNhan,banGiamDocView);
            banGiamDocView.showPanel(thongTinCaNhan);
        }
    }

    class BaoCaoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            BaoCao baoCao=new BaoCao();
            BaoCaoController baoCaoController=new BaoCaoController(baoCao);
            banGiamDocView.showPanel(baoCao);

        }
    }
    class LSListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            QuyDinhLaiSuat quyDinhLaiSuat=new QuyDinhLaiSuat();
            QDLSController qdlsController=new QDLSController(quyDinhLaiSuat);
            banGiamDocView.showPanel(quyDinhLaiSuat);
        }
    }

    class LogoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int kq=banGiamDocView.logout();
            if (kq==0){
                banGiamDocView.setVisible(false);
                Login login=new Login();
                LoginController loginController=new LoginController(login);
                loginController.showLoginView();
            }
        }
    }
}
