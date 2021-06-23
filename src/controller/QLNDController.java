package controller;

import model.dao.NguoiDungDAO;
import model.pojo.NguoiDung;
import ui.QuanLyDSNguoiDung;
import ui.ThongTinCaNhan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QLNDController {
    private NguoiDung nguoiDung;
    QuanLyDSNguoiDung quanLyDSNguoiDung;

    public QLNDController(NguoiDung nguoiDung, QuanLyDSNguoiDung quanLyDSNguoiDung) {
        this.nguoiDung = nguoiDung;
        this.quanLyDSNguoiDung = quanLyDSNguoiDung;
        List<NguoiDung> list=NguoiDungDAO.layDSNguoiDung();
        quanLyDSNguoiDung.showDS(list);
        quanLyDSNguoiDung.themListener(new themQLNDListener());
        quanLyDSNguoiDung.suaListener(new suaQLNDListener());
        quanLyDSNguoiDung.xoaListener(new xoaQLNDListener());
    }

    class themQLNDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           NguoiDung nguoiDung=quanLyDSNguoiDung.themND();
           if (nguoiDung!=null){
               boolean check=NguoiDungDAO.ThemND(nguoiDung);
               if (check==true){
                   List<NguoiDung> list=NguoiDungDAO.layDSNguoiDung();
                   quanLyDSNguoiDung.showDS(list);
                   quanLyDSNguoiDung.showMessage("Thêm thành công.");
               }
               else
                   quanLyDSNguoiDung.showMessage("Thêm thất bại");
           }
           else
               quanLyDSNguoiDung.showMessage("Người dùng không tồn tại.");
        }
    }

    class suaQLNDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            NguoiDung nguoiDung=quanLyDSNguoiDung.getSelectedRow();
            if (nguoiDung!=null){
                nguoiDung=quanLyDSNguoiDung.suaND(nguoiDung);
                boolean check=NguoiDungDAO.capNhatND(nguoiDung);
                if (check==true){
                    List<NguoiDung> list=NguoiDungDAO.layDSNguoiDung();
                    quanLyDSNguoiDung.showDS(list);
                    quanLyDSNguoiDung.showMessage("Cập nhật thành công.");
                }
                else
                    quanLyDSNguoiDung.showMessage("Cập nhật thất bại");
            }
            else
                quanLyDSNguoiDung.showMessage("Người dùng không tồn tại.");
        }
    }

    class xoaQLNDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            NguoiDung nguoiDung=quanLyDSNguoiDung.getSelectedRow();
            if (nguoiDung!=null){
                int kq=quanLyDSNguoiDung.xoaND();
                if (kq==0){
                    boolean check=NguoiDungDAO.xoaND(nguoiDung.getMaNd());
                    if (check==true){
                        List<NguoiDung> list=NguoiDungDAO.layDSNguoiDung();
                        quanLyDSNguoiDung.showDS(list);
                        quanLyDSNguoiDung.showMessage("Xoá thành công.");
                    }
                    else
                        quanLyDSNguoiDung.showMessage("Xoá thất bại");
                }
            }
            else
                quanLyDSNguoiDung.showMessage("Người dùng không tồn tại.");
        }
    }
}
