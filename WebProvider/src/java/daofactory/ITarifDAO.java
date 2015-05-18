package daofactory;

import entity.Client;
import entity.Contract;

import entity.Service;
import entity.TarifPlan;
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
public interface ITarifDAO {

    public boolean create(TarifPlan ob) throws SQLException;

    public TarifPlan read(int key) throws SQLException;

    public void update(TarifPlan ob) throws SQLException;

    public void delete(int key) throws SQLException;

    public TarifPlan getIdTarifPlan(String login);

    public TarifPlan getTarifPlan(int id);

    public List<TarifPlan> getInfo() throws SQLException;

}
