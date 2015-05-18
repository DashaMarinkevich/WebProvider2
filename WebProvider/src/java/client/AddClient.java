/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import command.ICommand;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import entity.Client;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import parametr.Parameter;

/**
 *
 * @author Dasha-RV515
 */
public class AddClient implements ICommand {

    private String page;

    public AddClient() {
        super();
        page = null;
    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        Client client = new Client();
        List<Client> clientList = new ArrayList();
        DAOFactory mysql = DAOFactory.getInstance();
        IClientDAO dao = mysql.getClientDAO();
        try {

            client.setFullName((String) requestMap.get(Parameter.FULL_NAME.getParameter()));
            client.setSeriaPassport((String) requestMap.get(Parameter.SERIA_PASSPORT.getParameter()));
            client.setNumPassport(Integer.valueOf((String) requestMap.get(Parameter.NUM_PASSPORT.getParameter())));
            client.setAdress((String) requestMap.get(Parameter.ADRESS.getParameter()));
            client.setEmail((String) requestMap.get(Parameter.EMAIL.getParameter()));
            client.setLogin((String) requestMap.get(Parameter.USER_LOGIN.getParameter()));
            client.setPassword((String) requestMap.get(Parameter.USER_PASSWORD.getParameter()));
            clientList = dao.getInfo();
            int ch = 0;
            for (int i = 0; i < clientList.size(); i++) {
                if (clientList.get(i).getLogin().equals(client.getLogin())) {
                    hash.put("login", "");

                    hash.put("flag", "1");
                } else {
                    ch++;
                }
            }
            if (ch == clientList.size()) {
                if (dao.create(client)) {
                    System.out.println("Inserted!!!!");
                    page = "index.jsp";
                    hash.put("login", client.getLogin());
                    hash.put("flag", 0);
                }
            } else {
                page = "regist.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
        hash.put("password", client.getPassword());
        hash.put("idClient", client.getIdClient());
        hash.put("fullName", client.getFullName());
        hash.put("seriaPassport", client.getSeriaPassport());
        hash.put("numPassport", client.getNumPassport());
        hash.put("adress", client.getAdress());
        hash.put("email", client.getEmail());
        hash.put("password", client.getPassword());

        return hash;
    }

    @Override
    public String responsePage() {
        return page;
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("login");
        list.add("password");
        list.add("idClient");
        list.add("fullName");
        list.add("seriaPassport");
        list.add("numPassport");
        list.add("adress");
        list.add("email");
        list.add("flag");
        return list;
    }

}
