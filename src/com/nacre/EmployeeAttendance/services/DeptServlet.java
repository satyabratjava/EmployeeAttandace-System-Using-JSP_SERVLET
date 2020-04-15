package com.nacre.EmployeeAttendance.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.EmployeeAttandance.model.Department;
import com.nacre.EmployeeAttendance.dao.DeptDao;

@WebServlet("/DeptServlet")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeptServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		String deptname=request.getParameter("deptname");
		String deptloc=request.getParameter("deptloc");
		PrintWriter ptr=response.getWriter();
		Department d=new Department();
		d.setDeptno(deptno);
		d.setDeptname(deptname);
		d.setDeptloc(deptloc);
		int i=DeptDao.adddept(d);
		if(i>=0)
		{
			ptr.println("sucessfully added");
		}
		else
		{
			ptr.println("failed to add");
		}
		
	}

}
