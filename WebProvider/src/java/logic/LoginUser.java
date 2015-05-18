package logic;

import command.ICommand;
import daofactory.ClientDAO;
import daofactory.DAOFactory;
import daofactory.IClientDAO;
import daofactory.IContractDAO;
import entity.Client;
import entity.Contract;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import parametr.Parameter;

public class LoginUser implements ICommand {

    private String page;

    public LoginUser() {
        super();
        page = null;

    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        Client client = new Client();
        DAOFactory mysql = DAOFactory.getInstance();
        IClientDAO dao = mysql.getClientDAO();
        String[] mas = null;
        IContractDAO daocontract = mysql.getContractDAO();
// try { 
//      File file = new File("provider.txt");
//      BufferedReader br;
//        br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
//
//        int i = 0;
//        String[] line;
//        line = new String[2];
//
//        while ((line[i] = br.readLine()) != null) {
//            //variable line does NOT have new-line-character at the end
//            if (i == 1) {
//                break;
//            }
//            i++;
//        }
//        br.close();
//
//        mas[0] = line[0];
//       mas[1] = line[1];
//     } catch (IOException e) { 
//       e.printStackTrace(); 
//     } 
        if ((((String) requestMap.get(Parameter.USER_LOGIN.getParameter())).equals("provider")) && (((String) requestMap.get(Parameter.USER_PASSWORD.getParameter())).equals("provider1"))) {
            hash.put("loginProvider", "provider");
            hash.put("passwordProvider", "provider");

            page = "service.jsp";
        } else {
            client.setLogin((String) requestMap.get(Parameter.USER_LOGIN.getParameter()));
            client.setPassword((String) requestMap.get(Parameter.USER_PASSWORD.getParameter()));
            Client clients = dao.getIdClient(client.getLogin());
            Contract contract = new Contract();

            if (clients == null) {
                hash.put("login", "");
                hash.put("password", "");
                hash.put("idClient", 0);
                page = "/index.jsp";
            } else {
                contract = daocontract.getIdClient(clients.getIdClient());
                if (contract == null) {
                    hash.put("login", "");
                    hash.put("password", "");
                    hash.put("idClient", 0);
                    page = "/index.jsp";
                } else {
                    if (dao.checkLogin(client) != 0) {
                        hash.put("login", clients.getLogin());
                        hash.put("password", clients.getPassword());
                        hash.put("idClient", clients.getIdClient());
                        page = "service.jsp";
                    } else {
                        page = "/index.jsp";
                    }
                }
            }
        }
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
        list.add("loginProvider");
        list.add("passwordProvider");
        list.add("idClient");
        return list;
    }

}
