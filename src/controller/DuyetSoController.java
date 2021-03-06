package controller;

import model.dao.NguoiDungDAO;
import model.dao.SoTietKiemDAO;
import model.pojo.NguoiDung;
import model.pojo.SoTietKiem;
import ui.DanhSachChoDuyet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DuyetSoController {
    private DanhSachChoDuyet danhSachChoDuyetView;

    public DuyetSoController(DanhSachChoDuyet danhSachChoDuyetView) {

        this.danhSachChoDuyetView = danhSachChoDuyetView;

        danhSachChoDuyetView.getTTSoListener(new TTSoListener());
        danhSachChoDuyetView.getTimKiemListener(new TimKiemListener());
        danhSachChoDuyetView.getDuyetListener(new DuyetListener());
        danhSachChoDuyetView.getXoaListener(new XoaListener());

        danhSachChoDuyetView.showDS(SoTietKiemDAO.layDSSTKChuaDuyet());

    }

    class TTSoListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            SoTietKiem soTietKiem = danhSachChoDuyetView.getSelectedRow();
            danhSachChoDuyetView.showTTSo(soTietKiem);
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
            String ma = danhSachChoDuyetView.layMaTimKiem();
            if (!ma.equals("")) {
                int maSo = Integer.parseInt(ma);
                SoTietKiem soTietKiem = SoTietKiemDAO.laySTKID(maSo);
                if (soTietKiem != null) {
                    if (soTietKiem.getTinhTrang() == 0) {
                        if (soTietKiem.getPhieuGDs().size() == 1) {
                            danhSachChoDuyetView.showTTSo(soTietKiem);
                        } else {
                            danhSachChoDuyetView.showMessage("Kh??ng t??m th???y s???");
                        }

                    } else {
                        danhSachChoDuyetView.showMessage("Kh??ng t??m th???y s???");
                    }
                } else {
                    danhSachChoDuyetView.showMessage("Kh??ng t??m th???y s???");


                }
            } else {
                danhSachChoDuyetView.showMessage("Ch??a nh???p m?? ????? t??m ki???m");

            }
        }
    }

    class DuyetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SoTietKiem soTietKiem = danhSachChoDuyetView.getSelectedRow();
            if (soTietKiem != null) {
                soTietKiem.setTinhTrang(1);
                boolean check = SoTietKiemDAO.capNhatSTK(soTietKiem);
                if (check == true) {
                    danhSachChoDuyetView.showDS(SoTietKiemDAO.layDSSTKChuaDuyet());
                    danhSachChoDuyetView.showMessage("Duy???t th??nh c??ng. S??? ??ang ??? tr???ng th??i ho???t ?????ng");
                    NguoiDung nguoiDung = soTietKiem.getMaND();
                    nguoiDung.setSoDu(nguoiDung.getSoDu().subtract(soTietKiem.getSoTienGui()));
                    NguoiDungDAO.capNhatND(nguoiDung);
                } else
                    danhSachChoDuyetView.showMessage("Duy???t th???t b???i");
            } else
                danhSachChoDuyetView.showMessage("S??? ti???t ki???m kh??ng t???n t???i.");
        }
    }

    class XoaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SoTietKiem soTietKiem = danhSachChoDuyetView.getSelectedRow();
            if (soTietKiem != null) {
                boolean check = SoTietKiemDAO.xoaSTK(soTietKiem.getMaSo());
                if (check == true) {
                    danhSachChoDuyetView.showDS(SoTietKiemDAO.layDSSTKChuaDuyet());

                    danhSachChoDuyetView.showMessage("???? xo?? s??? ti???t ki???m");
                } else
                    danhSachChoDuyetView.showMessage("Xo?? th???t b???i");
            } else
                danhSachChoDuyetView.showMessage("S??? kh??ng t???n t???i");
        }
    }
}



