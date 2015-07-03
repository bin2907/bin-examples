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

  <h2>Rounded Corners</h2>
  <p>The .img-rounded class adds rounded corners to an image (not available in IE8):</p>            
  <img src="images/cinqueterre.jpg" class="img-rounded" alt="Cinque Terre" width="304" height="236">
   
  <h2>Circle</h2>
  <p>The .img-circle class shapes the image to a circle (not available in IE8):</p>            
  <img src="images/cinqueterre.jpg" class="img-circle" alt="Cinque Terre" width="304" height="236">
  
  <h2>Thumbnail</h2>
  <p>The .img-thumbnail class creates a thumbnail of the image:</p>            
  <img src="images/cinqueterre.jpg" class="img-thumbnail" alt="Cinque Terre" width="304" height="236">
  
  <h2>Image responsive</h2>
  <p>The .img-responsive class makes the image scale nicely to the parent element (resize the browser window to see the effect):</p>
  <img class="img-responsive" src="images/cinqueterre.jpg" alt="Chania" width="460" height="345"> 
  
  <h2>Image Gallery</h2>
  <p>The .thumbnail class can be used to display an image gallery. Click on the images to see it in full size:</p>            
  <div class="row">
    <div class="col-md-4">
      <a href="images/cinqueterre.jpg" class="thumbnail">
        <p>Pulpit Rock: A famous tourist attraction in Forsand, Ryfylke, Norway.</p>    
        <img src="images/cinqueterre.jpg" alt="Pulpit Rock" style="width:150px;height:150px">
      </a>
    </div>
    <div class="col-md-4">
      <a href="images/cinqueterre.jpg" class="thumbnail">
        <p>Moustiers-Sainte-Marie: Considered as one of the "most beautiful villages of France".</p>
        <img src="images/cinqueterre.jpg" alt="Moustiers Sainte Marie" style="width:150px;height:150px">
      </a>
    </div>
    <div class="col-md-4">
      <a href="images/cinqueterre.jpg" class="thumbnail">
        <p>The Cinque Terre: A rugged portion of coast in the Liguria region of Italy.</p>      
        <img src="images/cinqueterre.jpg" alt="Cinque Terre" style="width:150px;height:150px">
      </a>
    </div>
  </div>
  
  <h2>Responsive Embed</h2>
  <div class="embed-responsive embed-responsive-16by9">
    <iframe class="embed-responsive-item" src="http://www.youtube.com/embed/XGSy3_Czz8k"></iframe>
  </div>
   
</div>

</body>
</html>
