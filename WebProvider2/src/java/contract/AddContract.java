/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import command.ICommand;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import daofactory.IContractDAO;
import daofactory.IContract_ServiceDAO;
import daofactory.IPersonalAccountDAO;
import daofactory.IServiceDAO;
import daofactory.ITarifDAO;
import entity.Client;
import entity.Contract;
import entity.Contract_Service;
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
public class AddContract implements ICommand {

    public AddContract() {

        super();

    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        Contract contract = new Contract();

        List<Contract> contractList = new ArrayList();
        DAOFactory mysql = DAOFactory.getInstance();
        IContractDAO dao = mysql.getContractDAO();
        IClientDAO daoclient = mysql.getClientDAO();
        ITarifDAO daotarif = mysql.getTarifPlanDAO();
        IPersonalAccountDAO daoperacc = mysql.getPersonalAccountDAO();
        IServiceDAO daoservice = mysql.getServiceDAO();
        IContract_ServiceDAO daoContract_Service = mysql.getContract_ServiceDAO();
        try {
            contract.setDateContract((String) requestMap.get(Parameter.DATE.getParameter()));
            System.out.println((String) requestMap.get(Parameter.DATE.getParameter()));
            Client client = daoclient.getIdClient((String) requestMap.get(Parameter.USER_LOGIN.getParameter()));
            if (client == null) {
                client = new Client();
                client.setFullName((String) requestMap.get(Parameter.FULL_NAME.getParameter()));
                client.setSeriaPassport((String) requestMap.get(Parameter.SERIA_PASSPORT.getParameter()));
                client.setNumPassport(Integer.valueOf((String) requestMap.get(Parameter.NUM_PASSPORT.getParameter())));
                client.setAdress((String) requestMap.get(Parameter.ADRESS.getParameter()));
                client.setEmail((String) requestMap.get(Parameter.EMAIL.getParameter()));
                client.setLogin((String) requestMap.get(Parameter.USER_LOGIN.getParameter()));
                client.setPassword((String) requestMap.get(Parameter.USER_PASSWORD.getParameter()));

                if (daoclient.create(client)) {
                    System.out.println("Inserted!!!!");
                }
            }

            contract.setClient(client);

            TarifPlan tarif = daotarif.getIdTarifPlan((String) requestMap.get(Parameter.TARIF.getParameter()));
            // TarifPlan tarif = daotarif.getTarifPlan(Integer.valueOf((String)  requestMap.get(Parameter.ID_TARIF.getParameter())));
            contract.setTarifPlan(tarif);
            PersonalAccount pacc = daoperacc.getIdPersonalAccount(Integer.valueOf((String) requestMap.get(Parameter.NUMPERSACCOUNT.getParameter())));
            contract.setPersonalAccount(pacc);
            contract.setStatusContract((String) requestMap.get(Parameter.STATUS.getParameter()));
            if (dao.create(contract)) {
                System.out.println("Inserted!!!!");
            }
            String str[] = (String[]) requestMap.get(Parameter.SERVICE.getParameter());
            System.out.println(str[0]);
            Contract_Service cs = new Contract_Service();
            for (int i = 0; i < str.length; i++) {
                cs.setContract(contract);
                cs.setService(daoservice.getIdService(str[i]));
                daoContract_Service.create(cs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hash;
    }

    @Override
    public String responsePage() {
        return "/index.jsp";
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        return list;
    }

}
