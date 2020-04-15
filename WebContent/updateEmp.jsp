<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update employee</title>
</head>
<body>
<%@page import="com.nacre.EmployeeAttendance.dao.*,com.nacre.EmployeeAttandance.model.Employee"%>
<%
String empno=request.getParameter("empno");
Employee e =EmpDao.getEmpById(Integer.parseInt(empno));
%>

<form action="editemp.jsp" method="post">  
<input type="hidden" name="empno" value="<%=e.getEmpno() %>"/>  
<table> 

<tr><td><h4>Name:</h4></td><td><input type =text name="name" value="<%=e.getEmpname() %>"></td></tr>
<tr><td><h4>Sex:</h4></td>
<td><input type="radio" name="sex" value="male">Male
<input type="radio" name="sex" value="female">Female </td></tr>
	<tr><td><h4>HireDate:</h4></td><td><input type="date" name="hdate" value="<%=e.getHiredate() %>"></td></tr>
	<tr><td><h4>JOB:</h4></td><td><input type="text" name="job" value="<%=e.getJob() %>"></td></tr>
	<tr><td><h4>Salary:</h4></td><td><input type="text" name="salary" value="<%=e.getSalary() %>"></td></tr>
	<tr><td><h4>DeptNo:</h4></td><td><input type="text" name="deptno" value="<%=e.getDeptno() %>"></td></tr>
	<tr><td><h4>Email:</h4></td><td><input type="email" name="email" value="<%=e.getEmail() %>"></td></tr>
	<tr><td><h4>Update:</h4></td><td><input type="submit" value="submit"></td></tr>
</table>
</form>
</body>
</html>