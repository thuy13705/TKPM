
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BanGiamDoc extends javax.swing.JFrame implements ActionListener {


    public BanGiamDoc() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        btnTTCN = new JButton();
        btnBaoCao = new JButton();
        btnDangXuat = new JButton();
        btnThongBao = new JButton();
        jpnView = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(54, 33, 89));

        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("BAN GIÁM ĐỐC");

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

        btnBaoCao.setBackground(new Color(54, 33, 89));
        btnBaoCao.setOpaque(true);
        btnBaoCao.setBorderPainted(false);
        btnBaoCao.setFont(new Font("Lucida Grande", 1, 14)); // NOI18N
        btnBaoCao.setForeground(new Color(255, 255, 255));
        btnBaoCao.setIcon(new ImageIcon(getClass().getResource("/image/icon/business-report.png"))); // NOI18N
        btnBaoCao.setText("Xem báo cáo");
        btnBaoCao.setToolTipText("");
        btnBaoCao.setHorizontalAlignment(SwingConstants.LEFT);
        btnBaoCao.setHorizontalTextPosition(SwingConstants.RIGHT);

        btnBaoCao.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                jpnView.removeAll();
                jpnView.setLayout(new BorderLayout());
                jpnView.add(new XemBaoCao());
                jpnView.validate();
                jpnView.repaint();
            }
        });

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

        btnThongBao.setBackground(new Color(54, 33, 89));
        btnThongBao.setOpaque(true);
        btnThongBao.setBorderPainted(false);
        btnThongBao.setFont(new Font("Lucida Grande", 1, 14)); // NOI18N
        btnThongBao.setForeground(new Color(255, 255, 255));
        btnThongBao.setIcon(new ImageIcon(getClass().getResource("/image/icon/bell.png"))); // NOI18N
        btnThongBao.setText("Thông báo");
        btnThongBao.setToolTipText("");
        btnThongBao.setHorizontalAlignment(SwingConstants.LEFT);
        btnThongBao.setHorizontalTextPosition(SwingConstants.RIGHT);


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(btnTTCN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBaoCao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(188, Short.MAX_VALUE))
            .addComponent(btnDangXuat, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnThongBao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnTTCN, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBaoCao, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                .addComponent(btnThongBao, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpnView.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        GroupLayout jpnViewLayout = new GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void getTTCNListener(ActionListener listener){
        btnTTCN.addActionListener(listener);
    }

    public void baoCaoListener(ActionListener listener){
        btnBaoCao.addActionListener(listener);
    }

    private javax.swing.JButton btnBaoCao;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnTTCN;
    private javax.swing.JButton btnThongBao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpnView;

}
