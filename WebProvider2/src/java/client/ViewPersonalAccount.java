package client;

import command.ICommand;
import daofactory.AbstractDAO;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import daofactory.IContractDAO;
import daofactory.IPersonalAccountDAO;
import daofactory.IServiceDAO;
import entity.Client;
import entity.Contract;
import entity.PersonalAccount;
import entity.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import parametr.Parameter;

public class ViewPersonalAccount implements ICommand {

    private String page;

    public ViewPersonalAccount() {
        super();
        page = null;
    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        List<Contract> serviceList;
        PersonalAccount personalAccount = new PersonalAccount();
        DAOFactory mysql = DAOFactory.getInstance();
        IPersonalAccountDAO dao = mysql.getPersonalAccountDAO();
        IContractDAO daocontract = mysql.getContractDAO();
        Contract contract = daocontract.getIdClient(Integer.valueOf((String) requestMap.get(Parameter.ID_CLIENT.getParameter())));
        contract.getPersonalAccount().getNumPersAccount();
        contract.getPersonalAccount().getStatusPersAccount();
        personalAccount = contract.getPersonalAccount();
        serviceList = new ArrayList();
        serviceList.add(contract);
        hash.put("serviceList", serviceList);
        page = "persAccount.jsp";
        return hash;
    }

    @Override
    public String responsePage() {
        return page;
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("serviceList");
        return list;
    }

}
