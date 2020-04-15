package com.nacre.EmployeeAttendance.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.EmployeeAttendance.dao.EmpDao;

@WebServlet("/DeleteEmp")
public class DeleteEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteEmp() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emplno=request.getParameter("empno");
		PrintWriter ptr=response.getWriter();
		int empno=Integer.parseInt(emplno);
		
		boolean b=false;
		b=EmpDao.deleteemp(empno);
		if(b==true)
		{
			RequestDispatcher rd=request.getRequestDispatcher("viewemp.jsp");
			rd.forward(request, response);
		}
		else
			ptr.println("soory");
			
	}
}
