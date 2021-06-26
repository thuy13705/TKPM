package controller;

import model.dao.PhieuGiaoDichDAO;
import model.pojo.BCNgay;
import model.pojo.BCThang;
import ui.BaoCaoNgay;
import ui.BaoCaoThang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.YearMonth;
import java.util.Date;
import java.util.List;

public class BCThangController {
    private BaoCaoThang baoCaoThang;

    public BCThangController(BaoCaoThang baoCaoThang){
        this.baoCaoThang=baoCaoThang;
        baoCaoThang.thongke(new ThongKeListener());
    }

    class ThongKeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                YearMonth yearMonth = baoCaoThang.layThangNam();
                if (yearMonth !=null){
                    List<BCThang> list= PhieuGiaoDichDAO.layDSPhieuGDThang(yearMonth);
                    baoCaoThang.showThongKe(list);
                }
                else
                    baoCaoThang.showMessage("Tháng bạn chọn chưa có giao dịch");
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }
    }
}
