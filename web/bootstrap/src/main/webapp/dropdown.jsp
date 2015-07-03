<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8"> 

<title>Bootstrap</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">

  <h2>Dropdowns</h2>
  <p>The .dropdown class is used to indicate a dropdown menu.</p>
  <p>Use the .dropdown-menu class to actually build the dropdown menu.</p>
  <p>To open the dropdown menu, use a button or a link with a class of .dropdown-toggle and data-toggle="dropdown".</p>                                          
  <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
    </ul>
  </div>
  
  <h2>Dropdowns Separate</h2>
  <p>The .divider class is used to separate links inside the dropdown menu:</p>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Tutorials
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
      <li class="divider"></li>
      <li><a href="#">About Us</a></li>
    </ul>
  </div>
  
  <h2>Dropdowns Header</h2>
  <p>The .dropdown-header class is used to add headers inside the dropdown menu:</p>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Tutorials
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li class="dropdown-header">Dropdown header 1</li>
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
      <li class="dropdown-header">Dropdown header 2</li>
      <li class="divider"></li>
      <li><a href="#">About Us</a></li>
    </ul>
  </div>
  
  <h2>Dropdowns Disabled</h2>
  <p>The .disabled class is used to disable an item in the dropdown menu:</p>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Tutorials
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">HTML</a></li>
      <li class="disabled"><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
      <li class="divider"></li>
      <li><a href="#">About Us</a></li>
    </ul>
  </div>
  
  <h2>Dropdowns Position</h2>
  <p>Add the .dropdown-menu-right class to .dropdown-menu to right-align the dropdown menu:</p>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
    <span class="caret"></span></button>
    <ul class="dropdown-menu dropdown-menu-right">
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
      <li class="divider"></li>
      <li><a href="#">About Us</a></li>
    </ul>
  </div>
  
	<h2>Dropdowns Accessibility</h2>
  <p>The .dropdown class is used to indicate a dropdown menu.</p>
  <p>Use the .dropdown-menu class to actually build the dropdown menu.</p>                                          
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Tutorials
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">HTML</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">CSS</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">JavaScript</a></li>
      <li role="presentation" class="divider"></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">About Us</a></li>
    </ul>
  </div>

</div>

</body>
</html>
