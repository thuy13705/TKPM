package controller;

import model.dao.LoaiSTKDAO;
import model.pojo.LoaiSTK;
import ui.BangLaiSuat;
import ui.BaoCao;
import ui.BaoCaoNgay;
import ui.BaoCaoThang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BaoCaoController {
    private BaoCao baoCao;

    public BaoCaoController(BaoCao baoCao){
        this.baoCao=baoCao;
        baoCao.bcNgay(new BCNgayListener());
        baoCao.bcThang(new BCThangListener());
    }

    class BCNgayListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BaoCaoNgay baoCaoNgay=new BaoCaoNgay();
            BCNgayController bcNgayController=new BCNgayController(baoCaoNgay);
            baoCao.showPanel(baoCaoNgay);
        }
    }

    class BCThangListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BaoCaoThang baoCaoThang=new BaoCaoThang();
            BCThangController bcThangController=new BCThangController(baoCaoThang);
            baoCao.showPanel(baoCaoThang);
        }
    }
}