package command;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class RequestHandler {
	private HashMap<String, Object> mapLogin;

	public RequestHandler() {
		super();
		mapLogin = new HashMap<String, Object>();
	}

	public HashMap<String, Object> parse(HttpServletRequest request) {
            //получает имена параметров из формы
		Enumeration<String> en = request.getParameterNames();
		Wrapper reqWrapper = new Wrapper();
		reqWrapper.setRequest(request);
		
		while (en.hasMoreElements()) {
			String paramName = (String) en.nextElement();
                        //установить имя параметра и его значение
			//mapLogin.put(paramName, request.getParameter(paramName));
                        if(paramName.equals("descripService")){
                          mapLogin.put(paramName, request.getParameterValues(paramName));  
                        }
                        else{
                            mapLogin.put(paramName, request.getParameter(paramName));
                        }
			System.out.println(paramName + " !!!!!!!!!!!!!1= " + request.getParameter(paramName));
		}
		mapLogin.put("sessionClose", reqWrapper);
		
		return mapLogin;
	}

}

