<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ADMIN PAGE
<br>
Hi!!!${customer.custname}
<br>
<img src="resources/images/customers/${customer.customerid}.jpg" height="100" width="120"/>
<br>
<a href="reqAdminProductPage">Manage</a> Products
<br>
<a href="reqAdminSupplierPage">Manage</a>Suppliers
<br>
<a href="reqAdminXps">Manage</a> X-maps Products+Suppliers
<br>
<a href="j_spring_security_logout">logout</a>
</body>
</html>