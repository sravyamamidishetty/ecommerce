<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
</head>
<body>
<h2>Product Edit page</h2>
<spring:form  action="reqAdminUpdateproduct" commandName="product" enctype="multipart/form-data">
	<spring:hidden path="productid"/>
	<br>Product Name<spring:input path="productname"/>
	<br>ProductDescription<spring:input path="productdescription"/>
	<br>IsProductavailable
	<br><spring:radiobutton path="isproductavailable" value="true"/>true
	<spring:radiobutton path="isproductavailable" value="false"/>false
	<br><spring:button>Update</spring:button>
</spring:form>
</body>
</html>