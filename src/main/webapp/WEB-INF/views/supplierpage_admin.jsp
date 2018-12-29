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
<body>
<br>
<h2>SupplierPage</h2>(SPRING FORM)
<br>
<spring:form action="reqAdminSpringSupplierDataTtoDB" modelAttribute="supplierObj" enctype="multipart/form-data">
	<br>Supplier Name <spring:input path="suppliername"/>
	<br>Supplier Description <spring:input path="supplierdescription"/>
	<br>Select Image<spring:input type="file" path="imagefile"/>
	<br><spring:button>Add Supplier</spring:button>
</spring:form>
<h2>Supplier Data</h2>
<table border="1">
	<thead>
		<tr>
			<th>SupplierId</th>
			<th>SupplierName</th>
			<th>SupplierDescription</th>
			<th>IsSupplierAvailable</th>
			<th>Logo</th>
			<th>Options</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${suppliers}" var="s">
			<tr>
				<td>${s.supplierid}</td>
				<td>${s.suppliername}</td>
				<td>${s.supplierdescription}</td>
				<td>${s.issupplieravailable}</td>
				<td><img src="resources/images/suppliers/${s.supplierid}.jpg" height="100" width="120"></td>
				<td><a href="reqAdminSupplierEditPage?supplierid=${s.supplierid}">Edit</a> /
				<a href="reqAdminSupplierDelete?supplierid=${s.supplierid}">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table> 
<br>
>> <a href="reqHomePage">PreviousPage</a>
<br>
<a href="j_spring_security_logout">logout</a>
</body>
</html>