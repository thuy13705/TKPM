package model.dao;

import model.pojo.LoaiSTK;
import model.pojo.PhieuGiaoDich;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class PhieuGiaoDichDAO {
    public static List<PhieuGiaoDich> layDSPhieuGD(){
        List<PhieuGiaoDich> ds=null;
        SessionFactory factory= HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        try {
            String hql = "from PhieuGiaoDich ";
            Query query = session.createQuery(hql);
            ds = (List<PhieuGiaoDich>) ((org.hibernate.query.Query<?>) query).list();
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
