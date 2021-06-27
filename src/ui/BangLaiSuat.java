/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import model.dao.LoaiSTKDAO;
import model.pojo.BangThamSo;
import model.pojo.LoaiSTK;
import net.bytebuddy.implementation.LoadedTypeInitializer;

import java.util.List;

/**
 *
 * @author thupham
 */
public class BangLaiSuat extends javax.swing.JPanel {

    /**
     * Creates new form BangLaiSuat
     */
    public BangLaiSuat() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableLS = new javax.swing.JTable();
        labelLS = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtQD = new javax.swing.JTextArea();
        labelQD = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        tableLS.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(tableLS);

        labelLS.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        labelLS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLS.setText("Lãi suất tiết kiệm");

        txtQD.setColumns(20);
        txtQD.setRows(5);
        jScrollPane2.setViewportView(txtQD);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        labelQD.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        labelQD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelQD.setText("Quy định");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelLS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(73, Short.MAX_VALUE))
                        .addComponent(jSeparator1)
                        .addComponent(labelQD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(labelLS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(labelQD)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
        );
        txtQD.setEditable(false);
        txtQD.setText("");
    }// </editor-fold>//GEN-END:initComponents
    

    public void showBangLaiSuat(List<LoaiSTK> list){
        Object[][]objects=new Object[list.size()][4];

        for (int i=0; i<list.size();i++){
            objects[i][0]=i+1;
            objects[i][1]=list.get(i).getTenLoai();
            objects[i][2]=list.get(i).getThoiHan();
            objects[i][3]=list.get(i).getLaiSuat();
        }

        tableLS.setModel(new javax.swing.table.DefaultTableModel(objects
                ,
                new String [] {
                        "STT", "Loại sổ tiết kiệm", "Thời hạn","Lãi suất"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }

    public void showQuyDinh(List<BangThamSo> list){
       for (int i=0; i<list.size(); i++){
           txtQD.append(list.get(i).getTenThamSo()+": "+list.get(i).getGiaTri());
           txtQD.append("\n\n");
       }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelLS;
    private javax.swing.JLabel labelQD;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableLS;
    private javax.swing.JTextArea txtQD;
}
