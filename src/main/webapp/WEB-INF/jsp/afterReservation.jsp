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
</head>

<body>
<% long days=(long)request.getAttribute("days");
long cost=(long)request.getAttribute("cost");
%>
<h3 class="center">Thank you Mr/Ms ${firstname} ${lastname} for choosing to stay with us.</h3>
<h4 class="center"> Your Age is ${age}.
and your booking will cost <%=cost%> Rs. You have opted for a stay of <%=days%> days. </h4>
<h4 class="center">Click on Accept button to proceed.</h4><br>
<center>
<form action="accept">
<input type="submit" value="Accept">
</form>
</center>
</body>

</html>