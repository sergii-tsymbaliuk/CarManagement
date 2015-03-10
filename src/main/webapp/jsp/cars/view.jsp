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
		<tr> <td><b>ID</b></td>   <td> </td>     <td>${car.id}</td></tr>	
		<tr> <td><b>Model</b></td>   <td> </td>     <td>${car.carModel.name}(${car.carModel.originDate})</td></tr>	
		<tr> <td><b>Engine</b></td>   <td> </td>     <td>${car.engine.model}</td></tr>
		<tr> <td><b>Power</b></td>   <td> </td>    <td>${car.engine.power}</td></tr>
		<tr> <td><b>Displacement</b></td>   <td> </td>     <td>${car.engine.displacement}</td></tr>
		<tr> <td><b>NumberOfCylinders</b></td>   <td> </td>     <td>${car.engine.numberOfCylinders}</td></tr>
	</table>
	<br>
	<h3> Tech Records:</h3>
	<table title="Tech Records">
		<tr><td>date</td>	<td>author</td>	<td>text</td></tr>
		<c:forEach var="tr" items="${car.techRecords}">
			<tr>
				<td>${tr.date}</td>
				<td>${tr.author}</td>
				<td>${tr.text}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<h3> Details:</h3>	
	<table title="Details">
		<tr><td>id</td>	<td>name</td>	<td>producer</td></tr>
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