<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Employee Service</title>
</head>
<body>
<%@page import="com.nacre.EmployeeAttendance.dao.*,com.nacre.EmployeeAttandance.model.Employee,java.util.*" %>
<%
LinkedHashSet <Employee> ls=EmpDao.getAllEmployee();
request.setAttribute("ls", ls);
%>
<table border="1" width="90%">  
<tr><th>EmpNo</th><th>EmpName</th><th>EmpSex</th><th>EmpHireDate</th><th>EmpJob</th><th>EmpSalary</th><th>DeptNo</th><th>EmpMail</th><th>update</th><th>delete</th><th>Send Mail</th></tr>
<c:forEach items="${ls}" var="e">
<tr><td>${e. getEmpno()}</td><td>${e.getEmpname()}</td><td>${e.getSex()}</td><td>${e.getHiredate()}</td><td>${e.getJob()}</td><td>${e.getSalary()}</td><td>${e.getDeptno()}</td><td>${e.getEmail()}</td>
<td><a href="updateEmp.jsp?empno=${e.getEmpno()}">Update</a></td> <td><a href="DeleteEmp?empno=${e.getEmpno()}">Delete</a></td>   <td><a href="EmailForm.jsp?empno=${e.getEmpno()}">sendmail</a></td> 
</c:forEach>  
</table>
</body>
</html>