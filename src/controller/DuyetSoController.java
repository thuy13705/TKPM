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
                            danhSachChoDuyetView.showMessage("Không tìm thấy sổ");
                        }

                    } else {
                        danhSachChoDuyetView.showMessage("Không tìm thấy sổ");
                    }
                } else {
                    danhSachChoDuyetView.showMessage("Không tìm thấy sổ");


                }
            } else {
                danhSachChoDuyetView.showMessage("Chưa nhập mã để tìm kiếm");

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
                    danhSachChoDuyetView.showMessage("Duyệt thành công. Sổ đang ở trạng thái hoạt động");
                    NguoiDung nguoiDung = soTietKiem.getMaND();
                    nguoiDung.setSoDu(nguoiDung.getSoDu().subtract(soTietKiem.getSoTienGui()));
                    NguoiDungDAO.capNhatND(nguoiDung);
                } else
                    danhSachChoDuyetView.showMessage("Duyệt thất bại");
            } else
                danhSachChoDuyetView.showMessage("Sổ tiết kiệm không tồn tại.");
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

                    danhSachChoDuyetView.showMessage("Đã xoá sổ tiết kiệm");
                } else
                    danhSachChoDuyetView.showMessage("Xoá thất bại");
            } else
                danhSachChoDuyetView.showMessage("Sổ không tồn tại");
        }
    }
}



