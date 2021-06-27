
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
        btnLaiSuat.setText("Thông báo");
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
        btnDangXuat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addComponent(btnLaiSuat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDangXuat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(201, Short.MAX_VALUE))
                        .addComponent(btnTTCN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQLSo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLichSu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnTTCN, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQLSo, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLichSu, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                                .addComponent(btnLaiSuat, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
        );

        btnLichSu.getAccessibleContext().setAccessibleName("Lịch sử");

        jpnView.setPreferredSize(new Dimension(752, 595));

        GroupLayout jpnViewLayout = new GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
                jpnViewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 752, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
                jpnViewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpnView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
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
