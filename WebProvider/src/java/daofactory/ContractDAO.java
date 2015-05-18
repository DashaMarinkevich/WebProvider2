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
public class ContractDAO implements IContractDAO {

   
      private final String  SQLContract= "SELECT * FROM contract WHERE numContract =:numContract";
     private final  String SQLClient = "SELECT * FROM contract WHERE idClient =:idClient";
     private final String SQL= "SELECT * FROM contract WHERE numContract =:numContract ";
     private final String SQLPersAccount = "SELECT * FROM contract WHERE numPersAccount =:numPersAccount";
//     private final   String sqld = "DELETE FROM contract WHERE numContract = ?";
//     private final String sqlAll = "SELECT * FROM contract";

    public boolean create(Contract ob) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer idClient = null;
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

    public Contract read(int key) throws SQLException {
        Session session = null;
        Contract contract = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            contract = (Contract) session.load(Contract.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contract;
    }

    public void update(Contract ob) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Contract c = (Contract) session.get(Contract.class, ob.getNumContract());
            c.setDateContract(ob.getDateContract());
            c.setStatusContract(ob.getStatusContract());
            c.setClient(ob.getClient());
            c.setPersonalAccount(ob.getPersonalAccount());
            c.setTarifPlan(ob.getTarifPlan());
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
            Contract contract
                    = (Contract) session.get(Contract.class, key);
            session.delete(contract);
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

    public List<Contract> getInfo() throws SQLException {
        Session session = null;
        List contract = new ArrayList<Contract>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            contract = session.createQuery("FROM Contract").list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contract;
    }

    @Override
    public Contract getIdContract(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Contract contract = null;
        Transaction tx = null;
        try {
            List serv;
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQL);
            query.addEntity(Contract.class);
            query.setParameter("numContract", id);
            serv = query.list();
            if(serv.isEmpty()){
                contract=null;
            }
            else{
            contract = (Contract) serv.get(0);
            System.out.println(contract);
            System.out.println(contract.getClient().getFullName());
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
        return contract;

    }

    @Override
    public int checkContract(Contract ob) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List data = null;
        Contract c = null;
        int key = 0;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLContract);
            query.addEntity(Contract.class);
            query.setParameter("numContract", ob.getNumContract());
            data = query.list();
            if(data.isEmpty()){
                c=null;
            }
            else{
            c = (Contract) data.get(0);
            System.out.println(c);
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
if(c==null){
    return 0;
}
else{
        return c.getNumContract();
}
    }

    @Override
    public Contract getIdClient(int id) {
            Session session = HibernateUtil.getSessionFactory().openSession();
        Contract contract = null;
        Transaction tx = null;
        try {
            List serv;
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLClient);
            query.addEntity(Contract.class);
            query.setParameter("idClient", id);
            serv = query.list();
            if(serv.isEmpty()){
                contract=null;
            }
            else{
            contract = (Contract) serv.get(0);
            System.out.println(contract);
            System.out.println(contract.getClient().getFullName());
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
        return contract;
    }

    @Override
    public Contract getIdPersAccount(int numPersAccount) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Contract contract = null;
        Transaction tx = null;
        try {
            List serv;
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(SQLPersAccount);
            query.addEntity(Contract.class);
            query.setParameter("numPersAccount", numPersAccount);
            serv = query.list();
            if(serv.isEmpty()){
                contract=null;
            }
            else{
            contract = (Contract) serv.get(0);
            System.out.println(contract);
            System.out.println(contract.getClient().getFullName());
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
        return contract; 
    }

}
