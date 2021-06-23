package controller;

import model.pojo.NguoiDung;
import ui.KiemToanTietKiem;

public class KiemToanTietKiemController {
    private NguoiDung nguoiDung;
    private KiemToanTietKiem KiemToanTietKiemView;
    public KiemToanTietKiemController(KiemToanTietKiem KiemToanTietKiemView,NguoiDung nguoiDung){
        this.KiemToanTietKiemView=KiemToanTietKiemView;
        this.nguoiDung=nguoiDung;
    }

    public void showKiemToanTietKiemView(){
        KiemToanTietKiemView.setVisible(true);
    }
}
