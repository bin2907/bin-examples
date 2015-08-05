<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#getUsers").click(
				function() {
					$.get("http://localhost:8080/spring-restful/users",
							function(users) {
								console.log(JSON.stringify(users));
							});
				});

		$("#getUser").click(
				function() {
					$.get("http://localhost:8080/spring-restful/users/1",
							function(user) {
								console.log(JSON.stringify(user));
							});
				});

		$("#deleteUser").click(function() {
			$.ajax({
				type : "POST",
				url : "http://localhost:8080/spring-restful/users/1/delete",
				success : function(user){
					console.log(JSON.stringify(user));
				}
			});
		});
		
		$("#saveUser").click(function() {
			$.ajax({
				type : "POST",
				contentType : 'application/json; charset=utf-8',
			    dataType : 'json',
				data: JSON.stringify({userId:10,name:"Binh"}),
				url : "http://localhost:8080/spring-restful/users/saveUser",
				success : function(user){
					console.log(JSON.stringify(user));
				}
			});
		});
		
		$("#saveUsers").click(function() {
			$.ajax({
				type : "POST",
				contentType : 'application/json; charset=utf-8',
			    dataType : 'json',
				data: JSON.stringify([{"userId":1,"name":"Binh"},{"userId":2,"name":"Binh2"}]),
				url : "http://localhost:8080/spring-restful/users/saveUsers",
				success : function(users){
					console.log(JSON.stringify(users));
				}
			});
		});

	});
</script>

</head>
<body>
	Spring RESTful

	<br />
	<br />
	<h1>Call Restful by javascript</h1>

	<button id="getUsers">Get List</button>

	<br />
	<br />

	<button id="getUser">Get User</button>

	<br />
	<br />

	<button id="deleteUser">Delete User</button>
	
	<br />
	<br />

	<button id="saveUser">Save User</button>
	
	<br />
	<br />

	<button id="saveUsers">Save Users</button>
	
	<br />
	<br />


	<h1>Get Image</h1>
	<a href="image">Get Image</a>
	
	<br />
	<br />
	
	<h1>Call Restful by java</h1>
	<br />
	<br />
	<a href="getUser">Get User</a>
	
	<br />
	<br />
	<a href="getUsers">Get Users</a>
	
	<br />
	<br />
	<a href=updateUser>Update User</a>
	
	<br />
	<br />
	<a href="getFile">Get File Images</a>
	
	<br />
	<br />
	<a href="getFileByteArray">Get Byte[]</a>
	
	

</body>
</html>