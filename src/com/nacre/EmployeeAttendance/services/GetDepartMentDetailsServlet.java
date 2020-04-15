package com.nacre.EmployeeAttendance.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.EmployeeAttandance.model.Department;
import com.nacre.EmployeeAttendance.dao.DeptDao;

@WebServlet("/GetDepartMentDetailsServlet")
public class GetDepartMentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetDepartMentDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter ptr=response.getWriter();
		response.setContentType("text/html");
		ptr.println("<h1>Department List</h1>");
		
		ArrayList <Department> al=DeptDao.GetDepartmentDetails();
		ptr.println("<table border='1' width='100%'>");
		ptr.println(" <tr><th>DeptNo</th><th>DeptName</th><th>DeptLoc</th></tr> ");
		for(Department d:al)
		{
			ptr.println(" <tr><td>"+d.getDeptno()+"</td><td>"+d.getDeptname()+"</td><td>"+d.getDeptloc()+"</td></tr>  ");
		}
		ptr.println("</table>");
		
	}

}
