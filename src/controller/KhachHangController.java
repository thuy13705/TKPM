package controller;

import model.dao.PhieuGiaoDichDAO;
import model.dao.SoTietKiemDAO;
import model.pojo.NguoiDung;
import model.pojo.PhieuGiaoDich;
import model.pojo.SoTietKiem;
import ui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class KhachHangController {
    private NguoiDung nguoiDung;
    private KhachHang khachHangView;
    public KhachHangController(KhachHang KhachHangView,NguoiDung nguoiDung){
        this.khachHangView=KhachHangView;
        this.nguoiDung=nguoiDung;
        khachHangView.getTTCNListener(new TTCNListener());
        khachHangView.getQLSoListener(new QLSoListener());
        khachHangView.getQLSoDaTTListener(new QLSoDaTTListener());
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


}
