package com.nacre.EmployeeAttendance.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.EmployeeAttendance.dao.EmpDao;
import com.nacre.EmployeeAttendance.factory.DbCon;

/**
 * Servlet implementation class SearchByDeptNoServlet
 */
@WebServlet("/SearchByDeptNoServlet")
public class SearchByDeptNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByDeptNoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno=Integer.parseInt( request.getParameter("deptno"));
		PrintWriter ptr=response.getWriter();
		response.setContentType("text/html");
		 ptr.print("<table width='100%' border='1' >");
		  ptr.print("<tr><th>EmpNo</th><th>EmpName</th><th>EmpSex</th><th>EmpHireDate</th> <th>EmpJob</th><th>EmpSalary</th><th>EmpMail</th> <th>deptno</th></tr>"
				   );
		  ptr.println("</table>");
		  Connection con=DbCon.GetConnection();
			String sql=" select * from emp where dept_no=?";
			try {
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setInt(1, deptno);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					int no=rs.getInt("emp_no");
					String ename=rs.getString("emp_name");
					String sex=	rs.getString("emp_sex");
					Date date=	rs.getDate("emp_hiredate");
					String job=	rs.getString("emp_job");
					Integer sal=rs.getInt("emp_salary");
					Integer dept=rs.getInt("dept_no");
					String mail=rs.getString("emp_mail");
					ptr.print("<table width='100%' border='1' >");
					  
					  ptr.println("<tr><td align='center'>"+no+"</td><td align='center'>"+ename+"</td>  <td align='center'>"
					  +sex+"</td> " +
					  "  <td align='center'>"+date+"</td>   <td align='center'>"+job+"</td>  <td align='center'>"+sal+"</td> <td align='center'>"
					  +mail+"</td> <td align='center'>"+dept+"</td></tr>");
						 
						ptr.println("</table>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
}
