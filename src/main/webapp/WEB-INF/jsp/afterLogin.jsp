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
 
 <script>
	function validate()
	{
		data=document.getElementsByClassName("demo");
		count=0
		for(i=0;i<data.length;i++)
		{
			if(data[i].value=="")
			{
				data[i].nextElementSibling.innerHTML="*Required Field"
				data[i].nextElementSibling.style.color="red"
				count++

			}
			
		}
		
		 
		if(count>0)
			return false;
		else
			return true;
	}
	
	function cleanup(data)
	{
		if(data.value!="")
			{
				data.nextElementSibling.innerHTML="";
			}
	}
</script>
 
</head>

<body>
<% String email=(String)request.getAttribute("email"); 
%>
<h1 class="center">Welcome to Hotel Five Star!!!</h1>
<center>
	<table style="width:50%">
		<tr>
			<td>
				<form action="storedates" onsubmit="return validate()"  method="post" class="center" >
				<input type="hidden" name="email" value= "<%=email%>" >
				<h4>Please fill the start and end date for reservation!!!</h4>
						Starting date to stay: <input type="date" name="start" class="demo" onblur="cleanup(this)"><b></b><br><br>
						Ending date to Stay: <input type="date" name="end" class="demo" onblur="cleanup(this)"><b></b><br><br>
						<input type="submit", value="Submit" ><br><br></td>
				</form>
			</td>
			
			<td>
				<form action="history">
				<input type="hidden" name="email" value= "<%=email%>" >
				<input type="submit" value="See Your History">
				</form>
			</td>
		</tr>	
	</table>
</center>
 
</body>

</html