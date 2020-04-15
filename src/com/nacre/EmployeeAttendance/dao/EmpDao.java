package com.nacre.EmployeeAttendance.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;

import com.nacre.EmployeeAttandance.model.Employee;
import com.nacre.EmployeeAttendance.factory.DbCon;
public class EmpDao {
	public static boolean emplogin(Employee e)
	{
		Connection con=DbCon.GetConnection();
		try {
			PreparedStatement pst=con.prepareStatement("select name,password from emplogin where name=? and password=?");
			pst.setString(1, e.getName());
			pst.setString(2, e.getPassword());
		ResultSet rs=pst.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}
	public static int employeeregister(Employee e)
	{
		Connection con=DbCon.GetConnection();
		try {
			PreparedStatement pst=con.prepareStatement("insert into emplogin (name,password,mail)values(?,?,?) ");
			pst.setString(1,e.name);
			pst.setString(2,e.password);
			pst.setString(3, e.mail);
			pst.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
		
	}
	public static int RegisterEmp(Employee e) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyy"); 
		  java.util.Date jud=sdf.parse(e.hiredate);
		  long ms=jud.getTime(); 
		  java.sql.Date hdate=new java.sql.Date(ms); 
		Connection con=DbCon.GetConnection();
		try {
			PreparedStatement pst=con.prepareStatement
					("insert into emp (emp_no,emp_name,emp_sex,emp_hiredate,emp_job,emp_salary,dept_no,emp_mail)values(?,?,?,?,?,?,?,?)");
			int nextvalue=EmpDao.getkey();
			pst.setInt(1,nextvalue);
			pst.setString(2,e.empname);
			pst.setString(3,e.sex);
			pst.setDate(4,hdate);
			pst.setString(5,e.job);
			pst.setString(6,e.salary);
			pst.setString(7,e.deptno);
			pst.setString(8,e.email);
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 0;
	}

	private static int getkey() {
		int nextvalue=0;
		Connection con=DbCon.GetConnection();
		try {
			PreparedStatement pst=con.prepareStatement("select satya_auto.nextval from dual");
			 ResultSet rs=pst.executeQuery();
			 rs.next();
			 nextvalue=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nextvalue;
	}
	public static  LinkedHashSet <Employee> getAllEmployee()
	{
		LinkedHashSet <Employee> ls=new LinkedHashSet<Employee>();
		Connection con =DbCon.GetConnection();
		try {
			PreparedStatement pst=con.prepareStatement("select * from emp");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Employee e =new Employee();
				e.setEmpno(rs.getInt(1));
				e.setEmpname(rs.getString(2));
				e.setSex(rs.getString(3));
				e.setHiredate(rs.getString(4));
				e.setJob(rs.getString(5));
				e.setSalary(rs.getString(6));
				e.setDeptno(rs.getString(7));
				e.setEmail(rs.getString(8));
				ls.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
		
	}
	public static Employee getEmpById(int empno)
	{
		Connection con=DbCon.GetConnection();
		Employee e = new Employee();
		try {
			PreparedStatement pst=con.prepareStatement("select * from emp where emp_no=?");
			pst.setInt(1,empno);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				e.setEmpno(rs.getInt("emp_no"));
				e.setEmpname(rs.getString("emp_name"));
				e.setSex(rs.getString("emp_sex"));
				e.setHiredate(rs.getString("emp_hiredate"));
				e.setJob(rs.getString("emp_job"));
				e.setSalary(rs.getString("emp_salary"));
				e.setDeptno(rs.getString("dept_no"));
				e.setEmail(rs.getString("emp_mail"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
		
	}
	public static int UpdateEmp(Employee e)
	{
		Connection con = DbCon.GetConnection();
		String sql="update emp set emp_name=?,emp_sex=?,emp_hiredate=?,emp_job=?,emp_salary=?,dept_no=?,emp_mail=? where emp_no=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, e.getEmpname());
			pst.setString(2, e.getSex());
			pst.setString(3, e.getHiredate());
			pst.setString(4, e.getJob());
			pst.setString(5, e.getSalary());
			pst.setString(6, e.getDeptno());
			pst.setString(7, e.getEmail());
			pst.setInt(8, e.getEmpno());
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 0;
	}
	public static boolean deleteemp(int empno)
	{
		Connection con=DbCon.GetConnection();
		String sql="delete from emp where emp_no=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, empno);
			pst.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
		
	}
	public static boolean sendmail(int empno)
	{
		Connection con =DbCon.GetConnection();
		try {
			PreparedStatement pst=con.prepareStatement("select emp_mail from emp where emp_no=?");
			pst.setInt(1,empno );
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				return true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
		
		
	}
	
	public static boolean groupbyDeptNo(int deptno)
	{
		Connection con=DbCon.GetConnection();
		String sql=" select * from emp where dept_no=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, deptno);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				int empno=rs.getInt("emp_no");
				String ename=rs.getString("emp_name");
				String sex=	rs.getString("emp_sex");
				Date date=	rs.getDate("emp_hiredate");
				String job=	rs.getString("emp_job");
				Integer sal=rs.getInt("emp_salary");
				String mail=rs.getString("emp_mail");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
}

/*
 * CREATE SEQUENCE satya_auto MINVALUE 1 MAXVALUE 999999999999 INCREMENT BY
 * 1 START WITH 1 NOCACHE NOORDER NOCYCLE;
 */


