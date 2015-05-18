package contract;

import command.ICommand;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import daofactory.IContractDAO;
import daofactory.IPersonalAccountDAO;
import daofactory.IServiceDAO;
import daofactory.ITarifDAO;
import entity.Client;
import entity.Contract;
import entity.PersonalAccount;
import entity.Service;
import entity.TarifPlan;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import parametr.Parameter;

public class TarifService implements ICommand {
	//private ServiceAction action;

    public TarifService() {
        super();

    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        List<Service> serviceList = new ArrayList();

        List<TarifPlan> tarifList = new ArrayList();
        List<Client> clientList = new ArrayList();
        DAOFactory mysql = DAOFactory.getInstance();
        IServiceDAO dao = mysql.getServiceDAO();
        ITarifDAO daot = mysql.getTarifPlanDAO();
        IContractDAO daocontract = mysql.getContractDAO();
        IClientDAO daoclient = mysql.getClientDAO();
        int numPersAccount = 0;
        IPersonalAccountDAO daoperacc = mysql.getPersonalAccountDAO();
        try {
            if (!((String) requestMap.get(Parameter.ID_CLIENT.getParameter())).equals("")) {
                Client client = daoclient.getId(Integer.valueOf((String) requestMap.get(Parameter.ID_CLIENT.getParameter())));
                //contract.setClient(client);
                clientList.add(client);

                hash.put("clientList", clientList);
            }
            serviceList = dao.getInfo();
            tarifList = daot.getInfo();

            numPersAccount = daoperacc.create(new PersonalAccount(12, "Активен", 0));

        } catch (SQLException ex) {
            //Logger.getLogger(ChangeTarifService.class.getName()).log(Level.SEVERE, null, ex);
        }
        hash.put("serviceList", serviceList);
        hash.put("tarifList", tarifList);
        hash.put("numPersAccount", numPersAccount);

        return hash;
    }

    @Override
    public String responsePage() {
        return "/inter.jsp";
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("serviceList");
        list.add("tarifList");
        list.add("clientList");
        list.add("numPersAccount");
        return list;
    }

}
