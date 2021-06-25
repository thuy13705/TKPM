package ui;


import model.dao.NguoiDungDAO;
import model.pojo.NguoiDung;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class QuanLyDSNguoiDung extends javax.swing.JPanel implements ActionListener, ListSelectionListener {
    private JFrame jFrame;

    public QuanLyDSNguoiDung(JFrame jFrame) {
        this.jFrame=jFrame;
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableND = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH NGƯỜI DÙNG");

        jScrollPane1.setViewportView(tableND);

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/add1.png"))); // NOI18N
        btnThem.setText("Thêm mới");

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/edit1.png"))); // NOI18N
        btnSua.setText("Chỉnh sửa");

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/delete1.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                                .addContainerGap())
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(145, 145, 145)
                                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))

                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))))
        );

        btnXoa.setEnabled(false);
        btnXoa.setEnabled(true);
    }

    public void showMessage(String msg){
        JOptionPane.showMessageDialog(jFrame,msg);
    }

    public NguoiDung themND(){
        NguoiDung nguoiDung=null;
        JTextField txtTen=new JTextField();
        JTextField txtDiaChi=new JTextField();
        JTextField txtEmail=new JTextField();
        JTextField txtCMND=new JTextField();
        JTextField txtSDT=new JTextField();
        JTextField txtSoDu=new JTextField();
        JComboBox loaiNDBox=new JComboBox();
        loaiNDBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Ban Giám Đốc","Kiểm Toán Tiết Kiệm", "Kiểm Soát Viên","Khách Hàng" }));

        Object[] inputFields = {"Họ và Tên:", txtTen, "Địa chỉ:", txtDiaChi,"Email: ",txtEmail,
                "CMND/CCCD:", txtCMND,"SĐT:",txtSDT,"So Du:", txtSoDu,"Loại ND:",loaiNDBox };

        int option = JOptionPane.showConfirmDialog(jFrame, inputFields, "Thêm người dùng", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String username="";
            int max=NguoiDungDAO.layMaxID();

            int loai=loaiNDBox.getSelectedIndex()+1;
            switch (loai){
                case 1:
                    username="BGD"+String.valueOf(max+1);
                    break;
                case 2:
                    username="KTTK"+String.valueOf(max+1);
                    break;
                case 3:
                    username="KSV"+String.valueOf(max+1);
                    break;
                case 4:
                    username="KH"+String.valueOf(max+1);
                    break;
                default:
                    break;
            }
            String pass= BCrypt.hashpw(username,BCrypt.gensalt());
            if (!txtCMND.getText().equals("") && !txtTen.getText().equals("") && !txtSDT.getText().equals("")){
                nguoiDung=new NguoiDung(txtTen.getText(),txtDiaChi.getText(),txtCMND.getText(),txtSDT.getText(),txtEmail.getText(),username,pass,loai,Long.valueOf(txtSoDu.getText()));
            }
            else
                showMessage("Tên, CMND/CCCD, SĐT không được trống.");
        }
        return nguoiDung;
    }

    public NguoiDung suaND(NguoiDung nguoiDung){
        JTextField txtTen=new JTextField(nguoiDung.getTenNd());
        JTextField txtDiaChi=new JTextField(nguoiDung.getDiaChi());
        JTextField txtCMND=new JTextField(nguoiDung.getCmnd());
        JTextField txtSDT=new JTextField(nguoiDung.getSdt());

        Object[] inputFields = {"Họ và Tên:", txtTen, "Địa chỉ:", txtDiaChi,
                "CMND/CCCD:", txtCMND,"SĐT:",txtSDT};

        int option = JOptionPane.showConfirmDialog(jFrame, inputFields, "Sửa người dùng", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            if (!txtCMND.getText().equals("") && !txtTen.getText().equals("") && !txtSDT.getText().equals("")){
                nguoiDung.setTenNd(txtTen.getText());
                nguoiDung.setSdt(txtSDT.getText());
                nguoiDung.setCmnd(txtCMND.getText());
                nguoiDung.setCmnd(txtCMND.getText());
            }
            else
                showMessage("Tên, CMND/CCCD, SĐT không được trống.");
        }
        return nguoiDung;
    }

    public NguoiDung getSelectedRow() {
        NguoiDung nguoiDung=null;
        int row = tableND.getSelectedRow();
        if (row >= 0) {
            int id=Integer.valueOf(tableND.getModel().getValueAt(row,3).toString());
            nguoiDung=NguoiDungDAO.layNguoiDungID(id);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
        }
        return nguoiDung;
    }

    public int xoaND(){
        String[] options = {"Chắc chắn", "Huỷ"};
        int kq = JOptionPane.showOptionDialog(jFrame, "Bạn có chắn chắc muốn xoá người dùng này?",
                "Nhấn vào lựa chọn của bạn", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
      return kq;
    }

    public void showDS(List<NguoiDung> list){
        Object[][]objects=new Object[list.size()][4];

        for (int i=0; i<list.size(); i++){
            objects[i][0]=i+1;
            objects[i][1]=list.get(i).getTenNd();
            objects[i][2]=list.get(i).getUsername();
            objects[i][3]=list.get(i).getMaNd();
        }

        tableND.setModel(new javax.swing.table.DefaultTableModel(objects
                ,
                new String [] {
                        "STT", "Tên người dùng", "Tên đăng nhập", "Mã người dùng"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
    public void themListener(ActionListener listener) {
        btnThem.addActionListener(listener);
    }
    public void suaListener(ActionListener listener) {
        btnSua.addActionListener(listener);
    }
    public void xoaListener(ActionListener listener) {
        btnXoa.addActionListener(listener);
    }

    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableND;

}
