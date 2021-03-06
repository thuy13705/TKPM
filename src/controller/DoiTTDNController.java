package controller;

import model.dao.NguoiDungDAO;
import model.pojo.NguoiDung;
import org.mindrot.jbcrypt.BCrypt;
import ui.DoiThongTinDangNhap;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoiTTDNController {
    private NguoiDung nguoiDung;
    DoiThongTinDangNhap doiThongTinDangNhap;

    public DoiTTDNController(NguoiDung nguoiDung,DoiThongTinDangNhap doiThongTinDangNhap){
        this.nguoiDung=nguoiDung;
        this.doiThongTinDangNhap=doiThongTinDangNhap;
        doiThongTinDangNhap.doiTTDNListener(new DoiTTDNListener());
    }

    public void showDoiTTDN(){
        doiThongTinDangNhap.setVisible(true);
    }

    class DoiTTDNListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            NguoiDung nd=doiThongTinDangNhap.doiTT();
            if (nd!=null){
                nguoiDung.setPassword(BCrypt.hashpw(nd.getPassword(),BCrypt.gensalt()));
                nguoiDung.setUsername(nd.getUsername());
                boolean check=NguoiDungDAO.capNhatND(nguoiDung);
                if (check==true){
                    doiThongTinDangNhap.showMessage("Đổi thành công.");
                }
                else
                    doiThongTinDangNhap.showMessage("Đổi thất bại.");
                doiThongTinDangNhap.setVisible(false);
            }
        }
    }
}
