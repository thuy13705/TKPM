package controller;

import model.pojo.NguoiDung;
import ui.KiemSoatVien;
import ui.ThongTinCaNhan;

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
}
