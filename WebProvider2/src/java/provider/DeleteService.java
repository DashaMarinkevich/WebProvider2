/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provider;

import command.ICommand;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import daofactory.IServiceDAO;
import daofactory.ITarifDAO;
import entity.Client;
import entity.Service;
import entity.TarifPlan;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import parametr.Parameter;

/**
 *
 * @author Dasha-RV515
 */
public class DeleteService implements ICommand {

    public DeleteService() {
        super();
    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        Service service = new Service();
        DAOFactory mysql = DAOFactory.getInstance();
        IServiceDAO dao = mysql.getServiceDAO();
        try {
            service = dao.getIdService((String) requestMap.get(Parameter.DESCRIP_SERVICE.getParameter()));

            dao.delete(service.getIdSevice());
            System.out.println("Delete!!!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        hash.put("idService", service.getIdSevice());
        return hash;
    }

    @Override
    public String responsePage() {
        return "service.jsp";
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("idService");
        return list;
    }

}
