package provider;

import command.ICommand;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import daofactory.IServiceDAO;
import entity.Client;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import client.ViewService;

public class ViewClient implements ICommand {

    public ViewClient() {
        super();

    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();

        List<Client> clientList = new ArrayList();
        DAOFactory mysql = DAOFactory.getInstance();
        IClientDAO dao = mysql.getClientDAO();
        try {
            clientList = dao.getInfo();
        } catch (SQLException ex) {
            Logger.getLogger(ViewService.class.getName()).log(Level.SEVERE, null, ex);
        }
        hash.put("clientList", clientList);
        return hash;
    }

    @Override
    public String responsePage() {
        return "viewClient.jsp";
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("clientList");
        return list;
    }

}
