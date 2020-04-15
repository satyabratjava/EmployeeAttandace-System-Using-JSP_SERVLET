package com.nacre.EmployeeAttendance.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.EmployeeAttandance.model.Employee;
import com.nacre.EmployeeAttendance.dao.EmpDao;

@WebServlet("/GetAllEmployeeServlet")
public class GetAllEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllEmployeeServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pt=response.getWriter();
		response.setContentType("text/html");
		pt.println("<h1>Employee List</h1>");
		
		LinkedHashSet<Employee> ls=EmpDao.getAllEmployee();
		pt.println("<table border='1' width='100%'>");
		pt.println("<tr><th>EmpNo</th><th>EmpName</th><th>EmpSex</th><th>EmpHireDate</th><th>EmpJob</th><th>EmpSalary</th><th>DeptNo</th><th>EmpMail</th></tr>");
		
		for(Employee e:ls)
		{
			pt.println("<tr><td>"+e.getEmpno()+"</td><td>"+e.getEmpname()+"</td><td>"+e.getSex()+"</td><td>"+e.getHiredate()+"</td><td>"+e.getJob()+"</td><td>"+e.getSalary()+"</td><td>"+e.getDeptno()+"</td><td>"+e.getEmail()+"</td></tr>");
		}
		pt.println("</table>");
	
	}

}
