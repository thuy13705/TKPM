
package ui;

import model.dao.SoTietKiemDAO;
import model.pojo.SoTietKiem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class DanhSachChoDuyet extends javax.swing.JPanel implements ActionListener {
    private JFrame jFrame;

    public DanhSachChoDuyet(JFrame jFrame) {
        this.jFrame = jFrame;
        initComponents();
    }



    @SuppressWarnings("unchecked")

    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        tableDS = new JTable();
        jLabel4 = new JLabel();
        txtTimKiem = new JTextField();
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jPanel2 = new JPanel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();

        jLabel14 = new JLabel();
        jLabel6 = new JLabel();
        jlbMaSo = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jlbMaKH = new JLabel();
        jlbTenKH = new JLabel();
        jlbDiaChi = new JLabel();
        jlbSDT = new JLabel();
        jlbCMND = new JLabel();
        jlbEmail = new JLabel();
        jlbSoTienGui = new JLabel();
        jlbNgayGui = new JLabel();
        jlbLoaiTK = new JLabel();
        jlbLaiSuat = new JLabel();
        jlbNgayDenHan = new JLabel();

        jLabel5 = new JLabel();
        btnDuyet = new JButton();
        btnXoa = new JButton();



        jScrollPane1.setViewportView(tableDS);

        jLabel4.setText("Tìm kiếm: ");



        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Danh sách sổ tiết kiệm chờ duyệt");

        jLabel8.setText("Số tiền gửi:");

        jLabel9.setText("Ngày gửi:");

        jLabel10.setText("Loại tiết kiệm:");

        jLabel11.setText("Tên khách hàng:");

        jLabel12.setText("Địa chỉ:");

        jLabel13.setText("Ngày đến hạn:");

        jLabel14.setText("Lãi suất:");

        jLabel6.setText("Mã sổ:");

        jlbMaSo.setText("");

        jLabel16.setText("Email:");

        jLabel17.setText("Số điện thoại:");

        jLabel18.setText("Mã khách hàng:");

        jLabel19.setText("CMND/Căn cước:");

        jlbMaKH.setText("");

        jlbTenKH.setText("");

        jlbDiaChi.setText("");

        jlbSDT.setText("");

        jlbCMND.setText("");

        jlbEmail.setText("");

        jlbSoTienGui.setText("");

        jlbNgayGui.setText("");

        jlbLoaiTK.setText("");

        jlbLaiSuat.setText("");

        jlbNgayDenHan.setText("");



        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(41, 41, 41)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel11)
                                                                .addComponent(jLabel18)))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jLabel6)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jlbMaSo)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel19)
                                                        .addComponent(jLabel17)
                                                        .addComponent(jLabel16)
                                                        .addComponent(jLabel12))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jlbEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbCMND, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbTenKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbMaKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel13))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel14))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel9))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlbSoTienGui, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbNgayGui, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbLoaiTK, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbLaiSuat, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbNgayDenHan, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jlbMaSo))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel18)
                                                        .addComponent(jlbMaKH))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jlbTenKH))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jlbDiaChi))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel17)
                                                        .addComponent(jlbSDT))
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel19)
                                                        .addComponent(jlbCMND))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel16)
                                                        .addComponent(jlbEmail))
                                                .addGap(20, 20, 20))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jlbSoTienGui))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jlbNgayGui))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jlbLoaiTK))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jlbLaiSuat))
                                                .addGap(19, 19, 19)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jlbNgayDenHan))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Hồ sơ chi tiết");

        btnDuyet.setText("Duyệt");

        btnXoa.setText("Xoá");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)
                        .addComponent(jSeparator1)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(btnDuyet)
                                .addGap(145, 145, 145)
                                .addComponent(btnXoa)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(21, 21, 21)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnDuyet)
                                        .addComponent(btnXoa))
                                .addGap(23, 23, 23))
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this,msg);
    }

    public SoTietKiem getSelectedRow() {
        SoTietKiem soTietKiem = null;
        int row = tableDS.getSelectedRow();
        if (row >= 0) {
            int id = Integer.valueOf(tableDS.getModel().getValueAt(row,1).toString());
            soTietKiem = SoTietKiemDAO.laySTKID(id);
            btnDuyet.setEnabled(true);
            btnXoa.setEnabled(true);
        }
        return soTietKiem;
    }

    public void showTTSo(SoTietKiem soTietKiem){
        jlbMaSo.setText(String.valueOf(soTietKiem.getMaSo()));
        jlbMaKH.setText(String.valueOf(soTietKiem.getMaND().getMaNd()));
        jlbTenKH.setText(soTietKiem.getMaND().getTenNd());
        jlbDiaChi.setText(String.valueOf(soTietKiem.getMaND().getDiaChi()));
        jlbCMND.setText(soTietKiem.getMaND().getCmnd());
        jlbEmail.setText(String.valueOf(soTietKiem.getMaND().getEmail()));
        jlbSDT.setText(soTietKiem.getMaND().getSdt());

        jlbSoTienGui.setText(String.valueOf(soTietKiem.getSoTienGui()));
        jlbNgayGui.setText(soTietKiem.getNgayMoSo().toString());
        jlbNgayDenHan.setText(soTietKiem.getNgayDenHan().toString());
        jlbLoaiTK.setText(soTietKiem.getLoaiSo().getTenLoai());
        jlbLaiSuat.setText(String.valueOf(soTietKiem.getLoaiSo().getLaiSuat()));

    }

    public void showDS(List<SoTietKiem> list){
        Object[][]objects=new Object[list.size()][5];

        for (int i=0; i<list.size(); i++){
            objects[i][0] = i+1;
            objects[i][1] = list.get(i).getMaSo();
            objects[i][2] = list.get(i).getMaND().getMaNd();
            objects[i][3] = list.get(i).getLoaiSo().getTenLoai();
            objects[i][4] = list.get(i).getNgayMoSo();
        }

        tableDS.setModel(new javax.swing.table.DefaultTableModel(objects
                ,
                new String [] {
                        "STT", "Mã sổ", "Mã khách hàng", "Loại tiết kiệm", "Ngày mở"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }

    public String layMaTimKiem(){
        return txtTimKiem.getText();
    }


    public void getTimKiemListener(ActionListener listener){
        txtTimKiem.addActionListener(listener);
    }

    public void getTTSoListener(MouseListener listener){
        tableDS.addMouseListener(listener);
    }

    public void getDuyetListener(ActionListener listener){
        btnDuyet.addActionListener(listener);
    }

    public void getXoaListener(ActionListener listener){
        btnXoa.addActionListener(listener);
    }

    private javax.swing.JButton btnDuyet;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;

    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbCMND;
    private javax.swing.JLabel jlbDiaChi;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbLaiSuat;
    private javax.swing.JLabel jlbLoaiTK;
    private javax.swing.JLabel jlbMaKH;
    private javax.swing.JLabel jlbMaSo;
    private javax.swing.JLabel jlbNgayDenHan;
    private javax.swing.JLabel jlbNgayGui;
    private javax.swing.JLabel jlbSDT;
    private javax.swing.JLabel jlbSoTienGui;
    private javax.swing.JLabel jlbTenKH;

    private javax.swing.JTable tableDS;
    private javax.swing.JTextField txtTimKiem;


}
