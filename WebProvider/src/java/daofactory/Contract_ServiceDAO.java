/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daofactory;

import entity.Client;
import entity.Contract;
import entity.Contract_Service;
import entity.Service;
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
public class Contract_ServiceDAO implements IContract_ServiceDAO {

    private final String SQLContract = "SELECT * FROM contract_service WHERE numContract =:numContract";
    private final String SQLIDC_S = "SELECT * FROM contract_service WHERE numContract =:numContract AND idService =:idService";

    @Override
    public boolean create(Contract_Service ob) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer idClient = null;
        try {
            tx = session.beginTransaction();
            Contract_Service contract_Service = new Contract_Service();
            contract_Service.setContract(ob.getContract());
            contract_Service.setService(ob.getService());
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
    public Contract_Service read(int key) throws SQLException {

        Session session = null;
        Contract_Service c = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            c = (Contract_Service) session.load(Contract_Service.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return c;
    }

    @Override
    public void update(Contract_Service ob) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Contract_Service c = (Contract_Service) session.get(Contract_Service.class, ob.getIdcontract_service());
            c.setService(ob.getService());
            c.setContract(ob.getContract());
            session.update(c);
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
            serv = session.createCriteria(Contract_Service.class).list();
            for (Iterator iterator
                    = serv.iterator(); iterator.hasNext();) {
                Contract_Service c_s = (Contract_Service) iterator.next();
                if (c_s.getIdcontract_service() == key) {
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
    public List<Contract_Service> getInfo() throws SQLException {

        Session session = null;
        List c = new ArrayList<Contract_Service>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            c = session.createCriteria(Contract_Service.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return c;
    }

    public Contract_Service getIdService(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contract_Service> getIdContract(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Contract_Service> data = null;
        Contract_Service c_s = null;
        int key = 0;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLContract);
            query.addEntity(Contract_Service.class);
            query.setParameter("numContract", id);
            data = query.list();
            // c_s = (Contract_Service)data.get(0);

            System.out.println(data);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (data.isEmpty()) {
            return null;
        } else {
            System.out.println(data.get(0).getIdcontract_service());
            return data;
        }
    }

    @Override
    public int getId(int numContract, int idService) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Contract_Service> data = null;
        Contract_Service[] c_s = null;
        int key = 0;
        int id;
        id = 0;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLIDC_S);
            query.addEntity(Contract_Service.class);
            query.setParameter("numContract", numContract);
            query.setParameter("idService", idService);
            data = query.list();
            int i = 0;
            if (data.isEmpty()) {
                id = 0;
            } else {
                id = data.get(0).getIdcontract_service();
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

        return id;
    }

}

   // public Contract_ServiceDAO(Connection connection) {
//   this.connection = connection;
// }

