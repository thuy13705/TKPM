
package ui;


import com.toedter.calendar.JDateChooser;
import model.pojo.BCNgay;
import model.pojo.LoaiSTK;
import model.pojo.PhieuGiaoDich;
import model.pojo.SoTietKiem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BaoCaoNgay extends javax.swing.JPanel implements ActionListener {
    public BaoCaoNgay() {
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnThongKe = new javax.swing.JButton();
        txtNgay = new JDateChooser();
        jlbNgay = new javax.swing.JLabel();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BÁO CÁO DOANH SỐ HOẠT ĐỘNG NGÀY");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jScrollPane1.setViewportView(jTable1);

        btnThongKe.setText("Thống kê");

        jlbNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNgay.setText("Ngày");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jlbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnThongKe)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlbNgay)
                                        .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnThongKe))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addContainerGap(63, Short.MAX_VALUE))
        );
    }

    public void showMessage(String msg){
        JOptionPane.showMessageDialog(null,msg);
    }

    public void showThongKe(List<BCNgay> list){
        Object[][] objects=new Object[list.size()][5];
        System.out.println(list.size());
        for (int i=0; i<list.size();i++){
            objects[i][0]=i+1;
            objects[i][1]=list.get(i).getTenLoai();
            objects[i][2]=list.get(i).getTongThu();
            objects[i][3]=list.get(i).getTongChi();
            objects[i][4]=list.get(i).getTongThu().subtract(list.get(i).getTongChi());
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel( objects,
                new String [] {
                        "STT", "Loại tiết kiệm", "Tổng thu", "Tổng chi", "Chênh lệch"
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

    public Date layNgay() throws ParseException {
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date date=dateFormat.parse(dateFormat.format(txtNgay.getDate()));
        Date now=dateFormat.parse(dateFormat.format(new Date()));
        if (now.before(date)){
            return null;
        }
        else
            return date;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void thongke(ActionListener listener){
        btnThongKe.addActionListener(listener);
    }

    private javax.swing.JButton btnThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlbNgay;
    private JDateChooser txtNgay;

}
