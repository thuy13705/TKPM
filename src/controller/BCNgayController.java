package controller;

import model.dao.PhieuGiaoDichDAO;
import model.pojo.BCNgay;
import ui.BaoCaoNgay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


public class BCNgayController {
    private BaoCaoNgay baoCaoNgay;

    public BCNgayController(BaoCaoNgay baoCaoNgay){
        this.baoCaoNgay=baoCaoNgay;
        baoCaoNgay.thongke(new ThongKeListener());
    }

    class ThongKeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Date date= null;
            try {
                date = baoCaoNgay.layNgay();
                if (date !=null){
                    List<BCNgay> list= PhieuGiaoDichDAO.layDSPhieuGDNgay(date);
                    baoCaoNgay.showThongKe(list);
                }
                else
                    baoCaoNgay.showMessage("Ngày bạn chọn chưa có giao dịch");
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }
    }
}
