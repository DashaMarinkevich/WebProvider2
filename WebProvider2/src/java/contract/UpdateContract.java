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
import java.util.logging.Level;
import java.util.logging.Logger;
import parametr.Parameter;

/**
 *
 * @author Dasha-RV515
 */
public class UpdateContract implements ICommand {

    private String page;

    public UpdateContract() {

        super();
        page = null;

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
        //contract.setNumContract(Integer.valueOf((String) requestMap.get(Parameter.NUM_CONTRACT.getParameter())));
        Client client = daoclient.getId(Integer.valueOf((String) requestMap.get(Parameter.ID_CLIENT.getParameter())));
        contract.setClient(client);
        //contract.setNumContract(Integer.valueOf((String) requestMap.get(Parameter.ID_CLIENT.getParameter())));
        if (dao.getIdClient(contract.getClient().getIdClient()).getNumContract() != 0) {
            int numContract = dao.getIdClient(contract.getClient().getIdClient()).getNumContract();
            contract.setNumContract(numContract);
            int numPersAccount = dao.getIdClient(contract.getClient().getIdClient()).getPersonalAccount().getNumPersAccount();
            TarifPlan tarif = daotarif.getIdTarifPlan((String) requestMap.get(Parameter.TARIF.getParameter()));
            contract.setTarifPlan(tarif);
            PersonalAccount pacc = daoperacc.getIdPersonalAccount(numPersAccount);
            contract.setPersonalAccount(pacc);
            Contract contr = dao.getIdContract(numContract);
            contract.setDateContract(contr.getDateContract());
            contract.setStatusContract((String) requestMap.get(Parameter.STATUS.getParameter()));
            List<Contract_Service> c_slist = daoContract_Service.getIdContract(numContract);
            int[] mas;
            System.out.println(c_slist.size());
            mas = new int[c_slist.size()];
            for (int i = 0; i < c_slist.size(); i++) {
                mas[i] = c_slist.get(i).getIdcontract_service();
                System.out.println(mas[i]);
            }

            String str[] = (String[]) requestMap.get(Parameter.SERVICE.getParameter());
            int idService = 0;
            int c_sid = 0;
            try {
                Contract_Service cs = new Contract_Service();

                for (int i = 0; i < str.length; i++) {
                    idService = daoservice.getIdService(str[i]).getIdSevice();
                    System.out.println(idService);
                //List<Contract_Service> lc_s=new ArrayList();
                    //lc_s=daoContract_Service.getIdContract(contract.getNumContract());
                    c_sid = daoContract_Service.getId(numContract, idService);
                    System.out.println(c_sid);
                    int ch = 0;
                    for (int j = 0; j < c_slist.size(); j++) {
                        if (mas[j] == c_sid) {
                            System.out.println("fhdfhdfdfdfdf");
                            int idContract_Service = mas[j];
                            Contract_Service con_ser = new Contract_Service();
                            con_ser.setIdcontract_service(idContract_Service);
                            con_ser.setContract(contract);
                            con_ser.setService(daoservice.getIdService(str[i]));
                            daoContract_Service.update(con_ser);
                        } else {
                            ch++;
                            daoContract_Service.delete(mas[j]);
                        }
                    }
                    System.out.println(ch);
                    if (ch == c_slist.size()) {
                        System.out.println(str[i]);
                        cs.setContract(contract);
                        cs.setService(daoservice.getIdService(str[i]));
                        daoContract_Service.create(cs);
                    }

                }

                dao.update(contract);

                List< Contract_Service> c_s = daoContract_Service.getIdContract(numContract);

                hash.put("contract_serviceList", c_s);
                hash.put("idClient", contract.getClient().getIdClient());
                hash.put("numContract", contract.getNumContract());
                //hash.put("numPersAccount", contract.getPersonalAccount().getNumPersAccount());	
                contractList = new ArrayList();
                contractList.add(contract);
                hash.put("contractList", contractList);
                page = "contract.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(UpdateContract.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            page = "tarif.jsp";
        }
        return hash;
    }

    @Override
    public String responsePage() {
        return page;
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("contractList");
        list.add("contract_serviceList");
        return list;
    }
}
