package model.dao;

import model.pojo.LoaiSTK;
import model.pojo.SoTietKiem;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class LoaiSTKDAO {
    public static List<LoaiSTK> layDSLoaiSTK(){
        List<LoaiSTK> ds=null;
        SessionFactory factory= HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        try {
            String hql = "from LoaiSTK ";
            Query query = session.createQuery(hql);
            ds = (List<LoaiSTK>) ((org.hibernate.query.Query<?>) query).list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public static LoaiSTK laySTKID(int id) {
        LoaiSTK loaiSTK = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            loaiSTK = (LoaiSTK) session.get(LoaiSTK.class,
                    id);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return loaiSTK;
    }

    public static boolean themLoaiSTK(LoaiSTK loaiSTK) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (LoaiSTKDAO.laySTKID(loaiSTK.getLoaiSo())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(loaiSTK);
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

    public static boolean xoaLoaiSTK(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        LoaiSTK loaiSTK = LoaiSTKDAO.laySTKID(id);
        if(loaiSTK==null){
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(loaiSTK);
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

    public static boolean capNhatLoai(LoaiSTK loaiSTK) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (LoaiSTKDAO.laySTKID(loaiSTK.getLoaiSo()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(loaiSTK);
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
