/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daofactory;

import entity.Client;
import entity.Contract;
import entity.Service;
import entity.TarifPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class TarifPlanDAO implements ITarifDAO {


     private final String SQLIDTarif= "SELECT * FROM tarifplan WHERE nameTarif =:nameTarif";
          private final String SQLTarif= "SELECT * FROM tarifplan WHERE idTarif =:idTarif";

    @Override
  public boolean create(TarifPlan ob) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
     
        try {
            tx = session.beginTransaction();
            session.save(ob);
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
    public TarifPlan read(int key) throws SQLException {

        Session session = null;
        TarifPlan t = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            t = (TarifPlan) session.load(TarifPlan.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return t;
    }

    @Override
    public void update(TarifPlan ob) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            TarifPlan t = (TarifPlan) session.get(TarifPlan.class, ob.getIdTarif());
            session.update(t);
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
            List serv;
            serv = session.createCriteria(TarifPlan.class).list();
            for (Iterator iterator
                    = serv.iterator(); iterator.hasNext();) {
                TarifPlan c_s = (TarifPlan) iterator.next();
                if (c_s.getIdTarif() == key) {
                    session.delete(c_s);
                }
            }
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
    public List<TarifPlan> getInfo() throws SQLException {
        Session session = null;
        List tarif = new ArrayList<TarifPlan>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tarif = session.createCriteria(TarifPlan.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tarif;
    }

    @Override
    public TarifPlan getIdTarifPlan(String nameTarif) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        TarifPlan tar = null;
        Transaction tx = null;
                System.out.println(nameTarif);
        try {
            List serv;
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLIDTarif);
            query.addEntity(TarifPlan.class);
            query.setParameter("nameTarif", nameTarif);
            serv = query.list();
            tar = (TarifPlan) serv.get(0);
            System.out.println(tar);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return tar;
    }
    @Override
    public TarifPlan getTarifPlan(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        TarifPlan tar = null;
        Transaction tx = null;
                System.out.println(id);
        try {
            List serv;
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLTarif);
            query.addEntity(TarifPlan.class);
            query.setParameter("idTarif", id);
            serv = query.list();
            tar = (TarifPlan) serv.get(0);
            System.out.println(tar);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return tar;
    }
}
