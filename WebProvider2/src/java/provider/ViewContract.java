package provider;

import command.ICommand;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import daofactory.IContractDAO;
import daofactory.IContract_ServiceDAO;
import daofactory.IServiceDAO;
import entity.Client;
import entity.Contract;
import entity.Contract_Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewContract implements ICommand {

    public ViewContract() {
        super();

    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();

        List<Contract> contractList = new ArrayList();
        List<Contract_Service> service_contractList = new ArrayList();
        DAOFactory mysql = DAOFactory.getInstance();
        IContractDAO dao = mysql.getContractDAO();
        IContract_ServiceDAO daoc_s = mysql.getContract_ServiceDAO();
        try {
            contractList = dao.getInfo();
            service_contractList = daoc_s.getInfo();
        } catch (SQLException ex) {

        }
        hash.put("contractList", contractList);
        hash.put("service_contractList", service_contractList);
        return hash;
    }

    @Override
    public String responsePage() {
        return "viewContract.jsp";
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("contractList");
        list.add("service_contractList");
        return list;
    }

}
