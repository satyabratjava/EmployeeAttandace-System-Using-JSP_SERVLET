<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report page</title>
</head>
<body background="b1.jpg">
<form action="ReportServlet" method="post">
<table border="0" width="300" align="center">
<tr><td colspan="2" style="font-size:30pt;" align="center">
<h3>Get Your Report</h3></td></tr>
<tr><td>EmpNo:</td><td><input type="text" name="empno"></td></tr>
<tr><td colspan="2" align="center">
<input type="submit" value="Get Report"></td></tr>
</table>
</form>
</body>
</html>