<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Car Management System</title>
</head>
<body>
	<table>
		<tr> <td><b><s:message code="id"/></b></td>   <td> </td>     <td>${car.id}</td></tr>	
		<tr> <td><b><s:message code="model"/></b></td>   <td> </td>     <td>${car.carModel.name}(${car.carModel.originDate})</td></tr>	
		<tr> <td><b><s:message code="engine"/></b></td>   <td> </td>     <td>${car.engine.model}</td></tr>
		<tr> <td><b><s:message code="power"/></b></td>   <td> </td>    <td>${car.engine.power}</td></tr>
		<tr> <td><b><s:message code="displacement"/></b></td>   <td> </td>     <td>${car.engine.displacement}</td></tr>
		<tr> <td><b><s:message code="numberofcylinders"/></b></td>   <td> </td>     <td>${car.engine.numberOfCylinders}</td></tr>
	</table>
	<br>
	<s:message var="tr_title" code="techrecords"/>
	<h3>${tr_title}:</h3>
	<table title="${tr_title}">
		<tr>
			<td><s:message code="date"/></td>	
			<td><s:message code="author"/></td>	
			<td><s:message code="text"/></td>
		</tr>
		<c:forEach var="tr" items="${car.techRecords}">
			<tr>
				<td><fmt:formatDate type="both" value="${tr.date}" dateStyle="SHORT" timeStyle="SHORT"/></td>
				<td>${tr.author}</td>
				<td>${tr.text}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<s:message code="details" var="dt_title"/>
	<h3> ${dt_title}:</h3>	
	<table title="${dt_title}">
		<tr><td><s:message code="id"/></td>	
		<td><s:message code="name"/></td>	
		<td><s:message code="producer"/></td></tr>
		<c:forEach var="dt" items="${car.carDertails}">
			<tr>
				<td>${dt.id}</td>
				<td>${dt.name}</td>
				<td>${dt.producer}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="edit" method="get">
		<input type="hidden" name="id" value ="${car.id}"/>
    	<input type="submit" value="Edit"/>
	</form>
	<form action="delete" method="post">
		<input type="hidden" name="id" value ="${car.id}"/>
    	<input type="submit" value="Delete"/>
	</form>	
</body>
</html>