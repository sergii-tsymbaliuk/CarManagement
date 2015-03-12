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

<c:url var="post_url"  value="/cars/edit" />
<form:form commandName="car" method="POST" action="${post_url}">
<h1>Editing car ${car.id}</h1>
	<table>
		<tr> <td><b>ID</b></td>   <td> </td>     <td><input name="id" type="hidden" readonly="readonly" value="${car.id}"></td></tr>	
		<tr> 
			<td><b>Model</b></td>
			<td> </td>     
			<td>
				<form:select path="carModel" items="${carModels}" itemLabel="name" itemValue="id"/>
			</td>
		</tr>	
		<tr> 
			<td><b>Engine</b></td>   
			<td> </td>     
			<td>
				<form:select path="engine" items="${carEngines}" itemLabel="model" itemValue="id"/>
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
	<b>Description:</b><br>	<form:textarea path="description"/>
	
<!-- 	<b>Description:</b><br>	 -->
<%-- 	<input type="text" name="description" value="${car.description}"/> --%>
	
	<input type="submit" value="Save"/>  	
	</form:form>
<%-- 	</form> --%>
</body>
</html>