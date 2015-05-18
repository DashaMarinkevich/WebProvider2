/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import command.ICommand;
import command.RequestHandler;
import command.RequestHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dasha-RV515
 */
@WebServlet("/Controller")
@MultipartConfig
public class Servlet extends HttpServlet {

   // private static final long serialVersionUID = 1L;
    private Object RequestHelper;

    /**
     * Конструктор без параметров
     */
    public Servlet() {
        super();
    }

    /**
     * Метод инициализации сервлета
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * Метод взаимодействия с запросом клиента
     *
     * @param – request запрос
     * @param – resp ответ
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            processRequest(request, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException, ServletException, IOException, SQLException {
        response.setContentType("text/html; charset=UTF-8");
       request.setCharacterEncoding("UTF-8");
       // request.setCharacterEncoding("Cp1251");
        //открытие нового сеанса(сессии)
        HttpSession session = request.getSession(true);
        HashMap<String, Object> hashData = new HashMap<String, Object>();
        HashMap<String, Object> hash = new HashMap<String, Object>();
        ArrayList<String> list = new ArrayList<String>();

        RequestHandler parsingRequest = new RequestHandler();
        RequestHelper requestHelper = new RequestHelper().getInstance();
        ICommand command = requestHelper.getCommand(request);
         System.out.println(request);
        hashData = parsingRequest.parse(request);
        hash = command.execute(hashData);
        list = command.atributeName();
        for (String string : list) {
            session.setAttribute(string, hash.get(string));
        }
        String page = command.responsePage();
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    }
}
