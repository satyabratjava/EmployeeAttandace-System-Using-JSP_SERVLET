package com.nacre.EmployeeAttendance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nacre.EmployeeAttandance.model.Admin;
import com.nacre.EmployeeAttendance.factory.DbCon;

public class AdminDao {

	public static boolean AdminLogin(Admin a) throws SQLException {
		Connection con=DbCon.GetConnection();
		PreparedStatement pst=con.prepareStatement("select name,password from adminlogin where name=? and password=?");
		pst.setString(1, a.getUsername());
		pst.setString(2, a.getPassword());
		ResultSet rs=pst.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
		
	}

}
