<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Management System</title>
</head>
<body>
	<table>
	<tr>
			<td>ID</td>		
<!-- 			<td>CarType</td>		 -->
			<td>Model</td>	
			<td>Engine</td>
			<td>Power</td>
			<td>Displacement</td>
			<td>NumberOfCylinders</td>
<!-- 			<td>Color</td> -->
	</tr>
	<c:forEach var="c" items="${cars}">
		<tr>
			<td>${c.id}</td>
			<!-- Type -->
<%-- 			<td>${c.carType}</td>		 --%>
			<!-- Model -->
			<td>${c.carModel.name}(${c.carModel.originDate})</td>	
			<!-- Engine		 -->
			<td>${c.engine.model}</td>
			<td>${c.engine.power}</td>
			<td>${c.engine.displacement}</td>
			<td>${c.engine.numberOfCylinders}</td>
			<!-- Color -->
<%-- 			<td>${c.color.name}(${c.color.value})</td> --%>
		</tr>
	</c:forEach>
	</table>
</body>
</html>