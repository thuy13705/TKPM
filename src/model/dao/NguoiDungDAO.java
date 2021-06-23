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

    public static NguoiDung layNguoiDungUser(String user) {
        NguoiDung nguoiDung = null;
        List<NguoiDung> ds=null;
        SessionFactory factory= HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        try {
            String hql = "from NguoiDung where username=:user";
            Query query = session.createQuery(hql);
            query.setParameter("user",user);
            ds = (List<NguoiDung>) ((org.hibernate.query.Query<?>) query).list();
            if (ds.size()!=0)
                nguoiDung=ds.get(0);
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

    public static int layMaxID() {
        int max = 0;
        List<NguoiDung> list1 = null;
        SessionFactory factory= HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        try {
            String hql = "select max(nd.maNd) from NguoiDung nd";
            Query query = session.createQuery(hql);
            Object objects = (Object) ((org.hibernate.query.Query<?>) query).uniqueResult();
            max = (int) objects;

        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }

        return max;
    }
}
