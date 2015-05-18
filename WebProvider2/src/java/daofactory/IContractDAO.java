package daofactory;

import entity.Client;
import entity.Contract;

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
public interface  IContractDAO {
    public boolean create(Contract ob) throws SQLException;
    
    public  Contract read(int key) throws SQLException;
    
    public  void update(Contract ob) throws SQLException;
    
    public  void delete(int key) throws SQLException;
    public Contract getIdContract(int id);
      public Contract getIdClient(int id);
       public Contract getIdPersAccount(int numPersAccount);
    public  List<Contract> getInfo() throws SQLException;

    public  int checkContract(Contract ob);
}

