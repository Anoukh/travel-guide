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

<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&libraries=geometry"></script>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&callback=initialize"></script>
<script src="http://maps.googleapis.com/maps/api/js"></script>

</head>
<body>
<div class="container " >
<div class="row-fluid">
<form action=""  method="post">
<%@ page import = "lk.travelguide.models.TravelSuggestPlacesData" %>
<h2>
<% TravelSuggestPlacesData tv = (TravelSuggestPlacesData)request.getAttribute("LngLatObject"); %>
</h2>
<%String [] SelHotels    = tv.getSuggestHotels();
  String [] SelRests     = tv.getSuggestRests();
  String [] SelLeisure   = tv.getSuggestLeisure();
  String [] SelReligious = tv.getSuggestReligious();
  
  double  [] SelPlacesLngLat =tv.getSelPlacesLonLat();
  String [] SelPlacesNames = tv.getSelectedPlaces();
  
  for(int i =0 ; i<SelPlacesLngLat.length;i++ ){
	  System.out.println(SelPlacesLngLat[i]);
  }
//   for (int q=0 ;q < SelPlacesLngLat.length; q++){
// 	  SelPlacesLngLat[q] = (float)SelPlacesLngLat[q];
//   }
  
  
%>

<script>


</script>
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
<input type="checkbox" checked="checked" name ="SugRests" value="<%= SelRests[i]%>" onclick="return false"><%= SelRests[i]%><br/>

<%} %>
<br/>
</div >

