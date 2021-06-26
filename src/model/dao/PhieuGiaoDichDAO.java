package model.dao;

import model.pojo.BCNgay;
import model.pojo.BCThang;
import model.pojo.LoaiSTK;
import model.pojo.PhieuGiaoDich;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhieuGiaoDichDAO {
    public static List<BCNgay> layDSPhieuGDNgay(Date date){
        List<BCNgay> ds=new ArrayList<>();
        SessionFactory factory= HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        try {
            List<LoaiSTK> loaiSTKS=LoaiSTKDAO.layDSLoaiSTK();
            for (int i=0; i<loaiSTKS.size();i++){
                BCNgay bcNgay=new BCNgay();
                bcNgay.setTenLoai(loaiSTKS.get(i).getTenLoai());
                String hql1 = "select sum(soTien) from PhieuGiaoDich where ngayGiaoDich=:date " +
                        "and maSo.loaiSo.loaiSo=:loaiSo and loaiPhieu=0";
                Query query1 = session.createQuery(hql1);
                query1.setParameter("date",date);
                query1.setParameter("loaiSo",loaiSTKS.get(i).getLoaiSo());
                BigDecimal object1 = (BigDecimal) ((org.hibernate.query.Query<?>) query1).uniqueResult();
                if (object1==null)
                    bcNgay.setTongThu(new BigDecimal(0));
                else
                    bcNgay.setTongThu(object1);

                String hql2 = "select sum(soTien) from PhieuGiaoDich where ngayGiaoDich=:date " +
                        "and maSo.loaiSo.loaiSo=:loaiSo and loaiPhieu=1";
                Query query2 = session.createQuery(hql2);
                query2.setParameter("date",date);
                query2.setParameter("loaiSo",loaiSTKS.get(i).getLoaiSo());
                BigDecimal object2 = (BigDecimal) ((org.hibernate.query.Query<?>) query2).uniqueResult();
                if (object2==null)
                    bcNgay.setTongChi(new BigDecimal(0));
                else
                    bcNgay.setTongChi(object2);

                ds.add(bcNgay);
            }
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public static List<BCThang> layDSPhieuGDThang(YearMonth yearMonth){
        List<BCThang> ds=new ArrayList<>();
        SessionFactory factory= HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        try {
            List<LoaiSTK> loaiSTKS=LoaiSTKDAO.layDSLoaiSTK();
            for (int i=0; i<loaiSTKS.size();i++){
                BCThang bcThang=new BCThang();
                bcThang.setTenLoai(loaiSTKS.get(i).getTenLoai());
                String hql1 = "select sum(soTien), count(maPhieu) from PhieuGiaoDich where Month(ngayGiaoDich)=:month and Year(ngayGiaoDich)=:year " +
                        "and maSo.loaiSo.loaiSo=:loaiSo and loaiPhieu=0";
                Query query1 = session.createQuery(hql1);
                query1.setParameter("month",yearMonth.getMonthValue());
                query1.setParameter("year",yearMonth.getYear());
                query1.setParameter("loaiSo",loaiSTKS.get(i).getLoaiSo());
                Object[] object1 = (Object[]) ((org.hibernate.query.Query<?>) query1).uniqueResult();
                if (object1!=null){
                    if (object1[0]==null){
                        bcThang.setTongThu(new BigDecimal(0));
                    }
                    else
                        bcThang.setTongThu((BigDecimal)object1[0]);
                    bcThang.setSoMo(Math.toIntExact((long) object1[1]));
                }
                else{
                    bcThang.setTongThu(new BigDecimal(0));
                    bcThang.setSoMo(0);
                }

                String hql2 = "select sum(soTien), count(maPhieu) from PhieuGiaoDich where Month(ngayGiaoDich)=:month and Year(ngayGiaoDich)=:year " +
                        "and maSo.loaiSo.loaiSo=:loaiSo and loaiPhieu=1";
                Query query2 = session.createQuery(hql2);
                query2.setParameter("month",yearMonth.getMonthValue());
                query2.setParameter("year",yearMonth.getYear());
                query2.setParameter("loaiSo",loaiSTKS.get(i).getLoaiSo());
                Object[] object2 = (Object[]) ((org.hibernate.query.Query<?>) query2).uniqueResult();
                if (object2!=null){
                    if (object2[0]==null){
                        bcThang.setTongChi(new BigDecimal(0));
                    }
                    else
                        bcThang.setTongChi((BigDecimal)object2[0]);
                    bcThang.setSoDong(Math.toIntExact((long) object2[1]));
                }
                else{
                    bcThang.setTongChi(new BigDecimal(0));
                    bcThang.setSoDong(0);
                }
                ds.add(bcThang);
            }
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public static PhieuGiaoDich layPhieuGDID(int id) {
        PhieuGiaoDich phieuGiaoDich = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            phieuGiaoDich = (PhieuGiaoDich) session.get(PhieuGiaoDich.class,
                    id);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return phieuGiaoDich;
    }

    public static boolean themPhieu(PhieuGiaoDich phieuGiaoDich) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (PhieuGiaoDichDAO.layPhieuGDID(phieuGiaoDich.getMaPhieu())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(phieuGiaoDich);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }

    public static boolean xoaPhieuGD(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        PhieuGiaoDich phieuGiaoDich = PhieuGiaoDichDAO.layPhieuGDID(id);
        if(phieuGiaoDich==null){
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(phieuGiaoDich);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }

    public static boolean capNhatPhieu(PhieuGiaoDich phieuGiaoDich) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (PhieuGiaoDichDAO.layPhieuGDID(phieuGiaoDich.getMaPhieu()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(phieuGiaoDich);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}
