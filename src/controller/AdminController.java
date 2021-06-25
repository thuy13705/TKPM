package controller;

import model.dao.NguoiDungDAO;
import model.pojo.NguoiDung;
import ui.Admin;
import ui.Login;
import ui.QuanLyDSNguoiDung;
import ui.ThongTinCaNhan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController {
    private NguoiDung nguoiDung;
    private Admin adminView;
    public AdminController(Admin adminView,NguoiDung nguoiDung){
        this.adminView=adminView;
        this.nguoiDung=nguoiDung;
        adminView.getTTCNListener(new TTCNListener());
        adminView.qlngListener(new QLNDListener());
    }

    public void showAdminView(){
        adminView.setVisible(true);
    }

    class TTCNListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ThongTinCaNhan thongTinCaNhan=new ThongTinCaNhan(adminView);
            TTCNController ttcnController=new TTCNController(nguoiDung,thongTinCaNhan,adminView);
            adminView.showPanel(thongTinCaNhan);
        }
    }

    class QLNDListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            QuanLyDSNguoiDung quanLyDSNguoiDung=new QuanLyDSNguoiDung(adminView);
            QLNDController qlndController=new QLNDController(nguoiDung,quanLyDSNguoiDung);
            adminView.showPanel(quanLyDSNguoiDung);
        }
    }

}