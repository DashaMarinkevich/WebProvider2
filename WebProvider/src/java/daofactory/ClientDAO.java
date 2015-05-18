/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daofactory;

import entity.Client;
import entity.Contract;

import entity.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Dasha-RV515
 */
public class ClientDAO implements IClientDAO {
    private final String SQLClient="SELECT * FROM client WHERE login =:login ";
    private final String SQLClientPassword="SELECT * FROM client WHERE password =:password ";
    private final String SQLID="SELECT * FROM client WHERE idClient =:idClient ";
    private final String SQLLogin="SELECT * FROM client WHERE login =:login AND password =:password";

    public boolean create(Client client) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer idClient = null;
        try {
            tx = session.beginTransaction();
            session.save(client);
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
    public int checkLogin(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List data = null;
        Client cl = null;
        int key = 0;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLLogin);
            query.addEntity(Client.class);
            query.setParameter("login", client.getLogin());
            query.setParameter("password", client.getPassword());
            data = query.list();
            if(data.isEmpty()){
                cl=null;
            }
            else{
            cl = (Client) data.get(0);
            System.out.println(cl);
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
if(cl==null){
    return 0;
}
else{
        return cl.getIdClient();
}
    }

    @Override
    public Client read(int key) throws SQLException {

        Session session = null;
        Client client = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            client = (Client) session.load(Client.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return client;
    }

    @Override
    public void update(Client client) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Client cl = (Client) session.get(Client.class, client.getIdClient());
            session.update(cl);
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
            Client client
                    = (Client) session.get(Client.class, key);
            session.delete(client);
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
    public List<Client> getInfo() throws SQLException {

        Session session = null;
        List client = new ArrayList<Client>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            client = session.createQuery("FROM Client").list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return client;
    }

    @Override
    public Client getIdClient(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Client client = null;
        Transaction tx = null;
        try {
            List serv;
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLClient);
            query.addEntity(Client.class);
            query.setParameter("login", login);
            serv = query.list();
            if(serv.isEmpty()){
                client=null;
            }
            else{
            client = (Client) serv.get(0);
            System.out.println(client);
            tx.commit();
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return client;
    }

    @Override
    public Client getId(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Client client = null;
        Transaction tx = null;
        try {
            List serv;
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLID);
            query.addEntity(Client.class);
            query.setParameter("idClient", id);
            serv = query.list();
            if(serv.isEmpty()){
                client=null;
            }
            else{
            client = (Client) serv.get(0);
            System.out.println(client);
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
        return client;
    }

    @Override
    public Client getIdPassword(String password) {
          Session session = HibernateUtil.getSessionFactory().openSession();
        Client client = null;
        Transaction tx = null;
        try {
            List serv;
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLClientPassword);
            query.addEntity(Client.class);
            query.setParameter("password", password);
            serv = query.list();
            if(serv.isEmpty()){
                client=null;
            }
            else{
            client = (Client) serv.get(0);
            System.out.println(client);
            tx.commit();
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return client; 
    }
}
