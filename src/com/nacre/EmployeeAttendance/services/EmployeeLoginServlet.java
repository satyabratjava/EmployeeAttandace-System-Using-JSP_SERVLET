package com.nacre.EmployeeAttendance.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.EmployeeAttandance.model.Employee;
import com.nacre.EmployeeAttendance.dao.EmpDao;

@WebServlet("/EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter();
		Employee e = new Employee();
		e.setName(name);
		e.setPassword(password);
		boolean b=true;
		b=EmpDao.emplogin(e);
		if(b==true)
		{
			request.getRequestDispatcher("ReportGenerate.jsp").include(request, response);
		}
		else
		{
			pt.println("ohh!sorry!Invalid name or password");
		}
	}

}
