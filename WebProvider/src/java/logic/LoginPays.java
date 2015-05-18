package logic;

import command.ICommand;
import daofactory.ClientDAO;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import daofactory.IContractDAO;
import daofactory.IPaysDAO;
import daofactory.IPersonalAccountDAO;
import entity.Client;
import entity.Contract;
import entity.Pays;
import entity.PersonalAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import parametr.Parameter;

public class LoginPays implements ICommand {

    private String page;

    public LoginPays() {
        super();
        page = null;
    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        List<Pays> serviceList;
        Pays pay = new Pays();
        DAOFactory mysql = DAOFactory.getInstance();
        IPaysDAO dao = mysql.getPaysDAO();
        IPersonalAccountDAO daop = mysql.getPersonalAccountDAO();
        IClientDAO daoclient = mysql.getClientDAO();
        IContractDAO daocontract = mysql.getContractDAO();
        PersonalAccount persAcc = daop.getIdPersonalAccount(Integer.valueOf((String) requestMap.get(Parameter.NUMPERSACCOUNT.getParameter())));
        if (persAcc == null) {
            hash.put("serviceList", null);
            hash.put("numPersAccount", "");
            hash.put("password", "");
            page = "pays.jsp";
        } else {
            Client client = daoclient.getIdPassword((String) requestMap.get(Parameter.USER_PASSWORD.getParameter()));
            Contract contract = daocontract.getIdPersAccount(Integer.valueOf((String) requestMap.get(Parameter.NUMPERSACCOUNT.getParameter())));

            if ((client.getIdClient() == contract.getClient().getIdClient()) && (client.getIdClient() == (Integer.valueOf((String) requestMap.get(Parameter.ID_CLIENT.getParameter()))))) {
                pay.setPersonalAccount(persAcc);
                Pays pays = dao.getIdPays(pay.getPersonalAccount().getNumPersAccount());
                if (dao.checkPays(pay) != 0) {
                    serviceList = new ArrayList();
                    serviceList = dao.getPaysList(pay.getPersonalAccount().getNumPersAccount());
                    //serviceList.add(pays);
                    hash.put("serviceList", serviceList);
                    page = "payshistory.jsp";
                } else {
                    page = "pays.jsp";
                }
            } else {
                hash.put("serviceList", null);
                page = "pays.jsp";
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
        list.add("serviceList");
        return list;
    }

}
