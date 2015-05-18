/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provider;

import command.ICommand;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import daofactory.ITarifDAO;
import entity.Client;
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
public class DeleteTarif implements ICommand {

    public DeleteTarif() {
        super();
    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        TarifPlan tarif = new TarifPlan();
        DAOFactory mysql = DAOFactory.getInstance();
        ITarifDAO dao = mysql.getTarifPlanDAO();
        try {
            tarif = dao.getIdTarifPlan((String) requestMap.get(Parameter.NAME_TARIF.getParameter()));
            dao.delete(tarif.getIdTarif());
            System.out.println("Delete!!!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        hash.put("idTarif", tarif.getIdTarif());
        return hash;
    }

    @Override
    public String responsePage() {
        return "service.jsp";
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("idTarif");
        return list;
    }

}
