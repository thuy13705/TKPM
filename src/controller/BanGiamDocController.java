package controller;

import model.pojo.NguoiDung;
import ui.BanGiamDoc;
import ui.ThongTinCaNhan;

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

        }
    }
}
