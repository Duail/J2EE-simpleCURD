package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demofirst.UserDao;
import demofirst.UserInfo;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo userInfo = new UserInfo();
		userInfo.setName(request.getParameter("name"));
		userInfo.setEmail(request.getParameter("email"));
		userInfo.setTelephone(request.getParameter("telephone"));
		
		new UserDao().add(userInfo);
		
		response.sendRedirect("listUserinfo");
	}

}
