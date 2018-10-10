package com.fdmgroup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class ShowUsersServlet
 */
@WebServlet("/allUsers")
public class ShowUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShowUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao userDao = new UserDao();
		
		List<User> userList = userDao.findAll();
		
		PrintWriter out = resp.getWriter();
		
		
		out.println("<hmtl>"
				+ "<body>");
		
		for(int i = 0; i < userList.size(); i++){
			out.println(userList.get(i).getFirstname() + " " 
					+ userList.get(i).getLastname()
					+ "<br/>");
		}
		
		out.println("</body>"
				+ "</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
