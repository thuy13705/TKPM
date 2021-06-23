package controller;

import model.pojo.NguoiDung;
import ui.KhachHang;

public class KhachHangController {
    private NguoiDung nguoiDung;
    private KhachHang KhachHangView;
    public KhachHangController(KhachHang KhachHangView,NguoiDung nguoiDung){
        this.KhachHangView=KhachHangView;
        this.nguoiDung=nguoiDung;
    }

    public void showKhachHangView(){
        KhachHangView.setVisible(true);
    }
}
