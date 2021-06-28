package controller;

import model.dao.SoTietKiemDAO;
import model.pojo.SoTietKiem;
import ui.PhongToaSo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PhongToaController {
    PhongToaSo phongToaSoView;
    List<SoTietKiem> list = null;
    
    public PhongToaController(PhongToaSo phongToaSoView) {
    
        this.phongToaSoView = phongToaSoView;

        phongToaSoView.showDS(SoTietKiemDAO.layDSSTKDangHoatDong());
        phongToaSoView.getPhongToaListener(new PhongToaListener());
    }



    class PhongToaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SoTietKiem soTietKiem = null;
            List<Integer> ma = phongToaSoView.getSelectedRow();
            for (int i = 0; i < ma.size(); i++) {
                soTietKiem = SoTietKiemDAO.laySTKID(ma.get(i));
                soTietKiem.setTinhTrang(3);
                boolean check = SoTietKiemDAO.capNhatSTK(soTietKiem);
                if (check == false) {
                    phongToaSoView.showMessage("Phong toả sổ thất bại");
                }
            }
            phongToaSoView.showMessage("Phong toả sổ thành công");

        }

    }
}
