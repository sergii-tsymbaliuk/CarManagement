<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit car</title>
</head>
<body>

<form action='<c:url value="/cars/edit"/>' method="post">
	<table>
		<tr> <td><b>ID</b></td>   <td> </td>     <td><input name="id" type="text" readonly="readonly">${car.id}</td></tr>	
		<tr> 
			<td><b>Model</b></td>
			<td> </td>     
			<td>
				<select name="carModelId">
					<c:forEach var="cm" items="${carModels}">
						<c:choose >
						<c:when test="${car.carModel.id==cm.id}">
							<option selected="selected" value="${cm.id}">${cm.name}(${cm.originDate}</option>
						</c:when>
						<c:otherwise>
							<option value="${cm.id}">${cm.name}(${cm.originDate}</option>
						</c:otherwise>
						</c:choose>
					</c:forEach>
				</select> 
			</td>
		</tr>	
		<tr> 
			<td><b>Engine</b></td>   
			<td> </td>     
			<td>
				<select name="engineId">
					<c:forEach var="e" items="${carEngines}">
						<c:choose>
						<c:when test="${car.engine.id==e.id}">
							<option selected="selected" value="${e.id}">${e.model}( Power: ${e.power}, displacement: ${e.displacement}, Cylinders: ${e.numberOfCylinders} )</option>
						</c:when>
						<c:otherwise>
							<option value="${e.id}">${e.model}( Power: ${e.power}, displacement: ${e.displacement}, Cylinders: ${e.numberOfCylinders} )</option>
						</c:otherwise>
						</c:choose>
					</c:forEach>
				</select> 			
			</td>
		</tr>
	</table>
	
<%-- <form:form commandName="car" method="POST"> --%>
<%-- 	<form:hidden path="id" /> --%>
<!-- 	<table> -->
<!-- 		<tr>  -->
<!-- 			<td><b>Model:</b></td> -->
<!-- 			<td> </td>      -->
<!-- 			<td> -->
<%-- 				<form:select path="carModel" items="${carModels}" /> --%>
<!-- 			</td> -->
<!-- 		</tr>	 -->
<!-- 		<tr>  -->
<!-- 			<td><b>Engine:</b></td>    -->
<!-- 			<td> </td>      -->
<!-- 			<td> -->
<%-- 				<form:select path="engine" items="${carEngines}"/> --%>
<!-- 			</td> -->
<!-- 		</tr> -->
		
<!-- 	</table> -->
<%-- 	<b>Description:</b><br>	<form:textarea path="description"/> --%>
	
	<b>Description:</b><br>	
	<input type="text" name="description" value="${car.description}"/>
	
	<input type="submit" value="Save"/>  	
<%-- </form:form> --%>
	</form>
</body>
</html>