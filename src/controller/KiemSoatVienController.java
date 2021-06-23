package controller;

import model.pojo.NguoiDung;
import ui.KiemSoatVien;

public class KiemSoatVienController {
    private NguoiDung nguoiDung;
    private KiemSoatVien KiemSoatVienView;
    public KiemSoatVienController(KiemSoatVien KiemSoatVienView,NguoiDung nguoiDung){
        this.KiemSoatVienView=KiemSoatVienView;
        this.nguoiDung=nguoiDung;
    }

    public void showKiemSoatVienView(){
        KiemSoatVienView.setVisible(true);
    }
}
