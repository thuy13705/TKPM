
package ui;


import model.pojo.PhieuGiaoDich;
import model.pojo.SoTietKiem;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class PhieuRut extends javax.swing.JDialog {
    private JFrame jFrame;

    public PhieuRut(JFrame jFrame) {
        this.jFrame = jFrame;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jlbKhachHang = new javax.swing.JLabel();
        jlbNgayGui = new javax.swing.JLabel();
        jlbNgayRut = new javax.swing.JLabel();
        jlbTong = new javax.swing.JLabel();
        btnTatToan = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jlbMaSo = new javax.swing.JLabel();
        jlbSoTien = new javax.swing.JLabel();
        jlbLoaiTK = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlbKhachHang.setText("Khách hàng: ");

        jlbNgayGui.setText("Ngày gửi: ");

        jlbNgayRut.setText("Ngày rút: ");

        jlbTong.setText("Tổng số tiền nhận được: ");

        btnTatToan.setText("Tất toán");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Phiếu rút tiền");

        jlbMaSo.setText("Mã sổ: ");

        jlbSoTien.setText("Số tiền gửi: ");

        jlbLoaiTK.setText("Loại tiết kiệm:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbMaSo)
                    .addComponent(jlbSoTien)
                    .addComponent(jlbLoaiTK))
                .addGap(145, 145, 145)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbTong)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlbKhachHang)
                        .addComponent(jlbNgayGui)
                        .addComponent(jlbNgayRut)))
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTatToan)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaSo)
                    .addComponent(jlbKhachHang))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSoTien)
                    .addComponent(jlbNgayGui))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLoaiTK)
                    .addComponent(jlbNgayRut))
                .addGap(50, 50, 50)
                .addComponent(jlbTong)
                .addGap(18, 18, 18)
                .addComponent(btnTatToan)
                .addGap(0, 58, Short.MAX_VALUE))
        );

        pack();
    }

    public void showMessage(String msg){
        JOptionPane.showMessageDialog(jFrame,msg);
    }

    public void show(SoTietKiem soTietKiem, BigDecimal tong){
        jlbMaSo.setText("Mã sổ: " + soTietKiem.getMaSo());
        jlbSoTien.setText("Số tiền gửi: " + soTietKiem.getSoTienGui());
        jlbLoaiTK.setText("Loại tiết kiệm: " + soTietKiem.getLoaiSo().getTenLoai());
        jlbKhachHang.setText("Khách hàng: " + soTietKiem.getMaND().getTenNd());
        jlbNgayGui.setText("Ngày gửi: " + soTietKiem.getNgayMoSo().toString());
        jlbNgayRut.setText("Ngày rút: " + java.time.LocalDate.now());
        jlbTong.setText("Tổng tiền nhận được: " + tong);

    }

    public PhieuGiaoDich tatToan(){
        PhieuGiaoDich phieu = new PhieuGiaoDich();
        phieu.setLoaiPhieu(1);
        return phieu;
    }

    public void tatToanListener(ActionListener listener){
        btnTatToan.addActionListener(listener);
    }


    private javax.swing.JButton btnTatToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbKhachHang;
    private javax.swing.JLabel jlbLoaiTK;
    private javax.swing.JLabel jlbMaSo;
    private javax.swing.JLabel jlbNgayGui;
    private javax.swing.JLabel jlbNgayRut;
    private javax.swing.JLabel jlbSoTien;
    private javax.swing.JLabel jlbTong;

}
