<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Place Information</title>
</head>
<body>
<div class="container " >
<div class="row-fluid">

<div >

Header Image

</div>
<font size="+1">
<form action="" method="post">

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">Place Type</aside>
<article class="span6">
<select name="placetype" id="placetype" onFocus="" onChange="">
<option value="Hotel">Hotel</option>
<option value="Restaurant">Restaurant</option>
<option value="Leisure">Leisure</option>
<option value="Religious">Religious</option>
</select>
</article>
<article class="span4"></article>
												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">Place Name</aside>
<article class="span6">
<input type="text" name="placename" id="placename" onKeyUp=""/>

</article>
<article class="span4"></article>
												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">Description</aside>
<article class="span6">
<textarea name="placedes" id="placedes" rows="2" class="span12"></textarea>
</article>
<article class="span4"></article>
												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">Change Image</aside>
<article class="span6">
<input type="file" name="placeimg" id="placeimg" />
</article>
<article class="span4"></article>
												</br>
</section>
</div>

<div id="chargediv" class="chargediv">
<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">Charges</aside>
<article class="span6">
<input type="text" name="placecharge" id="placecharge" />

</article>
<article class="span4"></article>
												</br>
</section>
</div>
</div>

<div class="gap0"></div>

<div class="row-fluid">
<section class="span12">
<aside class="span2"></aside>
<article class="span6">
<button type="submit" style="float:right" class="btn btn-lg btn-success ">Change</button>
</article>
<article class="span4"></article>
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