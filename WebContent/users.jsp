<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Users</title>
</head>
<body>

<div class="container " >
<div class="row-fluid">

<div >

Header Image

</div>

<font size="+1">

<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">Search By</aside>
<article class="span10"></article>
</section>
</div>


<div class="gap0"></div>
<div class="row-fluid">
<section class="span12">
<aside class="span2">User Name</aside>
<article class="span6">
<input type="text" id="username" name="username" onKeyUp=""/>
</article>
<article class="span4"></article>
												</br>
</section>
</div>



</font>
<div class="gap1"></div>
<div class="table-responsive">
				<table class="table-bordered " width="100%" id="">
				<thead>
						<tr >
								<th style="width: 40%"><font size="3pt">User Name</font></th>
								<th style="width: 20%"><font size="3pt">User Level</font></th>
								<th style="width: 20%"><font size="3pt">Assign as Admin</font></th>
								<th style="width: 20%"><font size="3pt">Remove</font></th>


						</tr>
				</thead>
				<tbody id="tableallusers" class="tablebodyrowcol">
				</tbody>
				</table>
		</div>

</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>