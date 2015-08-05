<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cost Values</title>
</head>
<body onload="onloadcostvalues();">


<div class="container " >
<div class="row-fluid">
<div>

Header
<script>
function onloadcostvalues(){
	costservlet();
}


function costservlet(){
	$.ajax({
        type: "POST",
        url: 'AutoCostServlet',
        data:  {},
        dataType: 'json', 
        success: function(dt)
        {
        	// var options = '';
        	//window.alert(dt);
        	document.getElementById("petrol").value= dt.pet;
        	document.getElementById("diesel").value= dt.die;
        	
        }
    });	
}

</script>
</div>
<div class="gap0"></div>

<font size="+1">
<form action="CostValuesServlet" method="post">
<div class="gap4"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">Petrol(Rs/1km)</aside>
<article class="span2">
<input type="text" name="petrol" id="petrol"/>
</article>
<article class="span9"></article>
												
</section>
</div>

<div class="gap0"></div>

<div class="row-fluid">
<section class="span12">
<aside class="span2">Diesel(Rs/1km)</aside>
<article class="span1">
<input type="text" name="diesel" id="diesel"/>
</article>
<article class="span9"></article>
												
</section>
</div>

<div class="gap0"></div>

<div class="row-fluid">
<section class="span12">
<aside class="span2"></aside>
<article class="span2">
<button type="submit" style="float:right" class="btn btn-lg btn-primary ">Enter</button>
</article>
<article class="span8"></article>
  												</br>
</section>
</div>


</form>
</font>

</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>