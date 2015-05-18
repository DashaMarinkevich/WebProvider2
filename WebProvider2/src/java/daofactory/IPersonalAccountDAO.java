package daofactory;

import entity.Client;
import entity.Contract;
import entity.Pays;
import entity.PersonalAccount;

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
public interface  IPersonalAccountDAO {
    public int create(PersonalAccount ob) throws SQLException;
    
    public  PersonalAccount read(int key) throws SQLException;
    
    public  void update(PersonalAccount ob) throws SQLException;
    
    public  void delete(int key) throws SQLException;
    public PersonalAccount getIdPersonalAccount(int id);
    public  List<PersonalAccount> getInfo() throws SQLException;

     // public  int checkLogin(Client ob);
}

