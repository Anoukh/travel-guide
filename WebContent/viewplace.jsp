<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<link rel="stylesheet" href="css/starrating.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Place</title>
</head>
<body>
<div class="container " >
<div class="row-fluid">

<div >

Header Image

</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span8"><input style="font-size:36px" placeholder="Place Name" type="text" name="placename" id="placename" class="span12" onKeyUp="" readonly="yes"/></aside>
<article class="span4">
<span class="star-rating">
  <input type="radio" name="rating" value="1"><i></i>
  <input type="radio" name="rating" value="2"><i></i>
  <input type="radio" name="rating" value="3"><i></i>
  <input type="radio" name="rating" value="4"><i></i>
  <input type="radio" name="rating" value="5"><i></i>
</span>

</article>

												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span8"><input style="font-size:18px ; border:hidden " placeholder="Place City" type="text" name="placecity" id="placecity" class="span12" onKeyUp="" readonly="yes"/></aside>
<article class="span4">
<input style="font-size:18px ; border:hidden" placeholder="Charges" type="text" name="placecharge" id="placecharge" class="span12" onKeyUp="" readonly="yes"/>

</article>

												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span8"></aside>
<aside class="span2"><font size="+1">Updated Date</font></aside>
<article class="span2">
<input style="font-size:18px; border:hidden" placeholder="Updated Date" type="text" name="placedate" id="placedate" class="span12" onKeyUp="" readonly="yes"/>

</article>

												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span8"><div id="placeimage"><img src="" height="400px" width="100%"/></div></aside>
<article class="span4"><div id="map" class="span12" style="height:400px" ></div></article>


												</br>
</section>
</div>

<div id="AdminAcceptdiv">
<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span8"></aside>
<article class="span2"><button class="btn btn-lg btn-success">Accept</button></article>
<article class="span2"><button class="btn btn-lg btn-danger">Reject</button></article>

												</br>
</section>
</div>

</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span1"><font size="+1">Rating</font></aside>
<article class="span3"><span class="star-rating">
  <input type="radio" name="rate" id="rate1" value="1"/><i></i>
  <input type="radio" name="rate" id="rate2" value="2"/><i></i>
  <input type="radio" name="rate" id="rate3" value="3"/><i></i>
  <input type="radio" name="rate" id="rate4" value="4"/><i></i>
  <input type="radio" name="rate" id="rate5" value="5"/><i></i>
</span>
</article>
<article class="span1"><button class="btn btn-lg btn-warning">Rate</button> </article>
<article class="span3">
<font size="+1" >
<textarea rows="2" id="placeusercomment" name="placeusercomment"
placeholder="Comment"></textarea>
</font>
</article>
<article class="span2">
<font size="+1">
<input type="text" id="placeusername" name="placeusername" class="span11">
</font>
</article>

<article class="span1"><button class="btn btn-lg btn-primary">Enter</button> 
</article>


												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span8"><div id="placeothercomment"></div></aside>
<article class="span4"></article>


												</br>
</section>
</div>

</div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>