package daofactory;

import entity.Client;
import entity.Contract;
import entity.Contract_Service;

import entity.Service;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dasha-RV515
 */
public interface  IContract_ServiceDAO {
    public boolean create(Contract_Service ob) throws SQLException;
    
    public  Contract_Service read(int key) throws SQLException;
    
    public  void update(Contract_Service ob) throws SQLException;
    
    public  void delete(int key) throws SQLException;
    public List<Contract_Service> getIdContract(int id);
       public int getId(int numContract,int idService);
    public  List<Contract_Service> getInfo() throws SQLException;

     // public  int checkLogin(Client ob);
}

