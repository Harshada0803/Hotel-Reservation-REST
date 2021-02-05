
<%@page import="com.springboot.model.GuestReservationDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<style>
.center
{
text-align:center;
}
</style>

 <meta charset="UTF-8">
 <title></title>
 <style>
table, th, td {
  border: 1px solid black;
}
 </style>
</head>

<body>

<%List<GuestReservationDetails> list=(List<GuestReservationDetails>)request.getAttribute("list");%>
<center>
<h1>Welcome to Hotel Five Star!!!</h1>
<%if(list.size()>0){
%>
<h2>Here is information of your all reservation!!! </h2><br>
<table style="width:80%">
	<tr>
		<th>Sr. No.</th>
		<th>Reservation Id</th>
		<th>Start Date of Reservation</th>
		<th>End Date of Reservation</th>
		<th>Age</th>
		<th>No of Days</th>
		<th>Total Amount</th>
	</tr>
	
	<%int i=1;
	for(GuestReservationDetails g:list){%>
	<tr>
		<td><%= i %></td>
		<td><%=g.getReservationId()%></td>
		<td><%=g.getStartDate()%></td>
		<td><%=g.getEndDate()%></td>
		<td><%=g.getGuestAge()%></td>
		<td><%=g.getTotalDays()%></td>
		<td><%=g.getTotalAmount()%></td>
		
	</tr>
	<%
	i++;
	}%>
</table>
<%}else{%>
<h2>You have no history!!!!</h2>
<%}%>
<center>
</body>

</html>