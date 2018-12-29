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
<h2>Page 2</h2>
<h3>Student Academic Info</h3>
<spring:form commandName="dataObject">
Student Rollno.<spring:input path="studentrno"/>
<br>Student marks<spring:input path="marks[0]" size="3"/>
				<spring:input path="marks[1]" size="3"/>
				<spring:input path="marks[2]" size="3"/>
				<spring:input path="marks[3]" size="3"/>
				<spring:input path="marks[4]" size="3"/>

<br><spring:button name="_eventId_backOnPage2">Back</spring:button>
<spring:button name="_eventId_nextOnPage2">Next</spring:button>
</spring:form>
<a href="reqHomePage">Home</a>
	
</body>
</html>