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
<h2>Page2</h2>
<h3>Student Result</h3>
<br>Student Name : ${dataObject.studentname}
<br>Student EmailId : ${dataObject.studentemail}
<br>Student Mobile no. : ${dataObject.studentmobileno}
<br>Student Roll no. : ${dataObject.studentrno}
<br>Student Marks : 
<br><c:forEach items="${dataObject.marks}" var="m">
		<br>${m}
	</c:forEach>
	<c:if test="${dataObject.result=='PASS'}">
	<br>Result : ${dataObject.result}
	<br>Total : ${dataObject.total}
	<br>Average : ${dataObject.average}
	<br>Grade : ${dataObject.grade}
	</c:if>
<br><spring:form commandName="dataObject">
<spring:button name="_eventId_backOnPage3">Back</spring:button>

</spring:form>
<a href="reqHomePage">Home</a>
	
</body>
</html>