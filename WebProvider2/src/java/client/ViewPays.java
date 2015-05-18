package client;

import command.ICommand;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import daofactory.IPaysDAO;
import daofactory.IServiceDAO;
import entity.Client;
import entity.Pays;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewPays implements ICommand {

    public ViewPays() {
        super();

    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();

        List<Pays> paysList = new ArrayList();
        DAOFactory mysql = DAOFactory.getInstance();
        IPaysDAO dao = mysql.getPaysDAO();
        try {
            paysList = dao.getInfo();
        } catch (SQLException ex) {

        }
        hash.put("paysList", paysList);
        return hash;
    }

    @Override
    public String responsePage() {
        return "viewPays.jsp";
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("paysList");
        return list;
    }

}
