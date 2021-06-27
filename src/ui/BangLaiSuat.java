/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import model.dao.LoaiSTKDAO;
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

        labelLS = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLS = new javax.swing.JTable();
        labelQD = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQD = new javax.swing.JTextArea();

        labelLS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelLS.setText("Lãi suất tiết kiệm");

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
        jScrollPane2.setViewportView(tableLS);

        labelQD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelQD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelQD.setText("Quy định");

        txtQD.setColumns(20);
        txtQD.setRows(5);
        jScrollPane1.setViewportView(txtQD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(labelLS)
                                                .addGap(0, 140, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(labelQD)
                                .addGap(173, 173, 173))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelLS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                                .addComponent(labelQD)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(172, Short.MAX_VALUE)))
        );
        txtQD.setEditable(false);
    }// </editor-fold>                        

             

    public void showBangLaiSuat(List<LoaiSTK> list){
        Object[][]objects=new Object[list.size()][3];

        for (int i=0; i<list.size();i++){
            objects[i][0]=i+1;
            objects[i][1]=list.get(i).getTenLoai();
            objects[i][2]=list.get(i).getLaiSuat();
        }

        tableLS.setModel(new javax.swing.table.DefaultTableModel(objects
                ,
                new String [] {
                        "STT", "Loại sổ tiết kiệm", "Lãi suất"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel labelLS;
    private javax.swing.JLabel labelQD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableLS;
    private javax.swing.JTextArea txtQD;
    // End of variables declaration      
    // End of variables declaration
}
