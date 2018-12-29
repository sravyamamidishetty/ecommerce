<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</head>
<body>
<h2>Page1</h2>
<h3>Student Basic Informatiom</h3>
<spring:form commandName="dataObject">

Student name <spring:input path="studentname"/>
<br>
Student email id <spring:input path="studentemail"/>
<br>
Student mobile no. <spring:input  path="studentmobileno"/>
<br>
 
  <spring:button  name="_eventId_nextOnPage1">Next</spring:button>
  <br>
 
</spring:form>
<a href="reqHomePage">Home</a>
</body>
</html>