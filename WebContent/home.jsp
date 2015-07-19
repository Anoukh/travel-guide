<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

<div class="container " >
<div class="row-fluid">

<div >

Header Image

</div>

<div style="float:left; width: 60% ">
Search Bar
<font size="+2">
<form action="" method="post">
<div class="gap4"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span4">Place Type</aside>
<article class="span6">
<select name="placetype" id="placetype" onFocus="" onChange="">
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
<input list="places" name="placename" id="placename" class="span12" onkeyup="suggestplace(document.getElementById('placetype').value,this.value);"/>
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

Admin Part

<div class="adminhome">
<div class="gap1 span12"></div>

<button  class="btn btn-lg btn-warning span12 " onClick="">Update Place Details</button>
<div class="gap1 span12"></div>
<button  class="btn btn-lg btn-warning span12" onClick="">View Suggested Places</button>
<div class="gap1 span12"></div>
<button  class="btn btn-lg btn-warning span12" onClick="">View Cost Values</button>
<div class="gap1 span12"></div>
<button  class="btn btn-lg btn-warning span12" onClick="">View All Users</button>
<div class="gap1 span12"></div>
</div>


</div>

</div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>