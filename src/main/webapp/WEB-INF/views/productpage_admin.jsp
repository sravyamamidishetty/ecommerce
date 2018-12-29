<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
</head>
<body bgcolor="skyblue">
<br>
<!-- <h2>Productform</h2> (HTML) 
<br>
<form action="reqAdminSendProductDataToDB" >
	<br>ProductName<input type="text" name="productname" style="color:black;background-color:yellow"/>
	<br>ProductDescription<input type="text" name="productdescription" style="color:black;background-color:yellow"/>
	<input type="submit" value="submit"/>
	<br>
</form> -->
<h2>Productform</h2> (Spring)
<br> 
<spring:form action="reqAdminSendProductDataToDB1" modelAttribute="productObject" enctype="multipart/form-data">
	<br>Product Name <spring:input path="productname"/>
	<br>Product Description <spring:input path="productdescription"/>
	<br>Select Image: <spring:input type="file" path="imagefile"/>
	<br><spring:button>Add Product</spring:button>
</spring:form>	
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
			<th>Edit/Delete</th>
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
			<td><a href="reqAdminEditProductPage?productid=${p.productid}">Edit </a> /    <!-- query String -->
				<a href="reqAdminDeleteProductPage?productid=${p.productid}">Delete </a></td>
			</tr>
			</c:forEach>
	</tbody>
</table>
<br>
<a href="j_spring_security_logout">logout</a>
</body>
</html>