/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import command.ICommand;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import daofactory.IContractDAO;
import daofactory.IContract_ServiceDAO;
import daofactory.IPaysDAO;
import daofactory.IPersonalAccountDAO;
import daofactory.IServiceDAO;
import daofactory.ITarifDAO;
import entity.Client;
import entity.Contract;
import entity.Contract_Service;
import entity.Pays;
import entity.PersonalAccount;
import entity.Service;
import entity.TarifPlan;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import parametr.Parameter;

/**
 *
 * @author Dasha-RV515
 */
public class AddSumAccount implements ICommand {

    public AddSumAccount() {

        super();

    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        PersonalAccount persacc = new PersonalAccount();
        List<Contract> serviceList = new ArrayList();
        List<PersonalAccount> persList = new ArrayList();
        DAOFactory mysql = DAOFactory.getInstance();
        IPersonalAccountDAO dao = mysql.getPersonalAccountDAO();
        IClientDAO daoclient = mysql.getClientDAO();
        IPersonalAccountDAO daopa = mysql.getPersonalAccountDAO();
        IContractDAO daocontract = mysql.getContractDAO();
        IPaysDAO daopays = mysql.getPaysDAO();
        Client client = new Client();
        try {
            Contract contract = daocontract.getIdClient(Integer.valueOf((String) requestMap.get(Parameter.ID_CLIENT.getParameter())));
            persacc = contract.getPersonalAccount();
            int sumOld = persacc.getSumPersAccount();
            System.out.println(sumOld);
            int sumNew = sumOld + Integer.valueOf((String) requestMap.get(Parameter.SUMPERSACCOUNT.getParameter()));
            System.out.println(sumNew);
            //PersonalAccount per=new PersonalAccount();
            persacc.setNumPersAccount(contract.getPersonalAccount().getNumPersAccount());
            persacc.setSumPersAccount(sumNew);
            persacc.setStatusPersAccount(contract.getPersonalAccount().getStatusPersAccount());
            System.out.println(persacc);
            dao.update(persacc);
            client = daoclient.getId(Integer.valueOf((String) requestMap.get(Parameter.ID_CLIENT.getParameter())));
            Pays pay = new Pays();
            pay.setSumPay(sumNew - sumOld);
            pay.setDatePay((String) requestMap.get(Parameter.DATEPAY.getParameter()));
            pay.setClient(client);
            pay.setPersonalAccount(persacc);
            daopays.create(pay);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hash.put("idClient", client.getIdClient());
        hash.put("numPersonalAccount", persacc.getNumPersAccount());
        return hash;
    }

    @Override
    public String responsePage() {

        return "service.jsp";
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        //list.add("contractList");
        list.add("numPersonalAccount");
        //list.add("numPays");
        list.add("idClient");
        return list;
    }

}
