/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daofactory;

import daofactory.PaysDAO;
import daofactory.ClientDAO;
import daofactory.ContractDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dasha-RV515
 */
public class DAOFactory {
private static DAOFactory instance = null;
 public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }
    public ClientDAO getClientDAO() {
        return new ClientDAO();
    }

    public PaysDAO getPaysDAO() {
        return new PaysDAO();
    }
public ContractDAO getContractDAO() {
        return new ContractDAO();
    }
  
 public ServiceDAO getServiceDAO() {
        return new ServiceDAO();
    }

    public TarifPlanDAO getTarifPlanDAO() {
        return new TarifPlanDAO();
    }
public PersonalAccountDAO getPersonalAccountDAO() {
        return new PersonalAccountDAO();
    }
public Contract_ServiceDAO getContract_ServiceDAO() {
        return new Contract_ServiceDAO();
    }

}
