package com.nacre.EmployeeAttendance.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.EmployeeAttandance.model.Admin;
import com.nacre.EmployeeAttendance.dao.AdminDao;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminLoginServlet() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		Admin a= new Admin();
		a.setUsername(username);
		a.setPassword(password);
		boolean b=false;
		try {
			b=AdminDao.AdminLogin(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b==true)
		{
			request.getRequestDispatcher("general.html").include(request, response);
		}
		else
		{
			pw.println("OOPS!LOGIN FAILED");
		}
	}

}
