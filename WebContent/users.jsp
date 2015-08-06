<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Users</title>
</head>
<script type="text/javascript">
function usersonload(){
	viewallusers();
	
}


function suggestname(name){
	$.ajax({
        type: "POST",
        url: 'ViewUsersServlet',
        data:  { Searchname : name , table : "no"},
        success: function(dt)
        {
        	// var options = '';
        //window.alert(dt);
//var options ='';	
        	 // for(var i = 0; i < mycars.length; i++)
        	//    options += '<option value="Hi" />';
        	 //   window.alert(options);
        	    document.getElementById("names").innerHTML= dt;
        	    
        //	document.getElementById("places").value = "'"+dt+"'";
        }
    });
	
}

function findnameuser(name){
	
	$.ajax({
        type: "POST",
        url: 'ViewUsersServlet',
        data:  { Searchname : name, table : "yes" },
        success: function(dt)
        {
        	// var options = '';
        //	window.alert(dt);
//var options ='';	
        	 // for(var i = 0; i < mycars.length; i++)
        	//    options += '<option value="Hi" />';
        	 //   window.alert(options);
        	    document.getElementById("tableallusers").innerHTML= dt;
        	    
        //	document.getElementById("places").value = "'"+dt+"'";
        }
    });
	
}

function viewallusers(){
	//window.alert("viewallusers");
	$.ajax({
        type: "POST",
        url: 'ViewUsersServlet',
        data:  { Searchname : "noname", table : "yes" },
        success: function(dt)
        {
        	// var options = '';
        //	window.alert(dt);
//var options ='';	
        	 // for(var i = 0; i < mycars.length; i++)
        	//    options += '<option value="Hi" />';
        	 //   window.alert(options);
        	    document.getElementById("tableallusers").innerHTML= dt;
        	    
        //	document.getElementById("places").value = "'"+dt+"'";
        }
    });
	
}



</script>
<body onload="usersonload();">

<div class="container " >
<div class="row-fluid">

<div >

Header Image

</div>

<font size="+1">

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">Search By</aside>
<article class="span10"></article>
</section>
</div>


<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">User Name</aside>
<article class="span6">
<input list="names" name="username" id="username" class="span12" onkeyup="suggestname(this.value);"/>
<datalist id="names" >
  
</datalist>
<article class="span4"><button type="button" onclick="findnameuser(document.getElementById('username').value);" class="btn btn-lg btn-primary">Find</button></article>
												</br>
</section>
</div>



</font>
<div class="gap1"></div>
<div class="table-responsive">
				<table class="table-bordered " width="100%" id="">
				<thead>
						<tr >
								<th style="width: 40%"><font size="3pt">User Name</font></th>
								<th style="width: 20%"><font size="3pt">User Level</font></th>
								<th style="width: 20%"><font size="3pt">Assign as Admin</font></th>
								<th style="width: 20%"><font size="3pt">Remove</font></th>


						</tr>
				</thead>
				<tbody id="tableallusers" class="tablebodyrowcol">
				</tbody>
				</table>
		</div>

</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>