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
<aside class="span6">Budget</aside>
<article class="span6"></article>

												</br>
</section>
</div>


<div id="budgetplacesdiv"></div>

</font>
</div>

<div style="float:left;width: 60%;">
<div style="width:100% ; height:600px;" id="map-canvas"></div>



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