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

<h1 class="center">Welcome to Hotel Five Star!!!</h1>
<%String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<h4 class="center"><%=msg%></h4>
<%}else{%>
<h4 class="center">Please login for reservation.</h4>
<%}%>
<form action="check" onsubmit="return validate()" class="center">
	
	Username: <input type="email" name="emailid" class="demo" onblur="cleanup(this)"><b></b><br><br>
	
	Password: <input type="password" name="password" class="demo" onblur="cleanup(this)"><b></b><br><br>
	
	
	<input type="submit", value="Login"><br><br>
	<h4>New user? Please click <a href="register">here</a> to register.</h4>
	
	
 </form>
</body>

</html>