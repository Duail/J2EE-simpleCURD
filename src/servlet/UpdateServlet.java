package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demofirst.UserDao;
import demofirst.UserInfo;

public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		UserInfo userInfo = new UserInfo();
		userInfo.setId(id);
		userInfo.setName(name);
		userInfo.setEmail(email);
		userInfo.setTelephone(telephone);
		
		new UserDao().update(userInfo);
		
		response.sendRedirect("listUserinfo");
	}

}
