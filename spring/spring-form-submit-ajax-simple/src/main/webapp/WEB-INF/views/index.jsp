<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
 
<body>
	<h2>Form submit</h2>
 
	<form:form id="form" modelAttribute="customer">
		<table>
			<tr>
				<td>Customer Name :</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Customer Age :</td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><button type="submit">Save changes</button></td>
			</tr>
		</table>
	</form:form>
	
	<script type="text/javascript">
			function collectFormData(fields) {
				var data = {};
				for (var i = 0; i < fields.length; i++) {
					var $item = $(fields[i]);
					data[$item.attr('name')] = $item.val();
				}
				return data;
			}
				
			$(document).ready(function() {
				var $form = $('#form');
				$form.on('submit', function(e) {
					// Ajax validation
					var $inputs = $form.find('input');
					var customer = collectFormData($inputs);
					$.post('ajaxSubmit', customer, function(customer) {
						alert("Hello: " + customer.name + " " + customer.age);
					}, 'json');
					
					e.preventDefault();
					return false;
				});
			});
		</script>
 
</body>
</html>