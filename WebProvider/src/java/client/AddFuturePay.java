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
public class AddFuturePay implements ICommand {

    private String page;

    public AddFuturePay() {

        super();
        page = null;

    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        Pays pays = new Pays();

        List<Pays> paysList = new ArrayList();
        DAOFactory mysql = DAOFactory.getInstance();
        IPaysDAO dao = mysql.getPaysDAO();
        IClientDAO daoclient = mysql.getClientDAO();
        IPersonalAccountDAO daopa = mysql.getPersonalAccountDAO();
        IContractDAO daocontract = mysql.getContractDAO();
        try {
            pays.setSumPay(Double.valueOf((String) requestMap.get(Parameter.SUMPAY.getParameter())));
            PersonalAccount pers = daopa.getIdPersonalAccount(Integer.valueOf((String) requestMap.get(Parameter.NUMPERSACCOUNT.getParameter())));
            if (pers == null) {
                hash.put("numPersonalAccount", "");
                hash.put("numPays", "");
                hash.put("idClient", pays.getClient().getIdClient());
                page = "fpay.jsp";
            } else {
                Client cl = daoclient.getIdPassword((String) requestMap.get(Parameter.USER_PASSWORD.getParameter()));
                Contract contract = daocontract.getIdPersAccount(Integer.valueOf((String) requestMap.get(Parameter.NUMPERSACCOUNT.getParameter())));

                if ((cl.getIdClient() == contract.getClient().getIdClient()) && (cl.getIdClient() == (Integer.valueOf((String) requestMap.get(Parameter.ID_CLIENT.getParameter()))))) {
                    pays.setPersonalAccount(pers);
                    Client client = daoclient.getId(Integer.valueOf((String) requestMap.get(Parameter.ID_CLIENT.getParameter())));
                    pays.setClient(client);
                    pays.setDatePay((String) requestMap.get(Parameter.DATEPAY.getParameter()));

                    if (dao.create(pays)) {
                        hash.put("numPersonalAccount", pays.getPersonalAccount().getNumPersAccount());
                        hash.put("numPays", pays.getNumPays());
                        hash.put("idClient", pays.getClient().getIdClient());
                        page = "service.jsp";
                        System.out.println("Inserted!!!!");
                    }
                } else {
                    hash.put("numPersonalAccount", "");
                    hash.put("numPays", "");
                    // hash.put("idClient", pays.getClient().getIdClient());
                    page = "fpay.jsp";
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //hash.put("contractList", contractList);
        return hash;
    }

    @Override
    public String responsePage() {
        return page;
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("numPersonalAccount");
        list.add("numPays");
        list.add("idClient");
        return list;
    }

}
