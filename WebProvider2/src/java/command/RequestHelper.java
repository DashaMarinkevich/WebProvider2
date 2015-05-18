package command;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import client.AddClient;
import contract.AddContract;
import client.AddFuturePay;
import provider.AddService;
import client.AddSumAccount;
import provider.AddTarif;
import contract.ChangeContract;
import contract.ChangeTarifService;
import logic.LoginPays;
import logic.LoginUser;
import logic.LogoutUser;
import contract.TarifService;
import contract.UpdateContract;
import provider.ViewClient;
import provider.ViewContract;
import client.ViewPays;
import client.ViewPersonalAccount;
import client.ViewService;
import client.ViewTarifPlan;
import provider.DeleteService;
import provider.DeleteTarif;

public class RequestHelper {

    public static RequestHelper instance = null;
    private HashMap<String, ICommand> commands;

    public RequestHelper() {
        commands = new HashMap<String, ICommand>();
        commands.put("persAccount", new ViewPersonalAccount());
        commands.put("pays", new LoginPays());
        commands.put("loginUser", new LoginUser());
         commands.put("login", new LoginUser());
        commands.put("viewClient", new ViewClient());
        commands.put("viewPays", new ViewPays());
         commands.put("viewContract", new ViewContract());
        commands.put("viewService", new ViewService());
        commands.put("viewTarifPlan", new ViewTarifPlan());
        commands.put("addClient", new AddClient());
        commands.put("addTarif", new AddTarif());
        commands.put("addService", new AddService());
          commands.put("deleteTarif", new DeleteTarif());
        commands.put("deleteService", new DeleteService());
        commands.put("addContract", new AddContract());
        commands.put("addFuturePay", new AddFuturePay());
         commands.put("changeContract", new ChangeContract());
          commands.put("changeTarifService", new ChangeTarifService());
          commands.put("updateContract", new UpdateContract());
           commands.put("inter", new TarifService());
            commands.put("addSumAccount", new AddSumAccount());
             commands.put("logoutUser",new LogoutUser());
         
    }

    public ICommand getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        ICommand command = commands.get(action);
        /*if (command == null) {
         command = new NoCommand();
         }*/
        return command;
    }

    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }

}
