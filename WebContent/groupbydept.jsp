<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Employee</title>
</head>
<body>
<%@page import="com.nacre.EmployeeAttendance.dao.*,com.nacre.EmployeeAttandance.model.Employee"%>
<%
Employee e=new Employee();
%>
<table border="1" width="90%">  
<tr><th>EmpNo</th><th>EmpName</th><th>EmpSex</th><th>EmpHireDate</th><th>EmpJob</th><th>EmpSalary</th><th>DeptNo</th><th>EmpMail</tr>
<tr><td>${e. getEmpno()}</td></tr>
</table>
</body>
</html>