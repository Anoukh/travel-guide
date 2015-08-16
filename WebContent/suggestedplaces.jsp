<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suggested Place</title>
</head>
<body>
	<div class="container ">
		<div class="row-fluid">

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

			<font size="+1">

				<div class="gap0"></div>
				<div class="row-fluid">
					<section class="span12"> <aside class="span2">Search
					By</aside> <article class="span10"></article> </section>
				</div>


				<div class="gap0"></div>
				<div class="row-fluid">
					<section class="span12"> <aside class="span2">Place
					Type</aside> <article class="span6"> <select name="placetype"
						id="placetype"
						onFocus="acceptplace(document.getElementById('placetype').value);"
						onChange="acceptplace(document.getElementById('placetype').value);">
						<option value="Hotel">Hotel</option>
						<option value="Restaurant">Restaurant</option>
						<option value="Leisure">Leisure</option>
						<option value="Religious">Religious</option>
					</select> </article> <article class="span4"></article> </br>
					</section>
				</div> <script type="text/javascript">
function acceptplace(placetype){
	var placetype = placetype;
	//window.alert("hi");
	$.ajax({
        type: "POST",
        url: 'DropDownServlet',
        data:  { placetype : placetype },
        success: function(dt)
        {
        	// var options = '';
        //	window.alert(dt);
var options ='';	
        	 // for(var i = 0; i < mycars.length; i++)
        	    options += '<option value="Hi" />';
        	 //   window.alert(options);
        	    document.getElementById("placename").innerHTML= dt;
        	    
        //	document.getElementById("places").value = "'"+dt+"'";
        }
    });	
	viewdetails(placetype);
}

function viewdetails(placetype){
	window.alert(placetype);
	$.ajax({
        type: "POST",
        url: 'ViewDetailsServlet',
        data:  { placetype : placetype },
        success: function(dat)
        {
        	// var options = '';
        //	window.alert(dat);
var options ='';	
        	 // for(var i = 0; i < mycars.length; i++)
        	    options += '<option value="Hi" />';
        	//    window.alert(options);
        	    document.getElementById("tablesuggestedplaces").innerHTML= dat;
        		
        //	document.getElementById("places").value = "'"+dt+"'";
        }
        
       
    });	
}

function viewdetailsOnload(){
	
}
</script>

				<div class="gap0"></div>
				<div class="row-fluid">
					<section class="span12"> <aside class="span2">Place
					Name</aside> <article class="span6"> <select name="placename"
						id="placename" onFocus="" onChange="">

					</select> <datalist id="places"> </datalist> </article> <article class="span4"></article>
					</br>
					</section>
				</div>

			</font>
			<div class="gap1"></div>
			<div class="table-responsive">
				<table class="table-bordered " width="100%" id="">
					<thead>
						<tr>
							<th style="width: 15%"><font size="3pt">Type</font></th>
							<th style="width: 60%"><font size="3pt">Name</font></th>
							<th style="width: 25%"><font size="3pt">View full
									Details</font></th>

						</tr>
					</thead>
					<tbody id="tablesuggestedplaces" class="tablebodyrowcol">
					</tbody>
				</table>
			</div>

		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>