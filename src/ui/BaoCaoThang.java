
package ui;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import model.pojo.BCThang;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.YearMonth;
import java.util.List;

public class BaoCaoThang extends javax.swing.JPanel implements ActionListener{

    public BaoCaoThang() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jlbNgay = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtThang = new JMonthChooser();
        btnThongKe = new javax.swing.JButton();
        txtNam = new JYearChooser();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BÁO CÁO ĐÓNG - MỞ SỔ NGÀY");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jlbNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNgay.setText("Ngày");

        jScrollPane1.setViewportView(jTable1);


        btnThongKe.setText("Thống kê");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                        .addComponent(jSeparator1)
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(671, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThongKe)
                                .addGap(0, 0, Short.MAX_VALUE))

        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlbNgay)
                                        .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnThongKe)
                                        .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGap(75, 75, 75))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void showMessage(String msg){
        JOptionPane.showMessageDialog(null,msg);
    }
    public void showThongKe(List<BCThang> list){
        Object[][] objects=new Object[list.size()][7];
        System.out.println(list.size());
        for (int i=0; i<list.size();i++){
            objects[i][0]=i+1;
            objects[i][1]=list.get(i).getTenLoai();
            objects[i][2]=list.get(i).getTongThu();
            objects[i][3]=list.get(i).getTongChi();
            objects[i][4]=list.get(i).getSoMo();
            objects[i][5]=list.get(i).getSoDong();
            objects[i][6]=list.get(i).getTongThu().subtract(list.get(i).getTongChi());
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
              objects,
                new String [] {
                        "STT", "Loại tiết kiệm", "Tổng thu","Tổng chi","Tổng sổ mở", "Tổng sổ đóng", "Chênh lệch"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false,false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }

    public YearMonth layThangNam() throws ParseException {
        YearMonth now=YearMonth.now();
        YearMonth yearMonth=YearMonth.of(txtNam.getYear(),txtThang.getMonth()+1);
        System.out.println(now);
        System.out.println(yearMonth);

        if (now.isBefore(yearMonth)){
            return null;
        }
        else
            return yearMonth;
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
    private JYearChooser txtNam;
    private JMonthChooser txtThang;
    // End of variables declaration//GEN-END:variables
}
