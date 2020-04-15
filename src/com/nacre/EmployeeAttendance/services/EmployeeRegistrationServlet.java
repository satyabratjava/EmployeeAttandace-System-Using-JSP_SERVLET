package com.nacre.EmployeeAttendance.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.EmployeeAttandance.model.Employee;
import com.nacre.EmployeeAttendance.dao.EmpDao;

@WebServlet("/EmployeeRegistrationServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EmployeeRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String date=request.getParameter("hdate");
		String job=request.getParameter("job");
		String salary=request.getParameter("salary");
		String deptno=request.getParameter("deptno");
		String mail=request.getParameter("email");
		PrintWriter pw=response.getWriter();
		Employee e =new Employee();
		e.setEmpname(name);
		e.setSex(sex);
		e.setHiredate(date);
		e.setJob(job);
		e.setSalary(salary);
		e.setDeptno(deptno);
		e.setEmail(mail);
		int i;
		try {
			i = EmpDao.RegisterEmp(e);
			if(i>=0)
			{
				RequestDispatcher dr = request.getRequestDispatcher("EmployeeRegistration.html");
				dr.forward(request, response);
			}
			else
			{
				pw.println("not saved");
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}
