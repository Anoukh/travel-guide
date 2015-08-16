<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
 <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=places"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Guide</title>
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
<form action=""  method="post">
<div style="float:left;width: 40% " >
<font size="+1">



<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2"><button type="button"  class="btn btn-lg btn-success" onClick="codeAddress();">Show Location </button></aside>
<article class="span4"><input  placeholder="Start Place" type="text" name="pac-input" id="pac-input" class="span8" style="font-size:18px" onKeyUp=""/>
</article>
<article class="span2"></article>
<article class="span2"></article>
<article class="span2"></article> 	
												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6"><input placeholder="Start Longitude"  type="text" name="startlon" readonly="yes" id="startlon" class="span12" onKeyUp="" /></aside>
<article class="span6"><input placeholder="Start Latitude" type="text" name="startlat" readonly="yes" id="startlat" class="span12" onKeyUp="" /></article>

												</br>
</section>
</div>

<script type="text/javascript">
function startplace(name){
	//window.alert("hi");
	$.ajax({
        type: "POST",
        url: 'AutoComPlaceServlet',
        data:  { placetype : "" , placename :  name},
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

function travelguidesuggestplaces(){
	//window.alert("hi");
	relatedplaces();
	relatedhotels();
	relatedrestaurants();
	
}

var hlLL;
var rtLL;
var leLL;

function relatedplaces(){
	//window.alert("relatedplaces");
	var travelplacename =document.getElementById("travelplacename").value;
	window.alert(travelplacename);
	$.ajax({
        type: "POST",
        url: 'SuggestRelatedPlacesServlet',
        data:  { placename :  travelplacename},
        dataType: 'json',
        success: function(dt)
        {
        	
        	//window.alert(dt.HotelLLList);
 
        	var hotelLL =dt.HotelLLList;
        	 hlLL =hotelLL.split("_");
        	
        	//window.alert(hLL[1]);
        	var restLL  =dt.RestLLList;
        	 rtLL =restLL.split("_");
        	var leisureLL =dt.LeisureLLList; 
        	 leLL =leisureLL.split("_");
        	
        	    document.getElementById("relatedhotelsuggestions").innerHTML= dt.HotelList;
        	    document.getElementById("relatedrestaurantesuggestions").innerHTML= dt.RestList;
        	    document.getElementById("relatedleisuresuggestions").innerHTML= dt.LeisureList;
        	    placemarkers(hlLL);
        	    placemarkers(rtLL); 
        	    placemarkers(leLL);
        	    //	document.getElementById("places").value = "'"+dt+"'";
        }
    });	
}
var lgg;
var laa;
function placemarkers(LL)
{
	//7.2945453, 80.6257814
	//parseFloat(hlLL[i]), parseFloat(hlLL[i+1])
	var marker, i;
	//window.alert(LL[1]+ LL[2] );
    for (i = 1; i < LL.length; i+=2) { 
    	//window.alert(parseFloat(hlLL[i]));
    	//window.alert(parseFloat(hlLL[i+1]));
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(parseFloat(LL[i+1]),parseFloat(LL[i])),
       // title: 'Hello World!',
        map: map
      });
    //  marker.setMap(map);
  	
}
}
function relatedhotels(){
	
		
}

function relatedrestaurants(){
	
	
}
</script>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Destination Place</aside>
<article class="span6"><input  placeholder="Select" list="places" name="travelplacename" id="travelplacename" class="span12" onKeyUp="startplace(this.value);" />
</article>
<datalist id = "places">

</datalist>
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

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6"></aside>
<article class="span2">
</article>
<article class="span4"><button type="button" class="btn btn-lg btn-primary" style="float: right;" onclick="travelguidesuggestplaces();">Enter</button></article>
												</br>
</section>
</div>


<div id="relatedreligiousdiv">

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Related Religious</aside>
<article class="span6"></article>

												</br>
</section>
</div>

<div id="relatedreligioussuggestions">
</div>



</div>

<div id="relatedleisurediv">

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6">Related Leisure</aside>
<article class="span6"></article>

												</br>
</section>
</div>

<div id="relatedleisuresuggestions">
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
<div style="width:100% ; height:600px;" id="map-canvas"></div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span6"></aside>
<article class="span3"><button class="btn btn-lg btn-success" type="submit" onclick="form.action='CalRoutefmTravelServlet';">Generate Route</button></article>
<article class="span3"><button class="btn btn-lg btn-success" type="submit" onclick="form.action='CalBudfmTravelServlet';">Calculate Budget</button></article>

												</br>
</section>
</div>


</div>
</form>

</div>
</div>

    <script>
// This example adds a search box to a map, using the Google Place Autocomplete
// feature. People can enter geographical searches. The search box will return a
// pick list containing a mix of places and predicted search terms.
var lt;
var ln;
var geocoder;
var loc=[];
var map;
function initialize() {

 var mapProp = {
                        center: new google.maps.LatLng(7.2945453, 80.6257814),
                        zoom: 8,
                        mapTypeId: google.maps.MapTypeId.ROADMAP
                    };


 // var markers = [];
  map = new google.maps.Map(document.getElementById('map-canvas'),mapProp);

  
  var input = /** @type {HTMLInputElement} */(
      document.getElementById('pac-input'));
  map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

  var searchBox = new google.maps.places.SearchBox(
    /** @type {HTMLInputElement} */(input));

  
}

function codeAddress() {
    var address = document.getElementById("pac-input").value;
    
geocoder = new google.maps.Geocoder();
    // next line creates asynchronous request
    geocoder.geocode( { 'address': address}, function(results, status) {
      // and this is function which processes response
      if (status == google.maps.GeocoderStatus.OK) {
        loc[0]=results[0].geometry.location.lat();
        loc[1]=results[0].geometry.location.lng();
		
		document.getElementById("startlon").value = loc[0];
		document.getElementById("startlat").value = loc[1];
		 	 	
	 var myLatlng = new google.maps.LatLng(loc[0], loc[1]);
	 marker =null;
	 marker = new google.maps.Marker({
                       position: myLatlng,
                        map: map,
                        title: '',

                    });
                   // google.maps.event.addListener(marker, 'click', function(){codeAddress();});
      //  alert( loc ); // the place where loc contains geocoded coordinates

      } else {
        alert("Geocode was not successful for the following reason: " + status);
      }
    });
	}


google.maps.event.addDomListener(window, 'load', initialize);

    </script>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>