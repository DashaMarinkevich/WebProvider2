package logic;

import command.ICommand;
import command.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;

public class LogoutUser implements ICommand {

    private String page;

    public LogoutUser() {

        super();
        page = null;
    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        hash.put("idClient", "");
        hash.put("idProvider", "");
        page = "/index.jsp";
        return hash;
    }

    @Override
    public String responsePage() {
        return page;
    }

    @Override
    public ArrayList<String> atributeName() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("idClient");
        list.add("idProvider");
        return list;
    }

}
