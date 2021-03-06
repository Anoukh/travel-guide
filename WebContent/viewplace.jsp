<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import ="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>
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
<form method="post" action="">
<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span8"><input style="font-size:36px" placeholder="Place Name" type="text" name="placename" id="placename" class="span12" onKeyUp="" value="<%= request.getAttribute("placename")%>" readonly/></aside>
<input style="font-size:36px"  type="hidden" name="placetype" id="placetype" class="span12" onKeyUp="" value="<%= request.getAttribute("placetype")%>" readonly/>
<article class="span4">
<span class="star-rating">
	<% Double rating= (Double)request.getAttribute("rating");
	  Integer rate = rating.intValue();	%>

 
  <% String arr[] = new String[5];
  Arrays.fill(arr, null);
  
  for(int i=0;i<rate;i++){
		arr[i]="checked='checked'" ; 
 } %>
	  <input type="radio" name="rating" value="1" disabled='disabled' <%=arr[0] %> ><i></i>
	  <input type="radio" name="rating" value="2" disabled='disabled' <%= arr[1]%> ><i></i>
	  <input type="radio" name="rating" value="3" disabled='disabled' <%=arr[2]%> ><i></i>
	  <input type="radio" name="rating" value="4" disabled='disabled' <%=arr[3]%> ><i></i>
	  <input type="radio" name="rating" value="5" disabled='disabled' <%=arr[4]%> ><i></i>
</span>

</article>

												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span8"><input style="font-size:18px ; border:hidden " placeholder="Place City" type="text" name="placecity" id="placecity" class="span12" onKeyUp="" value="<%= request.getAttribute("placecity")%>" readonly/></aside>
<article class="span4">
<input style="font-size:18px ; border:hidden" placeholder="Charges" type="text" name="placecharge" id="placecharge" class="span12" onKeyUp="" readonly/>

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
<input style="font-size:18px; border:hidden" placeholder="Updated Date" type="text" name="placedate" id="placedate" class="span12" onKeyUp="" value="<%= request.getAttribute("lastupdate")%>" readonly/>

</article>

												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span8"><div id="placeimage"><%if(request.getAttribute("imagepath") != null){ String path = (String)request.getAttribute("imagepath");
String imagepath = path.replace("file:///","");%>
<img src="<%= imagepath%>" height="400px" width="100%"/><% } else { %> <% System.out.println("world");} %> </div></aside>
<article class="span4"><div id="placemap" class="span12" style="height:400px" ></div></article>


												</br>
</section>
</div>

<div id="AdminAcceptdiv">
<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span8"></aside>

<article class="span2"><button class="btn btn-lg btn-success" type="submit" onClick="form.action='PlaceAcceptServlet';">Accept</button></article>
<article class="span2"><button class="btn btn-lg btn-danger" type="submit" onClick="form.action='PlaceRejectServlet';">Reject</button></article>


											</br>
</section>
</div>

</div>
</form>
<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span1"><font size="+1">Rating</font></aside>
<article class="span3"><span class="star-rating">
  <input class="rating" type="radio" name="rate" id="rate1" value="1"/><i></i>
  <input class="rating" type="radio" name="rate" id="rate2" value="2"/><i></i>
  <input class="rating" type="radio" name="rate" id="rate3" value="3"/><i></i>
  <input class="rating" type="radio" name="rate" id="rate4" value="4"/><i></i>
  <input class="rating" type="radio" name="rate" id="rate5" value="5"/><i></i>
</span>
</article>


<article class="span1"><button class="btn btn-lg btn-warning" type="button" onClick="addrate(document.getElementById('placename').value,document.getElementById('placetype').value);">Rate</button> </article>
<article class="span3">
<font size="+1" >
<textarea rows="2" id="placeusercomment" name="placeusercomment"
placeholder="Comment" ></textarea>
</font>
</article>
<article class="span2">
<font size="+1">
<input type="text" id="placeusername" name="placeusername" class="span11">
</font>
</article>

<article class="span1"><button class="btn btn-lg btn-primary" type="button" onClick="addcomments(document.getElementById('placename').value,document.getElementById('placetype').value,document.getElementById('placeusercomment').value);">Enter</button> 
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

<script>

function addcomments(placetype,placename,comments){
	
	if(comments!=null){
	$.ajax({
        type: "POST",
        url: 'AddCommentsServlet',
        data:  { placetype : placetype, placename : placename, comments : comments },
        success: function(dt)
        {
        
        		document.getElementById("placeusercomment").value= "";
        }
    });	
	}
}

function addrate(placename,placetype){
	window.alert('add rate');
	var rate=0;
	
	for(i=1;i<6;i++){
		var num= "rate"+i.toString();
		
		if(document.getElementById(num).checked){
		rate=i;
		}
	}
	window.alert("rate="+rate);
	
	if(rate!=null){
		$.ajax({
	        type: "POST",
	        url: 'AddRateServlet',
	        data:  { placename : placename, placetype : placetype ,rate : rate},
	        success: function(dt)
	        {
	        
	        		//document.getElementByName("rate").value= "";
	        }
	    });	
		}
}

function initialize() {
  //viewlon = 6.788070599999999;
  //viewlat = 79.89128129999995;
  var lon = <%=request.getAttribute("lng")%>
  var lat = <%=request.getAttribute("lat")%> 
  viewlon = lon;
  viewlat = lat;
  
  window.alert(lon);
  
  var myLatlng = new google.maps.LatLng(viewlat,viewlon);
  var mapOptions = {
    zoom: 9,
    center: myLatlng
  }
  var map = new google.maps.Map(document.getElementById('placemap'), mapOptions);

  var marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      title: 'Hello World!'
  });
}

google.maps.event.addDomListener(window, 'load', initialize);

    </script>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>