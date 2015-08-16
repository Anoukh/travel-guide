<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/customnavbar.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>



<div class="container " >
<div class="row-fluid">

<style>

</style>
<section ><font size="+2">
<ul class="nav nav-tabs navbar-inverse"  id="navigationbar">    

<li style="width:25%"> 
        <a href="home.jsp">Home</a>
         </li>
<li style="width:25%"> 
        <a href="addplace.jsp">Add Place</a>
         </li>
<li style="width:25%"> 
        <a href="travelguide.jsp">Travel Guide</a>
         </li>		 
<li style="width:25%"> 
        <a href="LogoutServlet">Log Out</a>
         </li>		
</ul>
</font>
</section>
<div style="float:left; width: 60% ">

<font size="+2">
<form action="ViewPlaceServlet" method="get">
<div class="gap4"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span4">Place Type</aside>
<article class="span6">
<select name="type" id="placetype" onFocus="" onChange="">
<option value="Hotel">Hotel</option>
<option value="Restaurant">Restaurant</option>
<option value="Leisure">Leisure</option>
<option value="Religious">Religious</option>
</select>
</article>
<article class="span2"></article>
												</br>
</section>
</div>
<script type="text/javascript">
function suggestplace(placetype,name){
	//window.alert("hi");
	$.ajax({
        type: "POST",
        url: 'AutoComPlaceServlet',
        data:  { placetype : placetype , placename :  name},
        success: function(dt)
        {
        	// var options = '';
        	window.alert(dt);
var options ='';	
        	 // for(var i = 0; i < mycars.length; i++)
        	    options += '<option value="Hi" />';
        	    window.alert(options);
        	    document.getElementById("places").innerHTML= dt;
        	
        //	document.getElementById("places").value = "'"+dt+"'";
        }
    });	
	
}
</script>
<div class="gap0"></div>

<div class="row-fluid">
<section class="span12">
<aside class="span4">Name</aside>
<article class="span8">
<input list="places" name="place" id="placename" class="span12" onkeyup="suggestplace(document.getElementById('placetype').value,this.value);"/>
<datalist id="places" >
  
</datalist>
</article>

												</br>
</section>
</div>

<div class="gap0"></div>

<div class="row-fluid">
<section class="span12">
<aside class="span8"></aside>
<article class="span4">
<button type="submit"  style="float:right "  class="btn btn-primary btn-lg span12" onClick="">Search Place</button>

</article>
</section>
</div>

</form>
</font>
</div>
<div style="float: left; width: 40%">



<div class="adminhome">

<% String userlevel =(String)session.getAttribute("sessionuserlevel");
if(userlevel.equals("Admin")){


%>
<div class="gap1 span12"></div>

<button  class="btn btn-lg btn-warning span12 " onClick="window.location='updateplace.jsp'">Update Place Details</button>
<div class="gap1 span12"></div>
<button  class="btn btn-lg btn-warning span12" onClick="window.location='suggestedplaces.jsp'">View Suggested Places</button>
<div class="gap1 span12"></div>
<button  class="btn btn-lg btn-warning span12" onClick="window.location='costvalues.jsp'">View Cost Values</button>
<div class="gap1 span12"></div>
<button  class="btn btn-lg btn-warning span12" onClick="window.location='users.jsp'">View All Users</button>
<div class="gap1 span12"></div>
</div>

<%} %>
</div>

</div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>