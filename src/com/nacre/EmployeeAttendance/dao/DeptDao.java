package com.nacre.EmployeeAttendance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nacre.EmployeeAttandance.model.Department;
import com.nacre.EmployeeAttendance.factory.DbCon;

public class DeptDao {
	public static int adddept(Department d)
	{
		Connection con=DbCon.GetConnection();
		try {
			PreparedStatement pst=con.prepareStatement("insert into dept values(?,?,?)");
			pst.setInt(1,d.deptno);
			pst.setString(2, d.deptname);
			pst.setString(3, d.deptloc);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static ArrayList <Department>  GetDepartmentDetails()
	{
		Connection con=DbCon.GetConnection();
		ArrayList <Department> al=new ArrayList<Department>();
		try {
			PreparedStatement pst=con.prepareStatement("select * from dept");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Department d=new Department();
				d.setDeptno(rs.getInt(1));
				d.setDeptname(rs.getString(2));
				d.setDeptloc(rs.getString(3));
				al.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

}
