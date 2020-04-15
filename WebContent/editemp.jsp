<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Service</title>
</head>
<body>
<%
String empno=request.getParameter("empno");
%>
<%@page import="com.nacre.EmployeeAttendance.dao.*" %>
<jsp:useBean id="e" class="com.nacre.EmployeeAttandance.model.Employee"></jsp:useBean> 
<jsp:setProperty property="*" name="e"/>  
<%
int i=EmpDao.UpdateEmp(e);
response.sendRedirect("viewemp.jsp");
%> 
</body>
</html>