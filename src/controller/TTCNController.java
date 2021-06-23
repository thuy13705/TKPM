package controller;

import model.dao.NguoiDungDAO;
import model.pojo.NguoiDung;
import ui.ThongTinCaNhan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTCNController {
    private NguoiDung nguoiDung;
    ThongTinCaNhan thongTinCaNhan;

    public TTCNController(NguoiDung nguoiDung, ThongTinCaNhan thongTinCaNhan) {
        this.nguoiDung = nguoiDung;
        this.thongTinCaNhan = thongTinCaNhan;
        thongTinCaNhan.addThemListener(new ThongTinCaNhanListener());
        thongTinCaNhan.showTTCN(nguoiDung);
    }

    class ThongTinCaNhanListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            NguoiDung nguoiDungEdit=thongTinCaNhan.getND();
            if (nguoiDungEdit!=null){
                nguoiDung.setTenNd(nguoiDungEdit.getTenNd());
                nguoiDung.setCmnd(nguoiDungEdit.getCmnd());
                nguoiDung.setDiaChi(nguoiDungEdit.getDiaChi());
                nguoiDung.setSdt(nguoiDungEdit.getSdt());
                boolean check=NguoiDungDAO.capNhatND(nguoiDung);
                if (check==true){
                    thongTinCaNhan.showMessage("Cập nhật thành công.");
                    thongTinCaNhan.showTTCN(nguoiDung);
                }
                else
                    thongTinCaNhan.showMessage("Câp nhật thất bại.");
            }
        }
    }

}
