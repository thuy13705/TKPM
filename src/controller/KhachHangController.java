package controller;

import model.pojo.NguoiDung;
import ui.BangLaiSuat;
import ui.KhachHang;
import ui.ThongTinCaNhan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KhachHangController {
    private NguoiDung nguoiDung;
    private KhachHang khachHangView;
    public KhachHangController(KhachHang KhachHangView,NguoiDung nguoiDung){
        this.khachHangView=KhachHangView;
        this.nguoiDung=nguoiDung;
        khachHangView.getTTCNListener(new TTCNListener());
        khachHangView.qlSoListener(new QLSoListener());
        khachHangView.bangLaiSuatListener(new LSListener());
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

        }
    }
    class LSListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BangLaiSuat bangLaiSuat=new BangLaiSuat();
            BangLaiSuatController bangLaiSuatController=new BangLaiSuatController(bangLaiSuat);
        }
    }
}
