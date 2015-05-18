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
public interface  IClientDAO {
    public boolean create(Client ob) throws SQLException;
    
    public  Client read(int key) throws SQLException;
    
    public  void update(Client ob) throws SQLException;
    
    public  void delete(int key) throws SQLException;
    public Client getIdClient(String login);
     public Client getIdPassword(String password);
    public  List<Client> getInfo() throws SQLException;
  public Client getId(int id);
      public  int checkLogin(Client ob);
}

