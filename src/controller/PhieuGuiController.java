package controller;

import model.dao.LoaiSTKDAO;
import model.dao.NguoiDungDAO;
import model.dao.PhieuGiaoDichDAO;
import model.dao.SoTietKiemDAO;
import model.pojo.LoaiSTK;
import model.pojo.NguoiDung;
import model.pojo.PhieuGiaoDich;
import model.pojo.SoTietKiem;
import ui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class PhieuGuiController {
    private NguoiDung nguoiDung;
    PhieuGui phieuGuiView;
    List<LoaiSTK> list = LoaiSTKDAO.layDSLoaiSTK();

    public PhieuGuiController(NguoiDung nguoiDung, PhieuGui phieuGuiView) {
        this.nguoiDung = nguoiDung;
        this.phieuGuiView = phieuGuiView;
        phieuGuiView.show(nguoiDung);
        phieuGuiView.showLoaiTK(list);
        phieuGuiView.xacNhanListener((ActionListener)new PhieuGuiController.xacNhanPhieuGuiListener());

    }


    class xacNhanPhieuGuiListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SoTietKiem soTietKiem = phieuGuiView.themPhieu(list);
            if (kiemTraSoTienGui(soTietKiem) == true) {
                if (kiemTraSoDu(nguoiDung, soTietKiem.getSoTienGui()) == false) {
                    soTietKiem.setMaND(nguoiDung);
                    try {
                        soTietKiem.setNgayDenHan(tinhNgayToiHan(soTietKiem));
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    if (soTietKiem != null) {
                        PhieuGiaoDich phieuGiaoDich = new PhieuGiaoDich();
                        boolean check1 = SoTietKiemDAO.themSTK(soTietKiem);
                        if (check1 == true) {
                            SoTietKiem soTietKiem1 = SoTietKiemDAO.layMaxID();
                            phieuGiaoDich.setMaSo(soTietKiem1);
                            phieuGiaoDich.setMaND(nguoiDung);
                            phieuGiaoDich.setLoaiPhieu(0);
                            phieuGiaoDich.setSoTien(soTietKiem1.getSoTienGui());
                            phieuGiaoDich.setNgayGiaoDich(soTietKiem1.getNgayMoSo());
                            boolean check = PhieuGiaoDichDAO.themPhieu(phieuGiaoDich);
                            if (check == false) {
                                phieuGuiView.showMessage("Không thể lập phiếu gửi");
                            }
                            phieuGuiView.showMessage("Mở sổ thành công, Sổ đã được thêm vào danh sách chờ duyệt");
                            phieuGuiView.setVisible(false);
                        } else
                            phieuGuiView.showMessage("Mở sổ thất bại");
                    } else
                        phieuGuiView.showMessage("Sổ tiết kiệm không tồn tại.");
                } else {
                    phieuGuiView.showMessage("Số dư không đủ");
                }
            }else{
                phieuGuiView.showMessage("Số tiền phải >= 1000000");
            }

        }
    }

    public Date tinhNgayToiHan(SoTietKiem soTietKiem) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cNgayGui = Calendar.getInstance();
        Calendar cNgayDenHan = Calendar.getInstance();
        cNgayGui.setTime(soTietKiem.getNgayMoSo());
        int thoiHan = soTietKiem.getLoaiSo().getThoiHan();
        if(thoiHan < 12) {
            cNgayDenHan.roll(Calendar.MONTH, thoiHan);
        }else if(thoiHan == 12){
            cNgayDenHan.roll(Calendar.YEAR, 1);
        }
        String ngayDenHan = format.format(cNgayDenHan.getTime());
        return format.parse(ngayDenHan);
    }

    public boolean kiemTraSoDu(NguoiDung nguoiDung, BigDecimal soTienGui){
        if(nguoiDung.getSoDu().compareTo(soTienGui) == -1){

            return true;
        }
        return false;
    }

    public boolean kiemTraSoTienGui(SoTietKiem soTietKiem){
        if(soTietKiem.getSoTienGui().compareTo(BigDecimal.valueOf(1000000)) < 0){
            return false;
        }
        return true;
    }
}
