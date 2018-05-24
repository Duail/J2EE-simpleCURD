package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demofirst.UserDao;
import demofirst.UserInfo;

public class ListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int start = 0;
		int count = 5;
		try {
			start = Integer.parseInt(request.getParameter("start"));
		} catch (Exception e) {
		
		}
		int next = start + count;
		int pre = start - count;
		pre = pre < 0 ? 0 : pre;
		int total = new UserDao().getTotal();
		int last = total % count == 0 ? total - count : total - total % count;
		next = next > last ? last : next;
		
		List<UserInfo> userInfos = new UserDao().list(start,count);
		request.setAttribute("next", next);
		request.setAttribute("pre", pre);
		request.setAttribute("last", last);
		request.setAttribute("userinfos", userInfos);
		request.getRequestDispatcher("listUserinfo.jsp").forward(request, response);
	}

}
