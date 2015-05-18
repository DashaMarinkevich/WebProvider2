package contract;

import command.ICommand;
import daofactory.ClientDAO;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import daofactory.IContractDAO;
import daofactory.IContract_ServiceDAO;
import daofactory.IPersonalAccountDAO;
import daofactory.ITarifDAO;
import entity.Client;
import entity.Contract;
import entity.Contract_Service;
import entity.PersonalAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import parametr.Parameter;

public class ChangeContract implements ICommand {

    private String page;

    public ChangeContract() {
        super();
        page = null;

    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        List<Contract> contractList;
        Contract contract = new Contract();
        Contract_Service contract_service;
        DAOFactory mysql = DAOFactory.getInstance();

        IContractDAO dao = mysql.getContractDAO();
        IPersonalAccountDAO daop = mysql.getPersonalAccountDAO();
        IClientDAO daoclient = mysql.getClientDAO();
        IContract_ServiceDAO daoc_s = mysql.getContract_ServiceDAO();
        ITarifDAO daotarif = mysql.getTarifPlanDAO();
        contract.setNumContract(Integer.valueOf((String) requestMap.get(Parameter.NUM_CONTRACT.getParameter())));
        PersonalAccount persAcc = daop.getIdPersonalAccount(Integer.valueOf((String) requestMap.get(Parameter.NUMPERSACCOUNT.getParameter())));
        Client cl = daoclient.getIdClient((String) requestMap.get(Parameter.USER_LOGIN.getParameter()));
        if ((persAcc == null) || (cl == null)) {
            hash.put("contract_serviceList", "");
            hash.put("contractList", "");
            page = "changecontract.jsp";
        } else {
            contract.setPersonalAccount(persAcc);
            contract.setClient(cl);
            Contract contr = dao.getIdContract(contract.getNumContract());
            if (contr == null) {
                hash.put("contract_serviceList", "");
                hash.put("contractList", "");
                page = "changecontract.jsp";
            } else {
                if ((contr.getClient().getIdClient() == cl.getIdClient()) && (contr.getPersonalAccount().getNumPersAccount() == persAcc.getNumPersAccount())) {
                    if (dao.checkContract(contract) != 0) {
                        List< Contract_Service> c_s = daoc_s.getIdContract(Integer.valueOf((String) requestMap.get(Parameter.NUM_CONTRACT.getParameter())));
                        // contract_serviceList=new ArrayList<Contract_Service>();
                        // contract_serviceList.add(c_s);
                        hash.put("contract_serviceList", c_s);
                        hash.put("idClient", contract.getClient().getIdClient());
                        hash.put("numContract", contract.getNumContract());
                        hash.put("numPersAccount", contract.getPersonalAccount().getNumPersAccount());
                        contractList = new ArrayList();
                        contractList.add(contr);
                        hash.put("contractList", contractList);
                        page = "contract.jsp";
                    } else {
                        page = "changecontract.jsp";
                    }
                } else {
                    hash.put("contract_serviceList", "");
                    hash.put("contractList", "");
                    page = "changecontract.jsp";
                }
            }
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
        list.add("idClient");
        list.add("numContract");
        list.add("numPersAccount");
        list.add("contractList");
        list.add("contract_serviceList");
        return list;
    }

}
