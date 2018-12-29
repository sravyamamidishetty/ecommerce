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
<table>
	<tr>
	<td><img src="resources/images/products/${vwxps_all_sup_data.get(0).productid}.jpg"  height="200" width="280"/></td>
		<td>${vwxps_all_sup_data.get(0).productname}
		<br>
		${vwxps_all_sup_data.get(0).productdescription}</td>
	</tr>
	</table>
<br>
<table border="1">
	<thead>
		<tr>
			<th>Supplier</th>
			<th>Price</th>
			<th>Stock</th>
			<th>Option</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${vwxps_all_sup_data}" var="v">
			<tr>
				<td>${v.suppliername}</td>
				<td>${v.xpsprice}</td>
				<td>${v.xpsstock}</td>
				<td>Add to Cart</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<a href="reqforPreviousPage">>>PreviousPage</a>
<br>
<a href="j_spring_security_logout">logout</a>
</body>
</html>