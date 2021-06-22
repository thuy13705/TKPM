package model.dao;

import model.pojo.NguoiDung;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class NguoiDungDAO {
    public static List<NguoiDung> layDSNguoiDung(){
        List<NguoiDung> ds=null;
        SessionFactory factory= HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        try {
            String hql = "from NguoiDung ";
            Query query = session.createQuery(hql);
            ds = (List<NguoiDung>) ((org.hibernate.query.Query<?>) query).list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public static NguoiDung layNguoiDungID(int id) {
        NguoiDung nguoiDung = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            nguoiDung = (NguoiDung) session.get(NguoiDung.class,
                    id);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return nguoiDung;
    }

    public static boolean ThemND(NguoiDung nguoiDung) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (NguoiDungDAO.layNguoiDungID(nguoiDung.getMaNd())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(nguoiDung);
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

    public static boolean xoaND(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        NguoiDung nguoiDung = NguoiDungDAO.layNguoiDungID(id);
        if(nguoiDung==null){
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(nguoiDung);
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

    public static boolean capNhatND(NguoiDung nguoiDung) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (NguoiDungDAO.layNguoiDungID(nguoiDung.getMaNd()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(nguoiDung);
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
