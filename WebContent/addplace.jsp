<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
<head>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<link rel="stylesheet" href="css/starrating.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Place</title>
</head>
<body>
<div class="container " >
<div class="row-fluid">
  
<div >

Header Image

</div>
<script>
function showhideplchargediv(placetype){
	if(placetype=="Hotel" || placetype=="Restaurant"){
		$("#chargediv").show();
	}
	else{
		$("#chargediv").hide();
	}
}
</script>
<font size="+1" >

<form action="AddPlaceServlet" method="post" enctype="multipart/form-data">

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">Place Type</aside>
<article class="span6">
<select name="placetype" id="placetype" onFocus="showhideplchargediv(this.value);" onChange="showhideplchargediv(this.value);">
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
<aside class="span2">City</aside>
<article class="span6">
<input type="text" name="placecity" id="placecity" />

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
<aside class="span2">Add Image</aside>
<article class="span6">
<input type="file" name="placeimg" id="placeimg" />
</article>
<article class="span4"></article>
												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">Location</aside>
<article class="span6">
<div id="map" class="span12" style="height:500px" ></div>
</article>
<article class="span4"><table> 
<tr >
<td class="span12"> <input type="text" id="lat" name="lat" readonly="yes"/></td>
</tr>
<tr class="gap0"></tr>
<tr >
<td class="span12"> <input type="text" id="lng"  name="lng" readonly="yes"/></td>
</tr>
</table></article>
												</br>
</section>
</div>

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">Rating</aside>
<article class="span6">
<span class="star-rating">
  <input type="radio" name="rating" value="1"><i></i>
  <input type="radio" name="rating" value="2"><i></i>
  <input type="radio" name="rating" value="3"><i></i>
  <input type="radio" name="rating" value="4"><i></i>
  <input type="radio" name="rating" value="5"><i></i>
</span>
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
<button type="submit" style="float:right" class="btn btn-lg btn-success ">Suggest</button>
</article>
<article class="span4"></article>
												</br>
</section>
</div>

</form>
</font>
</div>
</div>
<style>

</style>
<script>
	
//map.js
 
//Set up some of our variables.
var map; //Will contain map object.
var marker = false; ////Has the user plotted their location marker? 
        
//Function called to initialize / create the map.
//This is called when the page has loaded.
function initMap() {
 
    //The center location of our map.
    var centerOfMap = new google.maps.LatLng(7.318881, 80.601882);
 
    //Map options.
    var options = {
      center: centerOfMap, //Set center.
      zoom: 7 //The zoom value.
    };
 
    //Create the map object.
    map = new google.maps.Map(document.getElementById('map'), options);
 
    //Listen for any clicks on the map.
    google.maps.event.addListener(map, 'click', function(event) {                
        //Get the location that the user clicked.
        var clickedLocation = event.latLng;
        //If the marker hasn't been added.
        if(marker === false){
            //Create the marker.
            marker = new google.maps.Marker({
                position: clickedLocation,
                map: map,
                draggable: true //make it draggable
            });
            //Listen for drag events!
            google.maps.event.addListener(marker, 'dragend', function(event){
                markerLocation();
            });
        } else{
            //Marker has already been added, so just change its location.
            marker.setPosition(clickedLocation);
        }
        //Get the marker's location.
        markerLocation();
    });
}
        
//This function will get the marker's current location and then add the lat/long
//values to our textfields so that we can save the location.
function markerLocation(){
    //Get location.
    var currentLocation = marker.getPosition();
    //Add lat and lng values to a field that we can save.
    document.getElementById('lat').value = currentLocation.lat(); //latitude
    document.getElementById('lng').value = currentLocation.lng(); //longitude
}
        
        
//Load the map when the page has finished loading.
google.maps.event.addDomListener(window, 'load', initMap);
	</script>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>