<div id="selectedhotelsdiv">
<h3>Selected Hotels</h3>
<% for(int i=0 ; i<SelHotels.length;i++){ %>
<input type="checkbox" checked="checked" name ="SugHotels" value="<%= SelHotels[i]%>" onclick="return false"><%= SelHotels[i]%><br/>

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
<article class="span3"><button class="btn btn-lg btn-success" type="submit" onclick="form.action='CalBudfmTravelServlet';"> Calculate Budget</button></article>

												</br>
</section>
</div>


</div>

</form>
</div>
</div>

    <script>
       // var formdata= @Html.Raw(Json.Encode(@ViewBag.formdata));
       // var arraylatlong = @Html.Raw(Json.Encode(@ViewBag.arraylatlong));



        var rendererOptions = {
            // draggable: true
        }

        //
        directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);//Create a DirectionsRenderer object.
        directionsService = new google.maps.DirectionsService();//Create a directionsService object.
        var map;
 	
        var DistanceArray;
        var javaarray;
        var wayPointArray;
        var wayPoints;

        var sriLanka = new google.maps.LatLng(<%= SelPlacesLngLat[1] %>,<%= SelPlacesLngLat[0] %>);

        function initialize() {

            var mapOptions = {
                zoom: 7,
                center: sriLanka
            };
            map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
            directionsDisplay.setMap(map); //Call setMap() on the renderer to bind DirectionsRenderer object to the passed map
            // directionsDisplay.setPanel(document.getElementById('directionsPanel'));


            //calculate path
            google.maps.event.addListener(directionsDisplay, 'directions_changed', function () {
                computeTotalDistance(directionsDisplay.getDirections());

            });


            google.maps.event.addDomListener(window, "resize", function () {
                var center = map.getCenter();
                google.maps.event.trigger(map, "resize");
                map.setCenter(center);
            });


            size = <%= SelPlacesLngLat.length%> ;
            javaarray = new Array(size);
            javaarraynames = new Array(size/2);
            //javaarray[0] = formdata[0];
            //javaarray[1] = formdata[1];
            <% for (int i=0; i<SelPlacesLngLat.length; i++) { %>
            javaarray[<%= i %>] = "<%= SelPlacesLngLat[i] %>"; 
           // window.alert(javaarray[1]);            
			<% } %>
			
			<% for (int j=0; j<SelPlacesNames.length; j++) { %>
			javaarraynames[<%= j %>] = "<%= SelPlacesNames[j] %>"; 
           // window.alert(javaarray[1]);            
			<% } %>
//window.alert(javaarray[1]);
var tp;
for (j=0; j< javaarray.length/2;j++){
	tp = javaarray[2*j];
	javaarray[2*j] =javaarray[2*j+1];
	javaarray[2*j +1] =tp;
}

//window.alert(javaarray[1]);
            
//             for (var i = 0; i < size; i++) {
<%--                 javaarray[i] = <%= SelPlacesLngLat%>+ [i]; --%>
//             }
            //for (var i = 1; i < javaarray.length; i+=2) {
            //    alert(javaarray[i]);
            //}

            //size = 8;
            //javaarray = new Array(size);

            //javaarray[0] = 6.6909972;
            //javaarray[1] = 80.380928;
            //javaarray[2] = 6.8008004;
            //javaarray[3] = 80.3682015;
            //javaarray[4] = 6.5069238;
            //javaarray[5] = 80.8908641;
            //javaarray[6] = 6.8096429;
            //javaarray[7] = 80.4993882;

            dissize = size / 2;
            DistanceArray = new Array(size / 2);
            DistanceArray[0] = 0;
            abc = calDistance(javaarray, 2);
            tot = 0;
            newSize = (size / 2) - 2;
            wayPointArray = new Array(newSize);

            for (var i = 1; i < (size - 2) / 2; i++) {
                wayPointArray[i - 1] = new google.maps.LatLng(abc[2 * i], abc[2 * i +1]);
            }
            wayPoints = new Array();

            for (var i = 0; i < wayPointArray.length; i++) {
                wayPoints.push({ location: wayPointArray[i] });
            }
            //alert(wayPointArray[0]);
            //for (var i = 0; i < newSize; i++) {
            //    alert(wayPoints[i]);
            //}
            //alert(tot);
            calcRoute();
        }

        function calDistance(longlatArray, startIndex) {
            var x = startIndex;
            if (x < longlatArray.length) {
                var check = startIndex - 2;
                for (var i = startIndex; i < longlatArray.length; i += 2) {
                    var p2 = new google.maps.LatLng(longlatArray[i], longlatArray[i + 1]);
                    var p1 = new google.maps.LatLng(longlatArray[check], longlatArray[check + 1]);
                    var distance = google.maps.geometry.spherical.computeDistanceBetween(p1, p2);
                    DistanceArray[i / 2] = parseFloat(distance);
                }
                var minPOS = startIndex / 2;
                for (var j = minPOS; j < longlatArray.length / 2; j++) {
                    if (parseFloat(DistanceArray[j]) < parseFloat(DistanceArray[minPOS]))
                        minPOS = j;
                }
                DistanceArray[minPOS] = DistanceArray[j];
                var swap1 = longlatArray[2 * minPOS];
                var swap2 = longlatArray[2 * minPOS + 1];
                var swap3 = javaarraynames[minPOS];
                longlatArray[2 * minPOS] = longlatArray[startIndex];
                longlatArray[2 * minPOS + 1] = longlatArray[startIndex + 1];
                javaarraynames[minPOS] = javaarraynames[startIndex];
                longlatArray[startIndex] = swap1;
                longlatArray[startIndex + 1] = swap2;
                javaarraynames[startIndex] = swap3;
                //  window.alert( longlatArray[startIndex+1]);
                calDistance(longlatArray, x + 2);
            }

            return longlatArray;

        }


        function calcRoute() {
            var request = {                                //The DirectionsRequest object
                origin: (abc[0] + "," + abc[1]),//A-Colombo
                destination: (abc[size - 2] + "," + abc[size - 1]),//G-Galle
                waypoints: wayPoints,
                //[
                //for(d= 2;d<6;d+2){
                //loc+="{location:("+abc[d]+","+abc[d+1]+")},";

                //}
                //{location: 'Mt Lavinia'},//Mt Lavinia
                //		{location: 'Moratuwa'},//Moratuwa
                //		{location: 'Panadura'},//Panadura
                //		{location: 'Bandaraama'},//Bandaragama
                //		{location: 'Wadduwa'},//Wadduwa
                //		{location: 'Beruwala'},//Beruwala
                //{location: 'Aluthgama'}//Aluthgama
                //	{location: '6.418658, 80.002273'},
                //		],
                avoidHighways: true,
                avoidTolls: true,
                travelMode: google.maps.TravelMode.DRIVING
            };

            directionsService.route(request, function (response, status) { //This callback returns a DirectionsResult and a DirectionsStatus code in the response.
                if (status == google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(response); //passing  the DirectionsResult to renderer

                }											//the renderer is an MVCObject,
                //it will automatically detect any changes to its properties and update the map when its associated directions have changed.
            });
        }

        function computeTotalDistance(result) {
            var total = 0;
            var dur =0;
            var dis = [];
            var myroute = result.routes[0];
            for (var i = 0; i < myroute.legs.length; i++) {
                dis[i] = (myroute.legs[i].distance.value) / 1000;
                total += dis[i];
            }
			//window.alert(total);
            for (var i = 0; i < myroute.legs.length; i++) {
                dis[i] = myroute.legs[i].duration.value;
                dur += dis[i];
            }
            d=dur/3600;
            d=d.toFixed(2);
            //alert(dur/3600);
            duration=d;
            total = total;
            //alert(dis+' km');
            document.getElementById('routedistance').value= total + ' km';
           // document.getElementById('duration').innerHTML = d + 'hours';
        }

        google.maps.event.addDomListener(window, 'load', initialize);

    </script>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>