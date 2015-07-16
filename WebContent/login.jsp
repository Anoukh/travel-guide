<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">

<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<div class="container ">
<div class="row-fluid">

<div >

Header Image

</div>
<div>
<div style="float:left; width:40% ;">
<center><font size="+2">Login</font></center>

<br/>
<center><label id="loginmsg" style="width:100%; background-color: #DCDCDC;"class="formlabel"><%if(request.getAttribute("loginerrormessage") != null){ %>
<h3><%= request.getAttribute("loginerrormessage")%></h3> 
<% } %></label></center>
<form method="post" action="LoginServlet">
<table class="table-responsive" align="center" >
<tr>
<td width="50%" class="span12" style="color:#CDCDCD; font-size:20px;">User Name</td>
<td width="50%"><input type="text" class="span12 form-control" name="LoginUserName" id="LoginUserName"/></td>
</tr>
<tr >
<td colspan="2" style="height:10px"></td>
</tr>
<tr>
<td width="50%" class="span12" style="color:#CDCDCD; font-size:20px">Password</td>
<td width="50%" > <input type="password" class="span12 form-control" name="LoginPassword" id="LoginPassword" onKeyPress=""/></td>
<tr>
<tr style="height:10px">

</tr>
<td></td>
<td><label class="span6"></label>

<button type="submit"  style="background-color:#066584 ;float:right "  class="btn btn-info btn-lg span12"  >Login</button>
</td>
</tr>
</table>
</form>
</div>
<div style="float:left; width:60% ; background:rgba(14,77,85,0.6) " class="roundcorner">
<center><font size="+2"> Sign up</font></center>
<br/>
<center><label id="signupmsg" style="color:#CDCDCD;width:100%;font-size:20px" class="formlabel"><%if(request.getAttribute("signuperrormessage") != null){ %>
<h3><%= request.getAttribute("signuperrormessage")%></h3> 
<% } %></label></center>
<form action="SignupServlet" method="post">
<table class="table-responsive" align="center" >
<tr>
<td width="50%" class="span12" style="color:#CDCDCD; font-size:20px;">User Name</td>
<td width="50%"><input type="text" class="span12 form-control" name="SignupUserName" id="SignupUserName" onKeyUp=""/></td>
</tr>
<tr >
<td colspan="2" style="height:10px"></td>
</tr>
<tr>
<td width="50%" class="span12" style="color:#CDCDCD; font-size:20px;">Email</td>
<td width="50%"><input type="text" class="span12 form-control" name="SignupEmail" id="SignupEmail" onKeyUp=""/></td>
</tr>
<tr >
<td colspan="2" style="height:10px"></td>
</tr>
<tr>
<td width="50%" class="span12" style="color:#CDCDCD; font-size:20px">Password</td>
<td width="50%" > <input type="password" class="span12 form-control" name="SignupPassword" id="SignupPassword" onKeyPress=""/></td>
</tr>

<tr >
<td colspan="2" style="height:10px"></td>
</tr>
<tr>
<td width="50%" class="span12" style="color:#CDCDCD; font-size:20px">Confirm Password</td>
<td width="50%" > <input type="password" class="span12 form-control" name="SignupConfPassword" id="SignupConfPassword" onKeyPress=""/></td>
</tr>
<tr style="height:10px">

</tr>
<tr>
<td></td>
<td><label class="span6"></label>

<button type="submit"  style="float:right "  class="btn btn-success btn-lg span12 ">Sign Up</button>
</td>
</tr>
</table>
</form>
<br/>
</div>

</div>

</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>