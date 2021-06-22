package model.dao;

import model.pojo.NguoiDung;
import model.pojo.SoTietKiem;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class SoTietKiemDAO {
    public static List<SoTietKiem> layDSSTK(){
        List<SoTietKiem> ds=null;
        SessionFactory factory= HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        try {
            String hql = "from SoTietKiem ";
            Query query = session.createQuery(hql);
            ds = (List<SoTietKiem>) ((org.hibernate.query.Query<?>) query).list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public static List<SoTietKiem> layDSSTK(NguoiDung nguoiDung){
        List<SoTietKiem> ds=null;
        SessionFactory factory= HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        try {
            String hql = "from SoTietKiem where maND=:nguoiDung";
            Query query = session.createQuery(hql);
            query.setParameter("nguoiDung",nguoiDung);
            ds = (List<SoTietKiem>) ((org.hibernate.query.Query<?>) query).list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public static SoTietKiem laySTKID(int id) {
        SoTietKiem soTietKiem = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            soTietKiem = (SoTietKiem) session.get(SoTietKiem.class,
                    id);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return soTietKiem;
    }

    public static boolean themSTK(SoTietKiem soTietKiem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SoTietKiemDAO.laySTKID(soTietKiem.getMaSo())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(soTietKiem);
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

    public static boolean xoaSTK(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        SoTietKiem soTietKiem = SoTietKiemDAO.laySTKID(id);
        if(soTietKiem==null){
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(soTietKiem);
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

    public static boolean capNhatSTK(SoTietKiem soTietKiem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SoTietKiemDAO.laySTKID(soTietKiem.getMaSo()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(soTietKiem);
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