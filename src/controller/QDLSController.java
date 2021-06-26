package controller;

import model.dao.LoaiSTKDAO;

import model.dao.ThamSoDAO;
import model.pojo.BangThamSo;
import model.pojo.LoaiSTK;
import ui.QuyDinhLaiSuat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QDLSController { 
    QuyDinhLaiSuat quyDinhLaiSuat;

    public QDLSController(QuyDinhLaiSuat quyDinhLaiSuat) {
        this.quyDinhLaiSuat=quyDinhLaiSuat;
        List<LoaiSTK> stks= LoaiSTKDAO.layDSLoaiSTK();
        quyDinhLaiSuat.showBangLaiSuat(stks);
        List<BangThamSo> bangThamSos= ThamSoDAO.layDSThamSo();
        quyDinhLaiSuat.showQuiDinh(bangThamSos);
        quyDinhLaiSuat.themLSListener(new themLSListener());
        quyDinhLaiSuat.suaLSListener(new suaLSListener());
        quyDinhLaiSuat.khoaLSListener(new khoaLSListener());
        
        quyDinhLaiSuat.themQDListener(new themQDListener());
        quyDinhLaiSuat.suaQDListener(new suaQDListener());
        quyDinhLaiSuat.khoaQDListener(new khoaQDListener());
    }

    class themLSListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LoaiSTK loaiSTK=quyDinhLaiSuat.themLaiSuat();
            if (loaiSTK!=null){
                boolean check=LoaiSTKDAO.themLoaiSTK(loaiSTK);
                if (check==true){
                    List<LoaiSTK> list=LoaiSTKDAO.layDSLoaiSTK();
                    quyDinhLaiSuat.showBangLaiSuat(list);
                    quyDinhLaiSuat.showMessage("Thêm thành công.");
                }
                else
                    quyDinhLaiSuat.showMessage("Thêm thất bại");
            }
            else
                quyDinhLaiSuat.showMessage("Loại LS không tồn tại.");
        }
    }

    class suaLSListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LoaiSTK loaiSTK=quyDinhLaiSuat.layLS();
            if (loaiSTK!=null){
                loaiSTK=quyDinhLaiSuat.suaLaiSuat(loaiSTK);
                boolean check=LoaiSTKDAO.capNhatLoai(loaiSTK);
                if (check==true){
                    List<LoaiSTK> list=LoaiSTKDAO.layDSLoaiSTK();
                    quyDinhLaiSuat.showBangLaiSuat(list);
                    quyDinhLaiSuat.showMessage("Cập nhật thành công.");
                }
                else
                    quyDinhLaiSuat.showMessage("Cập nhật thất bại");
            }
            else
                quyDinhLaiSuat.showMessage("Loại LS không tồn tại.");
        }
    }

    class khoaLSListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LoaiSTK loaiSTK=quyDinhLaiSuat.layLS();
            if (loaiSTK!=null){
                int kq=quyDinhLaiSuat.khoaLS();
                if (kq==0){
                    if (loaiSTK.getTinhTrang()==0)
                        loaiSTK.setTinhTrang(1);
                    else
                        loaiSTK.setTinhTrang(0);
                    boolean check=LoaiSTKDAO.capNhatLoai(loaiSTK);
                    if (check==true){
                        List<LoaiSTK> list=LoaiSTKDAO.layDSLoaiSTK();
                        quyDinhLaiSuat.showBangLaiSuat(list);
                        quyDinhLaiSuat.showMessage("Khoá/mở khoá thành công.");
                    }
                    else
                        quyDinhLaiSuat.showMessage("Khoá/mở khoá thất bại thất bại");
                }
            }
            else
                quyDinhLaiSuat.showMessage("Loại LS không tồn tại.");
        }
    }

    class themQDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            BangThamSo bangThamSo=quyDinhLaiSuat.themQD();
            if (bangThamSo!=null){
                boolean check= ThamSoDAO.themThamSo(bangThamSo);
                if (check==true){
                    List<BangThamSo> list=ThamSoDAO.layDSThamSo();
                    quyDinhLaiSuat.showQuiDinh(list);
                    quyDinhLaiSuat.showMessage("Thêm thành công.");
                }
                else
                    quyDinhLaiSuat.showMessage("Thêm thất bại");
            }
            else
                quyDinhLaiSuat.showMessage("Quy định không tồn tại.");
        }
    }

    class suaQDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            BangThamSo bangThamSo=quyDinhLaiSuat.layQD();
            if (bangThamSo!=null){
                bangThamSo=quyDinhLaiSuat.suaQD(bangThamSo);
                boolean check=ThamSoDAO.capNhatThamSo(bangThamSo);
                if (check==true){
                    List<BangThamSo> list=ThamSoDAO.layDSThamSo();
                    quyDinhLaiSuat.showQuiDinh(list);
                    quyDinhLaiSuat.showMessage("Cập nhật thành công.");
                }
                else
                    quyDinhLaiSuat.showMessage("Cập nhật thất bại");
            }
            else
                quyDinhLaiSuat.showMessage("Quy định không tồn tại.");
        }
    }

    class khoaQDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            BangThamSo bangThamSo=quyDinhLaiSuat.layQD();
            if (bangThamSo!=null){
                int kq=quyDinhLaiSuat.khoaQD();
                if (kq==0){
                    if (bangThamSo.getTinhTrang()==true)
                        bangThamSo.setTinhTrang(false);
                    else
                        bangThamSo.setTinhTrang(true);
                    boolean check=ThamSoDAO.capNhatThamSo(bangThamSo);
                    if (check==true){
                        List<BangThamSo> list=ThamSoDAO.layDSThamSo();
                        quyDinhLaiSuat.showQuiDinh(list);
                        quyDinhLaiSuat.showMessage("Khoá/mở khoá thành công.");
                    }
                    else
                        quyDinhLaiSuat.showMessage("Khoá/mở khoá thất bại thất bại");
                }
            }
            else
                quyDinhLaiSuat.showMessage("Quy định không tồn tại.");
        }
    }
}
