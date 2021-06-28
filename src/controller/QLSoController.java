package controller;

import model.dao.LoaiSTKDAO;
import model.dao.PhieuGiaoDichDAO;
import model.dao.SoTietKiemDAO;
import model.pojo.NguoiDung;
import model.pojo.PhieuGiaoDich;
import model.pojo.SoTietKiem;
import ui.KhachHang;
import ui.PhieuGui;
import ui.PhieuRut;
import ui.QuanLySoTietKiem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class QLSoController {
    PhieuGui phieuGuiView;
    List<SoTietKiem> list = null;
    private NguoiDung nguoiDung;
    private KhachHang khachHangView;
    private QuanLySoTietKiem quanLySoTietKiemView;

    public QLSoController(NguoiDung nguoiDung, QuanLySoTietKiem quanLySoTietKiemView) {
        this.nguoiDung = nguoiDung;
        this.quanLySoTietKiemView = quanLySoTietKiemView;
        quanLySoTietKiemView.getPhieuGuiListener(new QLSoController.PhieuGuiListener());
        quanLySoTietKiemView.getPhieuRutListener(new QLSoController.PhieuRutListener());
        quanLySoTietKiemView.getTTSoListener(new QLSoController.TTSoListener());
        quanLySoTietKiemView.getTimKiemListener(new QLSoController.TimKiemListener());
        quanLySoTietKiemView.showNguoiDung(nguoiDung);
        List<SoTietKiem> list =SoTietKiemDAO.layDSSTKHD(nguoiDung);
        quanLySoTietKiemView.showDS(list);

    }

    class TTSoListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            SoTietKiem soTietKiem = quanLySoTietKiemView.getSelectedRow();
            quanLySoTietKiemView.showTTSo(soTietKiem, TTDenHan(soTietKiem));
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    class TimKiemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String ma = quanLySoTietKiemView.layMaTimKiem();
            if (!ma.equals("")) {
                int maSo = Integer.parseInt(ma);
                SoTietKiem soTietKiem = SoTietKiemDAO.laySTKID(maSo);
                if (soTietKiem != null) {
                    if (soTietKiem.getTinhTrang() == 2)
                        if (soTietKiem.getMaND().equals(nguoiDung)) {
                            quanLySoTietKiemView.showTTSo(soTietKiem, TTDenHan(soTietKiem));
                        } else {
                            quanLySoTietKiemView.showMessage("Không tìm thấy sổ");
                        }
                    else {
                        quanLySoTietKiemView.showMessage("Không tìm thấy sổ");
                    }

                } else {
                    quanLySoTietKiemView.showMessage("Không tìm thấy sổ");
                }
            } else {
                quanLySoTietKiemView.showMessage("Chưa nhập mã để tìm kiếm");
            }
        }

    }

    class PhieuGuiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PhieuGui phieuGui = new PhieuGui(khachHangView);
            PhieuGuiController phieuGuiController = new PhieuGuiController(nguoiDung, phieuGui,quanLySoTietKiemView);
            phieuGui.setVisible(true);
        }
    }

    class PhieuRutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SoTietKiem soTietKiem = quanLySoTietKiemView.getSelectedRow();
            PhieuRut phieuRut = new PhieuRut(khachHangView);
            PhieuRutController phieuDongController = new PhieuRutController(nguoiDung, soTietKiem, phieuRut,quanLySoTietKiemView);
            phieuRut.setVisible(true);

        }


    }

    public BigDecimal tinhLaiSuat(SoTietKiem soTietKiem, int soNgayGui) {
        BigDecimal soTienLai = (soTietKiem.getSoTienGui().multiply(BigDecimal.valueOf(soTietKiem.getLoaiSo().getLaiSuat())));
        soTienLai = soTienLai.multiply(BigDecimal.valueOf(soNgayGui));
        soTienLai = soTienLai.divide(BigDecimal.valueOf(36000), 0, RoundingMode.HALF_DOWN);
        return soTienLai;
    }

    public int khoangCach2Ngay(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        return (int) ((c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000));

    }

    public List<String> TTDenHan(SoTietKiem soTietKiem) {
        List<String> list = new ArrayList<>();
        int khoangCach2Ngay = khoangCach2Ngay(soTietKiem.getNgayMoSo(), soTietKiem.getNgayDenHan());
        System.out.println(khoangCach2Ngay);
        BigDecimal tienLai = tinhLaiSuat(soTietKiem, khoangCach2Ngay);
        BigDecimal tongTien = tienLai.add(soTietKiem.getSoTienGui());
        list.add(String.valueOf(tienLai));
        list.add(String.valueOf(tongTien));
        return list;
    }
}







