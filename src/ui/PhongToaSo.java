package ui;


import model.dao.SoTietKiemDAO;
import model.pojo.SoTietKiem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class PhongToaSo extends javax.swing.JPanel implements ActionListener {
    private JFrame jFrame;

    public PhongToaSo(JFrame jFrame) {
        this.jFrame = jFrame;
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnPhongToa = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách sổ tiết kiệm");

        jScrollPane1.setViewportView(jTable1);

        btnPhongToa.setText("Phong toả");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPhongToa)
                                .addContainerGap())
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnPhongToa)
                                .addContainerGap(141, Short.MAX_VALUE))
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this,msg);
    }

    public List<Integer> getSelectedRow() {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<jTable1.getRowCount(); i++){
            if(jTable1.getValueAt(i, 5).equals(true)){
                list.add((Integer) jTable1.getValueAt(i, 1));
            }
        }
        if(list != null){
            btnPhongToa.setEnabled(true);
        }
        return list;
    }

    public void showDS(List<SoTietKiem> list){
        Object[][]objects=new Object[list.size()][6];
        for (int i=0; i<list.size(); i++){
            objects[i][0] = i+1;
            objects[i][1] = list.get(i).getMaSo();
            objects[i][2] = list.get(i).getMaND().getMaNd();
            objects[i][3] = list.get(i).getLoaiSo().getTenLoai();
            objects[i][4] = list.get(i).getNgayMoSo();
            objects[i][5] = false;
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(objects
                ,
                new String [] {
                        "STT", "Mã sổ", "Mã khách hàng", "Loại tiết kiệm", "Ngày mở", "Phong toả"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }


    public void getPhongToaListener(ActionListener listener){
        btnPhongToa.addActionListener(listener);
    }



    private javax.swing.JButton btnPhongToa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;


}
