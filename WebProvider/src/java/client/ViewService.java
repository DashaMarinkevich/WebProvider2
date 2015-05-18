package client;

import command.ICommand;
import daofactory.DAOFactory;
import daofactory.IServiceDAO;
import entity.Client;
import entity.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewService implements ICommand {

    public ViewService() {
        super();

    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        List<Service> serviceList = new ArrayList();
        DAOFactory mysql = DAOFactory.getInstance();
        IServiceDAO dao = mysql.getServiceDAO();
        try {
            serviceList = dao.getInfo();
        } catch (SQLException ex) {
            Logger.getLogger(ViewService.class.getName()).log(Level.SEVERE, null, ex);
        }
        hash.put("serviceList", serviceList);
        return hash;
    }

    @Override
    public String responsePage() {
        return "viewService.jsp";
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("serviceList");
        return list;
    }

}
