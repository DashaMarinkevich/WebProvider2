package daofactory;

import entity.Client;
import entity.Contract;
import entity.Pays;

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
public interface IPaysDAO {

    public boolean create(Pays ob) throws SQLException;

    public Pays read(int key) throws SQLException;

    public void update(Pays ob) throws SQLException;

    public void delete(int key) throws SQLException;

    public Pays getIdPays(int id);
      public List<Pays> getPaysList(int id);

    public List<Pays> getInfo() throws SQLException;

    public int checkPays(Pays ob);
     // public  int checkLogin(Client ob);
}
