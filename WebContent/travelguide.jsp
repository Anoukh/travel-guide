<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Guide</title>
</head>
<body>
<div class="container " >
<div class="row-fluid">

<div >

Header Image

</div>
<div style="float:left;width: 40% " >
<font size="+1">
<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Select Place</aside>
<article class="span6"><input  placeholder="Select" type="text" name="travelplacename" id="travelplacename" class="span12" onKeyUp="" />
</article>

												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">No. of days</aside>
<article class="span2"><input  placeholder="" type="text" name="noofdays" id="noofdays" class="span12" onKeyUp="" />
</article>
<article class="span4"></article>
												</br>
</section>
</div>

<div id="relatedplacesdiv">

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Related Places</aside>
<article class="span6"></article>

												</br>
</section>
</div>

<div id="relatedplacesuggestions">
</div>



</div>

<div id="relatedrestaurantediv">

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Restaurants</aside>
<article class="span6"></article>

												</br>
</section>
</div>

<div id="relatedrestaurantesuggestions">
</div>



</div>

<div id="relatedhoteldiv">

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Hotels</aside>
<article class="span6"></article>

												</br>
</section>
</div>

<div id="relatedhotelsuggestions">
</div>



</div>

</font>
</div>
<div style="float:left;width: 60%;">
<div style="width:100% ; height:600px;" id="map"></div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6"></aside>
<article class="span3"><button class="btn btn-lg btn-success">Generate Route</button></article>
<article class="span3"><button class="btn btn-lg btn-success">Clculate Budget</button></article>

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