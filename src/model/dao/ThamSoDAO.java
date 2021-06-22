package model.dao;

import model.pojo.BangThamSo;
import model.pojo.NguoiDung;
import model.pojo.SoTietKiem;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ThamSoDAO {
    public static List<BangThamSo> layDSThamSo(){
        List<BangThamSo> ds=null;
        SessionFactory factory= HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        try {
            String hql = "from BangThamSo ";
            Query query = session.createQuery(hql);
            ds = (List<BangThamSo>) ((org.hibernate.query.Query<?>) query).list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public static BangThamSo layThamSoID(int id) {
        BangThamSo bangThamSo = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            bangThamSo = (BangThamSo) session.get(BangThamSo.class,
                    id);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return bangThamSo;
    }

    public static boolean themThamSo(BangThamSo bangThamSo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ThamSoDAO.layThamSoID(bangThamSo.getMaThamSo())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(bangThamSo);
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

    public static boolean xoaThamSo(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        BangThamSo bangThamSo = ThamSoDAO.layThamSoID(id);
        if(bangThamSo==null){
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(bangThamSo);
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

    public static boolean capNhatThamSo(BangThamSo bangThamSo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ThamSoDAO.layThamSoID(bangThamSo.getMaThamSo()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(bangThamSo);
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
