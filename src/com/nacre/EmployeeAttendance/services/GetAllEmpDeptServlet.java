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

import com.nacre.EmployeeAttendance.factory.DbCon;

@WebServlet("/GetAllEmpDeptServlet")
public class GetAllEmpDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllEmpDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		Connection con=DbCon.GetConnection();
		String sql=" select emp_no,emp_name,dept_name,emp_sex,emp_hiredate,emp_job,emp_salary,emp_mail,"
				+ "dept_loc from emp,dept where emp.dept_no=dept.dept_no order by emp_name";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			Integer no=rs.getInt("emp_no");
			String ename=rs.getString("emp_name");
			String dname=rs.getString("dept_name");
			String sex=	rs.getString("emp_sex");
			Date date=	rs.getDate("emp_hiredate");
			String job=	rs.getString("emp_job");
			Integer sal=rs.getInt("emp_salary");
			String mail=rs.getString("emp_mail");
			String loc=	rs.getString("dept_loc");
			
			pw.print("<body background='b1.jpg'>");
			pw.print("<table width='85%' border='1' >");
			  pw.print("<tr><th>EmpNo</th><th>EmpName</th><th>DeptName</th><th>EmpSex</th><th>EmpHireDate</th> <th>EmpJob</th><th>EmpSalary</th><th>EmpMail</th><th>DeptLoc</th></tr>"
			  );
			 
             pw.println("<tr><td align='center' width='5%'>"+no+"</td><td align='center'width='10%'>"+ename+"</td> <td align='center' 'width='10%'>"+dname+"</td> <td align='center' 'width='10%'>"
				  +sex+"</td> " +
				  "  <td align='center' 'width='10%'>"+date+"</td>   <td align='center' 'width='10%'>"+job+"</td>  <td align='center' 'width='10%'>"+sal+"</td> <td align='center' 'width='10%'>"
				  +mail+"</td> <td align='center' 'width='10%'>"+loc+"</td> </tr>");
 
				pw.println("</table>");
				 pw.print("</body>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
	
		}
	}


}
