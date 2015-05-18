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
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Dasha-RV515
 */
public class ServiceDAO implements IServiceDAO {

    private final String SQLIDService = "SELECT * FROM  service WHERE descripService = :descripService";

    @Override
    public boolean create(Service ob) throws SQLException {
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
    public Service read(int key) throws SQLException {

        Session session = null;
        Service s = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            s = (Service) session.load(Service.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return s;
    }

    @Override
    public void update(Service ob) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Service s = (Service) session.get(Service.class, ob.getIdSevice());
            s.setDescripService(ob.getDescripService());
            s.setPriceService(ob.getPriceService());
            s.setNote(ob.getNote());
            session.update(s);
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
            serv = session.createCriteria(Service.class).list();
            for (Iterator iterator
                    = serv.iterator(); iterator.hasNext();) {
                Service s = (Service) iterator.next();
                if (s.getIdSevice() == key) {
                    session.delete(s);
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
    public List<Service> getInfo() throws SQLException {

        Session session = null;
        List s = new ArrayList<Service>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            s = session.createCriteria(Service.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return s;
    }

    @Override
    public Service getIdService(String descripService) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Service service = null;
        Transaction tx = null;
        try {
            List serv;
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLIDService);
            query.addEntity(Service.class);
            query.setParameter("descripService", descripService);
            serv = query.list();
            service = (Service) serv.get(0);
            System.out.println(service);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return service;
    }

}
