package controller;

import model.dao.LoaiSTKDAO;
import model.dao.SoTietKiemDAO;
import model.pojo.NguoiDung;
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
        quanLySoTietKiemView.showNguoiDung(nguoiDung);
        List<SoTietKiem> list = new ArrayList<SoTietKiem>();
        Iterator<SoTietKiem> list1 = nguoiDung.getSoTKs().iterator();
        while (list1.hasNext()) {
            {
                SoTietKiem soTietKiem = list1.next();
                if (soTietKiem.getTinhTrang() == 1) {
                    if (soTietKiem.getPhieuGDs().size() == 1) {
                        list.add(soTietKiem);
                    }
                }
            }
        }
        quanLySoTietKiemView.showDS(list);
        quanLySoTietKiemView.showLoaiTK(LoaiSTKDAO.layDSLoaiSTK());
        quanLySoTietKiemView.getPhieuRutListener(new QLSoController.PhieuRutListener());
        quanLySoTietKiemView.getTTSoListener(new QLSoController.TTSoListener());
        quanLySoTietKiemView.getTimKiemListener(new QLSoController.TimKiemListener());
    }

    public String tinhNgayToiHan(SoTietKiem soTietKiem) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cNgayGui = Calendar.getInstance();
        Calendar cNgayDenHan = Calendar.getInstance();
        cNgayGui.setTime(soTietKiem.getNgayMoSo());
        String tenLoai = soTietKiem.getLoaiSo().getTenLoai();
        if (tenLoai.equals("1 tháng")) {
            cNgayDenHan.roll(Calendar.MONTH, 1);
        }
        if (tenLoai.equals("6 tháng")) {
            cNgayDenHan.roll(Calendar.MONTH, 6);
        }
        if (tenLoai.equals("12 tháng")) {
            cNgayDenHan.roll(Calendar.YEAR, 1);
        }

        return dateFormat.format(cNgayDenHan.getTime());
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayToiHan = null;
        String ngay = null;
        try {
            ngay = tinhNgayToiHan(soTietKiem);
            ngayToiHan = dateFormat.parse(ngay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int khoangCach2Ngay = khoangCach2Ngay(soTietKiem.getNgayMoSo(), ngayToiHan);
        System.out.println(khoangCach2Ngay);
        BigDecimal tienLai = tinhLaiSuat(soTietKiem, khoangCach2Ngay);
        BigDecimal tongTien = tienLai.add(soTietKiem.getSoTienGui());
        list.add(String.valueOf(tienLai));
        list.add(ngay);
        list.add(String.valueOf(tongTien));
        return list;
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
                    if (soTietKiem.getTinhTrang() == 1)
                        if (soTietKiem.getMaND().equals(nguoiDung)) {
                            if (soTietKiem.getPhieuGDs().size() == 1) {
                                quanLySoTietKiemView.showTTSo(soTietKiem, TTDenHan(soTietKiem));
                            } else {
                                quanLySoTietKiemView.showMessage("Không tìm thấy sổ");
                            }
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
            PhieuGuiController phieuGuiController = new PhieuGuiController(nguoiDung, phieuGui);
            phieuGui.setVisible(true);
        }
    }

    class PhieuRutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SoTietKiem soTietKiem = quanLySoTietKiemView.getSelectedRow();
            PhieuRut phieuRut = new PhieuRut(khachHangView);
            List<String> list = TTDenHan(soTietKiem);
            PhieuRutController phieuDongController = new PhieuRutController(nguoiDung, soTietKiem, list, phieuRut);
            phieuRut.setVisible(true);

        }


    }
}







