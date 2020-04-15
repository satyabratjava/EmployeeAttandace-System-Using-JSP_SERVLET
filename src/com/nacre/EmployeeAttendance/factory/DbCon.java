package com.nacre.EmployeeAttendance.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	public static Connection GetConnection()
	{
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","8249");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
}
