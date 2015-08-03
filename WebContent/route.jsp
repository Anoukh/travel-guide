<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Route</title>
</head>
<body>
<div class="container " >
<div class="row-fluid">
<%@ page import = "lk.travelguide.models.TravelSuggestPlacesData" %>
<h2>
<% TravelSuggestPlacesData tv = (TravelSuggestPlacesData)request.getAttribute("LngLatObject"); %>
</h2>
<%String [] SelHotels    = tv.getSuggestHotels();
  String [] SelRests     = tv.getSuggestRests();
  String [] SelLeisure   = tv.getSuggestLeisure();
  String [] SelReligious = tv.getSuggestReligious();
%>
<div >

Header Image

</div>

<div style="float:left;width: 40% " >
<font size="+1">
<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Selected Places</aside>
<article class="span6"></article>

												</br>
</section>
</div>


<div id="selectedleisurediv">
<h3>Selected Leisure Places</h3>
<% for(int i=0 ; i<SelLeisure.length;i++){ %>
<input type="checkbox" checked="checked" name ="SelectedLeisure" value="<%= SelLeisure[i]%>" disabled='disabled'><%= SelLeisure[i]%><br/>

<%} %>
<br/>
</div >

<div id="selectedreligiousdiv">
<h3>Selected Religious Places</h3>
<% for(int i=0 ; i<SelReligious.length;i++){ %>
<input type="checkbox" checked="checked" name ="SelectedReligious" value="<%= SelReligious[i]%>" disabled='disabled'><%= SelReligious[i]%><br/>

<%} %>
<br/>
</div >

<div id="selectedrestsdiv">
<h3>Selected Restaurants</h3>
<% for(int i=0 ; i<SelRests.length;i++){ %>
<input type="checkbox" checked="checked" name ="SelectedRests" value="<%= SelRests[i]%>" disabled='disabled'><%= SelRests[i]%><br/>

<%} %>
<br/>
</div >

<div id="selectedhotelsdiv">
<h3>Selected Hotels</h3>
<% for(int i=0 ; i<SelHotels.length;i++){ %>
<input type="checkbox" checked="checked" name ="SelectedHotels" value="<%= SelHotels[i]%>" disabled='disabled'><%= SelHotels[i]%><br/>

<%} %>
<br/>
</div>
<div >



</div>

</font>
</div>

<div style="float:left;width: 60%;">
<div style="width:100% ; height:600px;" id="map-canvas"></div>

<font size="+1">
<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Route Distance</aside>
<article class="span6"><input type="text" readonly="yes" id="routedistance" name="routedistance"></article>

												</br>
</section>
</div>
</font>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6"></aside>
<article class="span3"><button class="btn btn-lg btn-success">Print Route</button></article>
<article class="span3"><button class="btn btn-lg btn-success">Calculate Budget</button></article>

												</br>
</section>
</div>


</div>


</div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>