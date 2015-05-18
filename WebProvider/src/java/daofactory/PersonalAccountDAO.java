/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daofactory;

import entity.Client;
import entity.Contract;
import entity.Pays;
import entity.PersonalAccount;
import entity.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class PersonalAccountDAO implements IPersonalAccountDAO {

     private final String  SQLIdPersonalAccount= "SELECT * FROM personalaccount WHERE numPersAccount =:numPersAccount ";

    @Override
    public int create(PersonalAccount ob) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer numPersAccount = null;
        try {
            tx = session.beginTransaction();
            PersonalAccount p = new PersonalAccount();
            p.setNumPersAccount(ob.getNumPersAccount());

            p.setStatusPersAccount(ob.getStatusPersAccount());
            numPersAccount = (Integer) session.save(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return numPersAccount;
    }

    @Override
    public PersonalAccount read(int key) throws SQLException {

        Session session = null;
        PersonalAccount p = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            p = (PersonalAccount) session.load(PersonalAccount.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return p;
    }

    @Override
    public void update(PersonalAccount ob) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            PersonalAccount p = (PersonalAccount) session.get(PersonalAccount.class, ob.getNumPersAccount());
  System.out.println(ob);
  p.setSumPersAccount(ob.getSumPersAccount());
            p.setStatusPersAccount(ob.getStatusPersAccount());
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
            PersonalAccount p
                    = (PersonalAccount) session.get(PersonalAccount.class, key);
            session.delete(p);
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
    public List<PersonalAccount> getInfo() throws SQLException {

        Session session = null;
        List p = new ArrayList<PersonalAccount>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            p = session.createCriteria(PersonalAccount.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return p;
    }

   
    @Override
    public PersonalAccount getIdPersonalAccount(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        PersonalAccount pay = null;
        Transaction tx = null;
        try {
            List serv;
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLIdPersonalAccount);
            query.addEntity(PersonalAccount.class);
            query.setParameter("numPersAccount", id);
            serv = query.list();
            if(serv.isEmpty()){
                pay=null;
            }
            else{
            pay = (PersonalAccount) serv.get(0);
            System.out.println(pay);
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
        return pay;

    }

}
