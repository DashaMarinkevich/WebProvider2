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
public interface  IServiceDAO {
    public  boolean create(Service ob) throws SQLException;
    
    public  Service read(int key) throws SQLException;
    
    public  void update(Service ob) throws SQLException;
    
    public  void delete(int key) throws SQLException;
    public Service getIdService(String login);
    public  List<Service> getInfo() throws SQLException;
    
}

