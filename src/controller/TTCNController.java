package controller;

import model.dao.NguoiDungDAO;
import model.pojo.NguoiDung;
import ui.DoiThongTinDangNhap;
import ui.ThongTinCaNhan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTCNController {
    private JFrame jFrame;
    private NguoiDung nguoiDung;
    ThongTinCaNhan thongTinCaNhan;

    public TTCNController(NguoiDung nguoiDung, ThongTinCaNhan thongTinCaNhan,JFrame jFrame) {
        this.jFrame=jFrame;
        this.nguoiDung = nguoiDung;
        this.thongTinCaNhan = thongTinCaNhan;
        thongTinCaNhan.showTTCN(nguoiDung);
        thongTinCaNhan.addThemListener(new ThongTinCaNhanListener());
        thongTinCaNhan.doiListener(new DoiListener());
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

    class DoiListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            DoiThongTinDangNhap doiThongTinDangNhap=new DoiThongTinDangNhap(jFrame,true,nguoiDung);
            doiThongTinDangNhap.setVisible(true);
            DoiTTDNController doiTTDNController=new DoiTTDNController(nguoiDung,doiThongTinDangNhap);
        }
    }

}
