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
SignUp Page
<br>
<spring:form  action="reqSignUpDataToDB" modelAttribute="customer" enctype="multipart/form-data">
<spring:hidden path="billingAddress.houseno"/>
<spring:hidden path="cart.grandtotal"/>

<br>CustomerName <spring:input path="custname"/>
<br>CustomerEmailId<spring:input path="custemailid"/>
<br>CustomerMobileNo<spring:input path="custmobileno"/>
<br>Select Image<spring:input type="file" path="imagefile"/>
	
<br>Password<spring:input type="password" path="userDetails.password"/>
	
<br>House No<spring:input path="shippingAddress.houseno"/>
<br>Street <spring:input path="shippingAddress.street"/>
<br>Area<spring:input path="shippingAddress.area"/>
<br>City<spring:input path="shippingAddress.city"/>
<br>State<spring:input path="shippingAddress.state"/>
<br>Country<spring:input path="shippingAddress.country"/>
<br>Pincode<spring:input path="shippingAddress.pincode"/>
<br><spring:button>SignUp</spring:button>
</spring:form>
</body>
</html>