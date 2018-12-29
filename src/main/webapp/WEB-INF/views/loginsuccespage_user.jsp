<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
LoginSuccess page
<br>
Hi!! ${customer.custname}
<br>
<img src="resources/images/customers/${customer.customerid}.jpg" height="100" width="120"/>
<br>
<table >
	<thead>
		<tr>
			<th>Image </th>
			<th> Productname</th>
			<th> Supplier Name </th>
			<th> Product Price </th>
			<th> Product Stock </th>
			<th> Options</th>
		<tr>
	</thead>
	<tbody>
		<c:forEach items="${vwprdsup}" var="v">
			<tr>
				<td><img src="resources/images/products/${v.productid}.jpg" height="100" width="120"/></td>
				<td>${v.productname}</td>
				<td>${v.suppliername}</td>
				<td>${v.xpsprice}</td>
				<td>${v.xpsstock}</td>
				<td><a href="reqMoreSuppliers?pid=${v.productid}">MoreDetails</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<a href="j_spring_security_logout">logout</a>
</body>
</html>