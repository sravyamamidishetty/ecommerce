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
<h2>Product Data</h2>
<br>
<table border="1">
	<thead>
		<tr>
			<th>ProductId</th>
			<th>ProductName</th>
			<th>Description</th>
			<th>IsProductavailable</th>
			<th>Image</th>
		</tr>
	</thead>		
	<tbody>
		<c:forEach items="${products}" var="p">
				<tr>
			<td>${p.productid}</td>
			<td>${p.productname}</td>
			<td>${p.productdescription}</td>
			<td>${p.isproductavailable}</td>
			<td><img src="resources/images/products/${p.productid}.jpg" height="100" width="120"></td>
			</tr>
			</c:forEach>
	</tbody>
</table>
<a href="reqHomePage">BackToHome</a>
</body>
</html>