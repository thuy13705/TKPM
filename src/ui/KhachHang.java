
package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KhachHang extends javax.swing.JFrame {


    public KhachHang() {
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        btnTTCN = new JButton();
        btnQLSo = new JButton();
        btnLichSu = new JButton();
        btnLaiSuat = new JButton();
        btnDangXuat = new JButton();
        jpnView = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(54, 33, 89));

        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("KHÁCH HÀNG");

        btnTTCN.setBackground(new Color(54, 33, 89));
        btnTTCN.setOpaque(true);
        btnTTCN.setBorderPainted(false);
        btnTTCN.setFont(new Font("Lucida Grande", 1, 14)); // NOI18N
        btnTTCN.setForeground(new Color(255, 255, 255));
        btnTTCN.setIcon(new ImageIcon(getClass().getResource("/image/icon/user.png"))); // NOI18N
        btnTTCN.setText("Thông tin cá nhân");
        btnTTCN.setToolTipText("");
        btnTTCN.setHorizontalAlignment(SwingConstants.LEFT);
        btnTTCN.setHorizontalTextPosition(SwingConstants.RIGHT);


        btnQLSo.setBackground(new Color(54, 33, 89));
        btnQLSo.setOpaque(true);
        btnQLSo.setBorderPainted(false);
        btnQLSo.setFont(new Font("Lucida Grande", 1, 14)); // NOI18N
        btnQLSo.setForeground(new Color(255, 255, 255));
        btnQLSo.setIcon(new ImageIcon(getClass().getResource("/image/icon/note.png"))); // NOI18N
        btnQLSo.setText("Quản lý sổ tiết kiệm");
        btnQLSo.setToolTipText("");
        btnQLSo.setHorizontalAlignment(SwingConstants.LEFT);
        btnQLSo.setHorizontalTextPosition(SwingConstants.RIGHT);

        btnLichSu.setBackground(new Color(54, 33, 89));
        btnLichSu.setOpaque(true);
        btnLichSu.setBorderPainted(false);
        btnLichSu.setFont(new Font("Lucida Grande", 1, 14)); // NOI18N
        btnLichSu.setForeground(new Color(255, 255, 255));
        btnLichSu.setIcon(new ImageIcon(getClass().getResource("/image/icon/history.png"))); // NOI18N
        btnLichSu.setText("Quản lý sổ tiết kiệm");
        btnLichSu.setToolTipText("");
        btnLichSu.setHorizontalAlignment(SwingConstants.LEFT);
        btnLichSu.setHorizontalTextPosition(SwingConstants.RIGHT);


        btnLaiSuat.setBackground(new Color(54, 33, 89));
        btnLaiSuat.setOpaque(true);
        btnLaiSuat.setBorderPainted(false);
        btnLaiSuat.setFont(new Font("Lucida Grande", 1, 14)); // NOI18N
        btnLaiSuat.setForeground(new Color(255, 255, 255));
        btnLaiSuat.setIcon(new ImageIcon(getClass().getResource("/image/icon/bell.png"))); // NOI18N
        btnLaiSuat.setText("Lãi suất và Quy định");
        btnLaiSuat.setToolTipText("");
        btnLaiSuat.setHorizontalAlignment(SwingConstants.LEFT);
        btnLaiSuat.setHorizontalTextPosition(SwingConstants.RIGHT);

        btnDangXuat.setBackground(new Color(54, 33, 89));
        btnDangXuat.setOpaque(true);
        btnDangXuat.setBorderPainted(false);
        btnDangXuat.setFont(new Font("Lucida Grande", 1, 14)); // NOI18N
        btnDangXuat.setForeground(new Color(255, 255, 255));
        btnDangXuat.setIcon(new ImageIcon(getClass().getResource("/image/icon/exit.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setToolTipText("");
        btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
        btnDangXuat.setHorizontalTextPosition(SwingConstants.RIGHT);
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addComponent(btnLaiSuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(201, Short.MAX_VALUE))
                        .addComponent(btnTTCN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQLSo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLichSu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                                .addComponent(btnLaiSuat, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnLichSu.getAccessibleContext().setAccessibleName("Lịch sử");

        jpnView.setPreferredSize(new java.awt.Dimension(752, 595));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
                jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 752, Short.MAX_VALUE)
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

    public void getTTCNListener(ActionListener listener){
        btnTTCN.addActionListener(listener);
    }

    public void getQLSoListener(ActionListener listener){
        btnQLSo.addActionListener(listener);
    }

    public void getQLSoDaTTListener(ActionListener listener){
        btnLichSu.addActionListener(listener);
    }

    public void bangLaiSuatListener(ActionListener listener){
        btnLaiSuat.addActionListener(listener);
    }

    public void logoutListener(ActionListener listener){
        btnDangXuat.addActionListener(listener);
    }

    private javax.swing.JButton btnQLSo;
    private javax.swing.JButton btnTTCN;
    private javax.swing.JButton btnLichSu;
    private javax.swing.JButton btnLaiSuat;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpnView;
}
