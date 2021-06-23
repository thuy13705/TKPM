package controller;

import model.pojo.NguoiDung;
import ui.Admin;
import ui.BanGiamDoc;

public class BanGiamDocController {
    private NguoiDung nguoiDung;
    private BanGiamDoc banGiamDocView;
    public BanGiamDocController(BanGiamDoc banGiamDocView,NguoiDung nguoiDung){
        this.banGiamDocView=banGiamDocView;
        this.nguoiDung=nguoiDung;
    }

    public void showBanGiamDoc(){
        banGiamDocView.setVisible(true);
    }
}
