package controller;

import model.pojo.NguoiDung;
import ui.KhachHang;
import ui.QuanLySoTietKiem;
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
        khachHangView.getQLSoListener(new QLSoListener());
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
}
