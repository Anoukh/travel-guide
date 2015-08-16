<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Budget</title>
</head>
<%@ page import = "lk.travelguide.models.PlaceChargesData" %>
<% PlaceChargesData plcd = (PlaceChargesData)request.getAttribute("plcostvals");
double htcost =0;
double rtcost =0;
%>
<body>

<div class="container " >
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
<div style="float:left;width: 60% " >




<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Budget</aside>
<article class="span6"></article>

												</br>
</section>
</div>


<div id="budgetplacesdiv"></div>
<% String [][] rests =plcd.getRestCharges(); 
if(rests != null){
	
%>
<div id="costrestsdiv">
<% for(int i=0; i<rests[0].length;i++){ 
	rtcost += Double.parseDouble(rests[1][i]);
%>
<div class="row-fluid">
<section class="span12">
<aside class="span6"><%= rests[0][i]%></aside>
<article class="span6"><%= rests[1][i]%></article>
	</br>
</section>
</div>
<%} %>
<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Total Cost for Restaurants</aside>
<article class="span4"><input type="text" id="totcostrest" readonly="readonly" value="<%=rtcost %>" name="totcostrest"/></article>
<article class="span2"></article>
												</br>
</section>
</div>
</div>
<%} %>

<% String [][] hotels =plcd.getHotelCharges(); 
if(hotels != null){
	
%>
<div id="costhotelsdiv">

<% for(int i=0; i<hotels[0].length;i++){ 
	htcost += Double.parseDouble(hotels[1][i]);
%>
<div class="row-fluid">
<section class="span12">
<aside class="span6"><%= hotels[0][i]%></aside>
<article class="span6"><%= hotels[1][i]%></article>
	</br>
</section>
</div>

<%} %>
<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Total Cost for Hotels</aside>
<article class="span4"><input type="text" id="totcosthotel" readonly="readonly" name="totcosthotel" value="<%=htcost %>"/></article>
<article class="span2"></article>
												</br>
</section>
</div>
</div>

<%} %>


</div>

<div style="float:left;width: 40%;">

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Distance </aside>
<article class="span6"><input type="text" name="totdistance" readonly="readonly" id="totdistance" value="<%if (request.getAttribute("pldistance") != null) {%><%=request.getAttribute("pldistance")%><% }else {String dis ="0"; %><%=dis%><% }%>"></article>

												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Fuel Type</aside>
<article class="span6"><select name="fueltype" id="fueltype" class="span12">
<option value="petrol">petrol</option>
<option value="diesel">diesel</option>
</select></article>

												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6"></aside>
<!-- <article class="span3"><button class="btn btn-lg btn-success">Print Route</button></article> -->
<article class="span3"><button class="btn btn-lg btn-success" onclick="calbudget(document.getElementById('fueltype').value);">Calculate Budget</button></article>

												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Cost for Distance </aside>
<article class="span6"><input type="text" name="tocostdis readonly="readonly" id="tocostdis" value=""></article>

												</br>
</section>
</div>

<script>
function calbudget(costtype){
	var restcost =0;
	var hotelcost =0;
	if(document.getElementById('totcostrest')){
		restcost =  parseInt(document.getElementById("totcostrest").value);
		//window.alert(dd);
	}
	
	if(document.getElementById('totcosthotel')){
		hotelcost =  parseInt(document.getElementById("totcosthotel").value);
		//window.alert(dd);
	}
	$.ajax({
        type: "POST",
        url: 'CostBudgetServlet',
        data:  { costtype : costtype },
        success: function(dt)
        {
        	var disint =0;
        	var distance=  document.getElementById("totdistance").value;
        	var mul
        	// var options = '';
        	//
        	var disint = parseInt(distance);
        	var val = parseInt(dt);
        	 mul = disint*val;
        	var totcost = mul + restcost + hotelcost ; 
        	
        	document.getElementById("tocostdis").value = mul;
        	
        	document.getElementById("totbudget").value = totcost;
        	
        }
    });	
}
</script>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Total Budget</aside>
<!-- <article class="span3"><button class="btn btn-lg btn-success">Print Route</button></article> -->
<article class="span6"><input type="text" id="totbudget" name="totbudget"/></article>

												</br>
</section>
</div>

<div style="width:100% ; height:600px;" id="map-canvas"></div>






</div>
</font>

</div>
</div>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>