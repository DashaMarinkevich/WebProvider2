package client;

import command.ICommand;
import daofactory.DAOFactory;
import daofactory.ITarifDAO;
import entity.Client;
import entity.TarifPlan;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewTarifPlan implements ICommand {

    public ViewTarifPlan() {
        super();

    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        List<TarifPlan> tarifList = new ArrayList();
        DAOFactory mysql = DAOFactory.getInstance();
        ITarifDAO dao = mysql.getTarifPlanDAO();
        try {
            tarifList = dao.getInfo();
        } catch (SQLException ex) {
            Logger.getLogger(ViewTarifPlan.class.getName()).log(Level.SEVERE, null, ex);
        }
        hash.put("tarifList", tarifList);
        return hash;
    }

    @Override
    public String responsePage() {
        return "viewTarifPlan.jsp";
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("tarifList");
        return list;
    }

}
