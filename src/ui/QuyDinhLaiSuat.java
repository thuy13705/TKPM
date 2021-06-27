
package ui;

import model.dao.LoaiSTKDAO;
import model.dao.NguoiDungDAO;
import model.dao.ThamSoDAO;
import model.pojo.BangThamSo;
import model.pojo.LoaiSTK;
import model.pojo.NguoiDung;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QuyDinhLaiSuat extends javax.swing.JPanel implements ActionListener, ListSelectionListener {

    /**
     * Creates new form ThongBao
     */
    public QuyDinhLaiSuat() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableQD = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnKhoaQD = new javax.swing.JButton();
        btnThemLai = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLS = new javax.swing.JTable();
        btnSuaQD = new javax.swing.JButton();
        btnThemQD = new javax.swing.JButton();
        btnKhoa = new javax.swing.JButton();
        btnSuaLai = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quy định");


        jScrollPane1.setViewportView(tableQD);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bảng lãi suất");

        btnKhoaQD.setText("Khoá/Mở khoá");

        btnThemLai.setText("Thêm");

        jScrollPane2.setViewportView(tableLS);

        btnSuaQD.setText("Sửa");

        btnThemQD.setText("Thêm");

        btnKhoa.setText("Khoá/Mở khoá");

        btnSuaLai.setText("Sửa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(128, 128, 128)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(139, 139, 139))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(152, 152, 152)
                                                        .addComponent(btnKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(88, 88, 88)
                                                        .addComponent(btnThemLai, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(74, 74, 74)
                                                        .addComponent(btnSuaLai, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(154, 154, 154)
                                                        .addComponent(btnKhoaQD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(84, 84, 84)
                                                        .addComponent(btnSuaQD)
                                                        .addGap(72, 72, 72)
                                                        .addComponent(btnThemQD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(164, 164, 164)))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThemQD)
                                        .addComponent(btnSuaQD)
                                        .addComponent(btnKhoaQD))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThemLai)
                                        .addComponent(btnSuaLai)
                                        .addComponent(btnKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    public LoaiSTK layLS() {
        LoaiSTK loaiSTK=null;
        int row = tableLS.getSelectedRow();
        if (row >= 0) {
            int id=Integer.valueOf(tableLS.getModel().getValueAt(row,1).toString());
            loaiSTK= LoaiSTKDAO.laySTKID(id);
        }
        return loaiSTK;
    }

    public BangThamSo layQD() {
        BangThamSo bangThamSo=null;
        int row = tableQD.getSelectedRow();
        if (row >= 0) {
            int id=Integer.valueOf(tableQD.getModel().getValueAt(row,1).toString());
            bangThamSo= ThamSoDAO.layThamSoID(id);
        }
        return bangThamSo;
    }

    public void showMessage(String msg){
        JOptionPane.showMessageDialog(null,msg);
    }

    public void showQuiDinh(List<BangThamSo> list){

        Object[][]objects=new Object[list.size()][4];
        for (int i=0;i<list.size(); i++){
            objects[i][0]=i+1;
            objects[i][1]=list.get(i).getMaThamSo();
            objects[i][2]=list.get(i).getTenThamSo()+": "+ list.get(i).getGiaTri();
            if (list.get(i).getTinhTrang()==true)
                objects[i][3]="Hoạt động";
            else
                objects[i][3]="Bị Khoá";
        }
        tableQD.setModel(new javax.swing.table.DefaultTableModel(
                objects,
                new String [] {
                        "STT","Mã QĐ", "Nội dung","Tình trạng"
                }
        ));
    }

    public BangThamSo suaQD(BangThamSo bangThamSo){

        JTextArea txtGiaTri=new JTextArea();
        txtGiaTri.setText(bangThamSo.getGiaTri());

        Object[] inputFields = {"Nội dung", txtGiaTri};

        int option = JOptionPane.showConfirmDialog(null, inputFields, "Sửa nội dung quy định", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            if (!txtGiaTri.getText().equals("") ){
                bangThamSo.setGiaTri(txtGiaTri.getText());
            }
            else
                showMessage("Nội dung không được trống.");
        }
        return bangThamSo;
    }

    public BangThamSo themQD(){
        BangThamSo bangThamSo=null;
        JTextField txtTen=new JTextField();
        JTextField txtGiaTri=new JTextField();

        Object[] inputFields = {"Tên", txtTen,"Nội dung", txtGiaTri};

        int option = JOptionPane.showConfirmDialog(null, inputFields, "Thêm quy định", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            if (!txtGiaTri.getText().equals("") && !txtTen.getText().equals("")){
                bangThamSo=new BangThamSo(txtTen.getText(),"",txtGiaTri.getText(),true);
            }
            else
                showMessage("Tên/Nội dung không được trống.");
        }
        return bangThamSo;
    }

    public int khoaQD(){
        String[] options = {"Chắc chắn", "Huỷ"};
        int kq = JOptionPane.showOptionDialog(null, "Bạn có chắn chắc muốn khoá/mở khoá quy định này?",
                "Nhấn vào lựa chọn của bạn", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        return kq;
    }

    private boolean isValidateTen(String ten){
        if (ten.equals("")){
            showMessage("Tên không được trống");
            return false;
        }
        return true;
    }

    private boolean isValidateTH(String th){
        if(th == null || th.equals("")) {
            showMessage("Thời hạn loại sổ tiết kiệm không được rỗng");
            return false;
        }
        else {
            if (th.length()==1 || th.length()==2){
                try {
                    int aLong = Integer.parseInt(th);
                    return true;
                } catch (NumberFormatException e) {
                    showMessage("Thời hạn loại sổ tiết kiệm chỉ chứa số.");
                }
            }
            else{
                showMessage("Thời hạn loại sổ tiết kiệm chỉ chứa 1 hoặc 2 số");
            }
        }
        return false;
    }

    private boolean isValidateLS(String ls){
        if(ls == null || ls.equals("")) {
            showMessage("Lãi suất không được rỗng");
            return false;
        }
        else {
            if (ls.indexOf(".")==1 || ls.indexOf(".")==2){
                try {
                    Double so = Double.parseDouble(ls);
                    return true;
                } catch (NumberFormatException e) {
                    showMessage("Nhập Lãi suất chưa chính xác");
                }
            }
            else{
                showMessage("Nhập Lãi suất chưa chính xác");
            }
        }
        return false;
    }


    public void showBangLaiSuat(List<LoaiSTK> list){
        Object[][]objects=new Object[list.size()][6];

        for (int i=0; i<list.size();i++){
            objects[i][0]=i+1;
            objects[i][1]=list.get(i).getLoaiSo();
            objects[i][2]=list.get(i).getThoiHan();
            objects[i][3]=list.get(i).getTenLoai();
            objects[i][4]=list.get(i).getLaiSuat();
            if (list.get(i).getTinhTrang()==0)
                objects[i][5]="Hoạt động";
            else
                objects[i][5]="Bị Khoá";
        }

        tableLS.setModel(new javax.swing.table.DefaultTableModel(objects
                ,
                new String [] {
                        "STT","Mã loại sổ","Thời hạn", "Tên loại sổ tiết kiệm", "Lãi suất","Tình Trạng"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false,false,false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }

    public LoaiSTK suaLaiSuat(LoaiSTK loaiSTK){
        JTextField txtLaiSuat=new JTextField();
        txtLaiSuat.setText(String.valueOf(loaiSTK.getLaiSuat()));

        Object[] inputFields = {"Lãi suất", txtLaiSuat};

        int option = JOptionPane.showConfirmDialog(null, inputFields, "Sửa lãi suất tiết kiệm", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            if (isValidateLS(txtLaiSuat.getText()) ){
                loaiSTK.setLaiSuat(Double.parseDouble(txtLaiSuat.getText()));
            }
            else
                return null;
        }
        return loaiSTK;
    }

    public LoaiSTK themLaiSuat(){
        LoaiSTK loaiSTK=null;
        JTextField txtLaiSuat=new JTextField();
        JTextField txtThoiHan=new JTextField();
        JTextField txtTen=new JTextField();

        Object[] inputFields = {"Thời hạn", txtThoiHan,"Tên Loại", txtTen,"Lãi suất", txtLaiSuat};

        int option = JOptionPane.showConfirmDialog(null, inputFields, "Thêm lãi suất tiết kiệm", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            if (isValidateTen(txtTen.getText()) && isValidateLS(txtLaiSuat.getText()) && isValidateTH(txtThoiHan.getText()) ){
                loaiSTK=new LoaiSTK(Integer.valueOf(txtThoiHan.getText()),txtTen.getText(),Double.parseDouble(txtLaiSuat.getText()),0);
            }
            else
                return null;
        }
        return loaiSTK;
    }

    public int khoaLS(){
        String[] options = {"Chắc chắn", "Huỷ"};
        int kq = JOptionPane.showOptionDialog(null, "Bạn có chắn chắc muốn khoá/mở khoá loại lãi suất này?",
                "Nhấn vào lựa chọn của bạn", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        return kq;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    public void themLSListener(ActionListener listener) {
        btnThemLai.addActionListener(listener);
    }

    public void suaLSListener(ActionListener listener) {
        btnSuaLai.addActionListener(listener);
    }

    public void khoaLSListener(ActionListener listener) {
        btnKhoa.addActionListener(listener);
    }

    public void themQDListener(ActionListener listener) {
        btnThemQD.addActionListener(listener);
    }

    public void suaQDListener(ActionListener listener) {
        btnSuaQD.addActionListener(listener);
    }

    public void khoaQDListener(ActionListener listener) {
        btnKhoaQD.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKhoaQD;
    private javax.swing.JButton btnThemLai;
    private javax.swing.JButton btnSuaQD;
    private javax.swing.JButton btnThemQD;
    private javax.swing.JButton btnKhoa;
    private javax.swing.JButton btnSuaLai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableQD;
    private javax.swing.JTable tableLS;

}
