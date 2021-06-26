package controller;

import model.dao.LoaiSTKDAO;
import model.dao.SoTietKiemDAO;
import model.pojo.NguoiDung;
import model.pojo.PhieuGiaoDich;
import model.pojo.SoTietKiem;
import ui.DanhSachSoDaTT;
import ui.PhongToaSo;
import ui.QuanLySoTietKiem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QLSoDaTTController {
    private NguoiDung nguoiDung;
    private DanhSachSoDaTT danhSachSoDaTTView;
    List<SoTietKiem> list = null;

    public QLSoDaTTController(NguoiDung nguoiDung, DanhSachSoDaTT danhSachSoDaTTView) {
        this.nguoiDung = nguoiDung;
        this.danhSachSoDaTTView = danhSachSoDaTTView;
        List<SoTietKiem> list = new ArrayList<SoTietKiem>();
        Iterator<SoTietKiem> list1 = nguoiDung.getSoTKs().iterator();
        while (list1.hasNext()) {
            {
                SoTietKiem soTietKiem = list1.next();
                if (soTietKiem.getTinhTrang() == 1) {
                    if (soTietKiem.getPhieuGDs().size() == 2) {
                        list.add(soTietKiem);
                    }
                }
            }
        }
        danhSachSoDaTTView.showDS(list);
        danhSachSoDaTTView.getTTSoListener(new QLSoDaTTController.TTSoListener());
        danhSachSoDaTTView.getTimKiemListener(new QLSoDaTTController.TimKiemListener());
    }


    class TTSoListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            SoTietKiem soTietKiem = danhSachSoDaTTView.getSelectedRow();
            PhieuGiaoDich phieuRut = null;
            Iterator<PhieuGiaoDich> phieus = soTietKiem.getPhieuGDs().iterator();
            while(phieus.hasNext()){
                PhieuGiaoDich phieu = phieus.next();
                if(phieu.getLoaiPhieu() == 1)
                {
                    phieuRut = phieu;
                    danhSachSoDaTTView.showTTSo(soTietKiem, phieuRut);
                    return;
                }
            }

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
            String ma = danhSachSoDaTTView.layMaTimKiem();
            if (!ma.equals("")) {
                int maSo = Integer.parseInt(ma);
                SoTietKiem soTietKiem = SoTietKiemDAO.laySTKID(maSo);
                if (soTietKiem != null) {
                    if (soTietKiem.getTinhTrang() == 0)
                        if (soTietKiem.getMaND().equals(nguoiDung)) {
                            if (soTietKiem.getPhieuGDs().size() == 2) {
                                Iterator<PhieuGiaoDich> phieus = soTietKiem.getPhieuGDs().iterator();
                                while(phieus.hasNext()){
                                    PhieuGiaoDich phieuRut = phieus.next();
                                    if(phieuRut.getLoaiPhieu() == 1){
                                        danhSachSoDaTTView.showTTSo(soTietKiem,phieuRut);
                                        return;
                                    }
                                }
                            } else {
                                danhSachSoDaTTView.showMessage("Không tìm thấy sổ");
                            }
                        } else {
                            danhSachSoDaTTView.showMessage("Không tìm thấy sổ");
                        }
                    else {
                        danhSachSoDaTTView.showMessage("Không tìm thấy sổ");
                    }

                } else {
                    danhSachSoDaTTView.showMessage("Không tìm thấy sổ");
                }
            } else {
                danhSachSoDaTTView.showMessage("Chưa nhập mã để tìm kiếm");
            }
        }

    }
}
