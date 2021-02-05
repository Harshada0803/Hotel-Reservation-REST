
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
<h4 class="center">Please register yourself before login.</h4>
<form action="register" onsubmit="return validate()" class="center" method="post">
	First Name: <input type="text" name="firstname" class="demo" onblur="cleanup(this)"><b></b><br><br>
	
	Last Name: <input type="text" name="lastname" class="demo" onblur="cleanup(this)"><b></b><br><br>
	
	Email Id: <input type="email" name="emailid" class="demo" onblur="cleanup(this)"><b></b><br><br>
	
	Password: <input type="password" name="password" class="demo" onblur="cleanup(this)"><b></b><br><br>
	
	Date of Birth: <input type="date" name="dateofbirth" class="demo" onblur="cleanup(this)"><b></b><br><br>
	
	City Name: <input type="text" name="cityname" class="demo" onblur="cleanup(this)"><b></b><br><br>
	
	
	<input type="submit", value="Submit">
	<h4>Already registered? Please click <a href="login">here</a> to login</h4>
 </form>
</body>

</html>