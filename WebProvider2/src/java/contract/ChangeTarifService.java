package contract;

import command.ICommand;
import daofactory.DAOFactory;
import daofactory.IServiceDAO;
import daofactory.ITarifDAO;
import entity.Client;
import entity.Service;
import entity.TarifPlan;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangeTarifService implements ICommand {
	//private ServiceAction action;

    public ChangeTarifService() {
        super();

    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        List<Service> serviceList = new ArrayList();

        List<TarifPlan> tarifList = new ArrayList();
        DAOFactory mysql = DAOFactory.getInstance();
        IServiceDAO dao = mysql.getServiceDAO();
        ITarifDAO daot = mysql.getTarifPlanDAO();
        try {
            serviceList = dao.getInfo();
            tarifList = daot.getInfo();
        } catch (SQLException ex) {
            //Logger.getLogger(ChangeTarifService.class.getName()).log(Level.SEVERE, null, ex);
        }
        hash.put("serviceList", serviceList);
        hash.put("tarifList", tarifList);

        return hash;
    }

    @Override
    public String responsePage() {
        return "tarif.jsp";
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("serviceList");
        list.add("tarifList");
        return list;
    }

}
