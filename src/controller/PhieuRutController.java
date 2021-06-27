package controller;

import model.dao.NguoiDungDAO;
import model.dao.PhieuGiaoDichDAO;
import model.pojo.NguoiDung;
import model.pojo.PhieuGiaoDich;
import model.pojo.SoTietKiem;
import ui.PhieuRut;
import ui.QuanLySoTietKiem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PhieuRutController {
    QuanLySoTietKiem quanLySoTietKiemView;
    private NguoiDung nguoiDung;
    PhieuRut phieuRutView;
    Date ngayGD = null;
    private SoTietKiem soTietKiem;
    BigDecimal soTien;

    public PhieuRutController(NguoiDung nguoiDung, SoTietKiem soTietKiem, PhieuRut phieuRutView) {
        this.nguoiDung = nguoiDung;
        this.soTietKiem = soTietKiem;
        this.phieuRutView = phieuRutView;
        tinhTong(soTietKiem);
        phieuRutView.show(soTietKiem, soTien);
        phieuRutView.tatToanListener((ActionListener) new PhieuRutController.tatToanPhieuRutListener());

    }

    public void tinhTong(SoTietKiem soTietKiem) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ngayGD = format.parse(java.time.LocalDate.now().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        soTien = soTietKiem.getSoTienGui().add(tinhLaiSuatTH(soTietKiem, khoangCach2Ngay(soTietKiem.getNgayMoSo(), ngayGD)));


    }

    //Tinh lai suat 0.2%
    public BigDecimal tinhLaiSuatTH(SoTietKiem soTietKiem, int soNgayGui) {
        BigDecimal soTienLai = (soTietKiem.getSoTienGui().multiply(BigDecimal.valueOf(0.2)));
        soTienLai = soTienLai.multiply(BigDecimal.valueOf(soNgayGui));
        soTienLai = soTienLai.divide(BigDecimal.valueOf(36000), 2, RoundingMode.HALF_DOWN);
        return soTienLai;
    }

    public int khoangCach2Ngay(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        return (int) ((c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000));

    }

    class tatToanPhieuRutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (soTietKiem != null) {
                PhieuGiaoDich phieuRut = phieuRutView.tatToan();
                if (phieuRut != null) {
                    phieuRut.setMaSo(soTietKiem);
                    phieuRut.setMaND(nguoiDung);
                    phieuRut.setNgayGiaoDich(ngayGD);
                    phieuRut.setSoTien(soTien);
                    boolean check = PhieuGiaoDichDAO.themPhieu(phieuRut);
                    if (check == true) {

                        phieuRutView.showMessage("Tất toán sổ thành công.");
                        nguoiDung.setSoDu(soTietKiem.getMaND().getSoDu().add( soTien));
                        NguoiDungDAO.capNhatND(nguoiDung);
                        phieuRutView.setVisible(false);
                        List<SoTietKiem> list = new ArrayList<>();
                        Iterator<SoTietKiem> list1 = nguoiDung.getSoTKs().iterator();
                        System.out.println(nguoiDung.getMaNd());

                    } else
                        phieuRutView.showMessage("Tất toán sổ thất bại");
                } else
                    phieuRutView.showMessage("Sổ tiết kiệm không tồn tại.");
            }

        }
    }




}