/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daofactory;

import entity.Client;
import entity.Contract;
import entity.Pays;
import entity.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Dasha-RV515
 */
public class PaysDAO implements IPaysDAO {


     private final String SQLPays= "SELECT * FROM pays WHERE numPersAccount =:numPersAccount";
     private final  String SQLIDPays = "SELECT * FROM pays WHERE numPersAccount =:numPersAccount ";
    
    @Override
    public boolean create(Pays pays) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer numPay = null;
        try {
            tx = session.beginTransaction();
            Pays p = new Pays();
            p.setNumPays(pays.getNumPays());
            p.setSumPay(pays.getSumPay());
            p.setDatePay(pays.getDatePay());
            p.setClient(pays.getClient());
            p.setPersonalAccount(pays.getPersonalAccount());
            numPay = (Integer) session.save(pays);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public int checkPays(Pays pays) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List data = null;
        Pays p = null;
        int key = 0;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLPays);
            query.addEntity(Pays.class);
            query.setParameter("numPersAccount", pays.getPersonalAccount().getNumPersAccount());
            data = query.list();
            p = (Pays) data.get(0);
            System.out.println(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return p.getNumPays();
    }

    @Override
    public Pays read(int key) throws SQLException {
        Session session = null;
        Pays pay = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            pay = (Pays) session.load(Pays.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return pay;
    }

    @Override
    public void update(Pays pays) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Pays p = (Pays) session.get(Pays.class, pays.getNumPays());
            p.setSumPay(pays.getSumPay());
            p.setDatePay(pays.getDatePay());
            p.setClient(pays.getClient());
            p.setPersonalAccount(pays.getPersonalAccount());
            session.update(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(int key) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Pays pay
                    = (Pays) session.get(Pays.class, key);
            session.delete(pay);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Pays> getInfo() throws SQLException {
        Session session = null;
        List pay = new ArrayList<Pays>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            pay = session.createCriteria(Pays.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return pay;
    }

    @Override
    public Pays getIdPays(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Pays pay = null;
        Transaction tx = null;
        try {
            List serv;
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLIDPays);
            query.addEntity(Pays.class);
            query.setParameter("numPersAccount", id);
            serv = query.list();
            pay = (Pays) serv.get(0);
            System.out.println(pay);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pay;

    }

    @Override
    public List<Pays> getPaysList(int id) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Pays pay = null;
        Transaction tx = null;List<Pays> serv=new ArrayList();
        try {
            
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLIDPays);
            query.addEntity(Pays.class);
            query.setParameter("numPersAccount", id);
            serv = query.list();
            //pay = (Pays) serv.get(0);
            //System.out.println(pay);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return serv; 
    }

}
