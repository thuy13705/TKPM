
package ui;


import javax.swing.*;
import java.awt.*;

public class KhachHang extends javax.swing.JFrame {


    public KhachHang() {
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnTTCN = new javax.swing.JButton();
        btnQLSo = new javax.swing.JButton();
        btnThongBao = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KHÁCH HÀNG");

        btnTTCN.setBackground(new java.awt.Color(54, 33, 89));
        btnTTCN.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnTTCN.setForeground(new java.awt.Color(255, 255, 255));
        btnTTCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/user.png"))); // NOI18N
        btnTTCN.setText("Thông tin cá nhân");
        btnTTCN.setToolTipText("");
        btnTTCN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTTCN.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTTCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpnView.removeAll();
                jpnView.setLayout(new BorderLayout());
                jpnView.add(new ThongTinCaNhan());
                jpnView.validate();
                jpnView.repaint();
            }

        });

        btnQLSo.setBackground(new java.awt.Color(54, 33, 89));
        btnQLSo.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnQLSo.setForeground(new java.awt.Color(255, 255, 255));
        btnQLSo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/note.png"))); // NOI18N
        btnQLSo.setText("Quản lý sổ tiết kiệm");
        btnQLSo.setToolTipText("");
        btnQLSo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQLSo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQLSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpnView.removeAll();
                jpnView.setLayout(new BorderLayout());
                jpnView.add(new QuanLySoTietKiem());
                jpnView.validate();
                jpnView.repaint();
            }
        });

        btnThongBao.setBackground(new java.awt.Color(54, 33, 89));
        btnThongBao.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnThongBao.setForeground(new java.awt.Color(255, 255, 255));
        btnThongBao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/bell.png"))); // NOI18N
        btnThongBao.setText("Thông báo");
        btnThongBao.setToolTipText("");
        btnThongBao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThongBao.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThongBao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpnView.removeAll();
                jpnView.setLayout(new BorderLayout());
                jpnView.add(new ThongBao());
                jpnView.validate();
                jpnView.repaint();
            }
        });

        btnDangXuat.setBackground(new java.awt.Color(54, 33, 89));
        btnDangXuat.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/exit.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setToolTipText("");
        btnDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpnView.removeAll();
                String[] options = {"Chắc chắn", "Huỷ"};
                int kq = JOptionPane.showOptionDialog(null, "Bạn có chắn chắc muốn thoát khỏi hệ thống?",
                        "Nhấn vào lựa chọn của bạn", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, options, options[0]);
                if (kq == 0) {
                    System.exit(0);
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(btnThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(201, Short.MAX_VALUE))
            .addComponent(btnTTCN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnQLSo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnTTCN, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLSo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(btnThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }




    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnQLSo;
    private javax.swing.JButton btnTTCN;
    private javax.swing.JButton btnThongBao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpnView;
}
