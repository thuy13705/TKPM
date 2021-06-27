package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends javax.swing.JFrame implements ActionListener {


    public Admin() {
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnQuanLyNguoiDung = new javax.swing.JButton();
        btnTTCN = new javax.swing.JButton();
        btnLaiSuat = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMIN");

        btnQuanLyNguoiDung.setBackground(new java.awt.Color(54, 33, 89));
        btnQuanLyNguoiDung.setOpaque(true);
        btnQuanLyNguoiDung.setBorderPainted(false);
        btnQuanLyNguoiDung.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnQuanLyNguoiDung.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyNguoiDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/community.png"))); // NOI18N
        btnQuanLyNguoiDung.setText("Quản lý người dùng");
        btnQuanLyNguoiDung.setToolTipText("");
        btnQuanLyNguoiDung.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyNguoiDung.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnTTCN.setBackground(new java.awt.Color(54, 33, 89));
        btnTTCN.setOpaque(true);
        btnTTCN.setBorderPainted(false);
        btnTTCN.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnTTCN.setForeground(new java.awt.Color(255, 255, 255));
        btnTTCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/user.png"))); // NOI18N
        btnTTCN.setText("Thông tin cá nhân");
        btnTTCN.setToolTipText("");
        btnTTCN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTTCN.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnLaiSuat.setBackground(new java.awt.Color(54, 33, 89));
        btnLaiSuat.setOpaque(true);
        btnLaiSuat.setBorderPainted(false);
        btnLaiSuat.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnLaiSuat.setForeground(new java.awt.Color(255, 255, 255));
        btnLaiSuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/bell.png"))); // NOI18N
        btnLaiSuat.setText("Lãi suất và Quy định");
        btnLaiSuat.setToolTipText("");
        btnLaiSuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLaiSuat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnDangXuat.setBackground(new java.awt.Color(54, 33, 89));
        btnDangXuat.setOpaque(true);
        btnDangXuat.setBorderPainted(false);
        btnDangXuat.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/exit.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setToolTipText("");
        btnDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnQuanLyNguoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addComponent(btnLaiSuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(btnTTCN, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(btnQuanLyNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(btnLaiSuat, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(92, 92, 92)
                    .addComponent(btnTTCN, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(415, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this,msg);
    }

    public void showPanel(JPanel panel){
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(panel);
        jpnView.validate();
        jpnView.repaint();
    }

    public int logout(){
        jpnView.removeAll();
        String[] options = {"Chắc chắn", "Huỷ"};
        int kq = JOptionPane.showOptionDialog(null, "Bạn có chắn chắc muốn thoát khỏi hệ thống?",
                "Nhấn vào lựa chọn của bạn", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        return kq;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void getTTCNListener(ActionListener listener){
        btnTTCN.addActionListener(listener);
    }

    public void qlngListener(ActionListener listener){
        btnQuanLyNguoiDung.addActionListener(listener);
    }

    public void bangLSListener(ActionListener listener){
        btnLaiSuat.addActionListener(listener);
    }

    public void logoutListener(ActionListener listener){
        btnDangXuat.addActionListener(listener);
    }
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnQuanLyNguoiDung;
    private javax.swing.JButton btnTTCN;
    private javax.swing.JButton btnLaiSuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpnView;

}
