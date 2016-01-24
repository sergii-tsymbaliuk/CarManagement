<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new car</title>
</head>
<body>
<form action='<c:url value="/cars/add"/>' method="post">
	<table>
<%-- 		<tr> <td><b>ID</b></td>   <td> </td>     <td><input name="name">${car.id}</td></tr>	 --%>
		<tr> 
			<td><b>Model</b></td>
			<td> </td>     
			<td>
				<select name="carModel">
					<c:forEach var="cm" items="${carModels}">
						<option value="${cm.id}">${cm.name}(${cm.originDate}</option>
					</c:forEach>
				</select> 
			</td>
		</tr>	
		<tr> 
			<td><b>Engine</b></td>   
			<td> </td>     
			<td>
				<select name="engine">
					<c:forEach var="e" items="${carEngines}">
						<option value="${e.id}">${e.model}( Power: ${e.power}, displacement: ${e.displacement}, Cylinders: ${e.numberOfCylinders} )</option>
					</c:forEach>
				</select> 			
			</td>
		</tr>
	</table>
<!-- 	<br> -->
<!-- 	<h3> Tech Records:</h3> -->
<!-- 	<table title="Tech Records"> -->
<!-- 		<tr><td>date</td>	<td>author</td>	<td>text</td></tr> -->
<%-- 		<c:forEach var="tr" items="${car.techRecords}"> --%>
<!-- 			<tr> -->
<%-- 				<td>${tr.date}</td> --%>
<%-- 				<td>${tr.author}</td> --%>
<%-- 				<td>${tr.text}</td> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->
	
<!-- 	<br> -->
<!-- 	<h3> Detales:</h3>	 -->
<!-- 	<table title="Detales"> -->
<!-- 		<tr><td>id</td>	<td>name</td>	<td>producer</td></tr> -->
<%-- 		<c:forEach var="dt" items="${car.carDetails}"> --%>
<!-- 			<tr> -->
<%-- 				<td>${dt.id}</td> --%>
<%-- 				<td>${dt.name}</td> --%>
<%-- 				<td>${dt.producer}</td> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table>	 -->

	<input type="submit">  	
	
</form>
</body>
</html>