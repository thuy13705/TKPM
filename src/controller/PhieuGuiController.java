package controller;

import com.mysql.cj.conf.PropertyDefinitions;
import model.dao.LoaiSTKDAO;
import model.dao.NguoiDungDAO;
import model.dao.PhieuGiaoDichDAO;
import model.dao.SoTietKiemDAO;
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


public class PhieuGuiController {
    private NguoiDung nguoiDung;
    PhieuGui phieuGuiView;
    private KhachHang KhachHangView;

    public PhieuGuiController(NguoiDung nguoiDung, PhieuGui phieuGuiView) {
        this.nguoiDung = nguoiDung;
        this.phieuGuiView = phieuGuiView;
        phieuGuiView.show(nguoiDung);
        phieuGuiView.showLoaiTK(LoaiSTKDAO.layDSLoaiSTK());
        phieuGuiView.xacNhanListener((ActionListener)new PhieuGuiController.xacNhanPhieuGuiListener());

    }


    class xacNhanPhieuGuiListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SoTietKiem soTietKiem = phieuGuiView.themPhieu();
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
                            phieuGuiView.showMessage("Mở sổ tiết kiệm thành công.");
                            nguoiDung.setSoDu(nguoiDung.getSoDu().subtract(phieuGiaoDich.getSoTien()));
                            NguoiDungDAO.capNhatND(nguoiDung);
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
        String tenLoai = soTietKiem.getLoaiSo().getTenLoai();
        if (tenLoai.equals("1 tháng")) {
            cNgayDenHan.roll(Calendar.MONTH, 1);
        }
        if (tenLoai.equals("6 tháng")) {
            cNgayDenHan.roll(Calendar.MONTH, 6);
        }
        if (tenLoai.equals("12 tháng")) {
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
