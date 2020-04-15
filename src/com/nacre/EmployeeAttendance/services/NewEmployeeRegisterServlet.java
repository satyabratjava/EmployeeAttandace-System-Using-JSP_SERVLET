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

@WebServlet("/NewEmployeeRegisterServlet")
public class NewEmployeeRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewEmployeeRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String mail=request.getParameter("mail");
		PrintWriter ptr=response.getWriter();
		response.setContentType("text/html");
		Employee e =new Employee();
		e.setName(name);
		e.setPassword(password);
		e.setMail(mail);
		int i=EmpDao.employeeregister(e);
		if(i>=0)
		{
			request.getRequestDispatcher("employeelogin.html").include(request, response);
		}
		else
		{
			ptr.println("opss!some thing went wrong");
		}
		
	}

}
