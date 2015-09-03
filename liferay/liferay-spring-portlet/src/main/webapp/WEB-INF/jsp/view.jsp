

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:renderURL var="createUserUrl">
    <portlet:param name="action" value="createUser" />
</portlet:renderURL>

<portlet:resourceURL id="getUserByAjax" var="getUserByAjaxURL"></portlet:resourceURL>


<h1>Hello Liferay Spring MVC Portlet</h1>
<h2>List User</h2>

<a href="<portlet:renderURL />"> List User </a>

<br />

<a href="${createUserUrl}"> Add User </a>


<br />

<a id="ajaxTest" href="#"> Ajax TEST </a>

<script type="text/javascript">

$(document).ready(function(){

	$("#ajaxTest").click(function(){
		$.ajax({
			url: "${getUserByAjaxURL}" ,
			type: 'POST',
			datatype:'json',
			success: function(data){
				alert(data);
				alert(typeof data);
			}
		});
	});
	
});

</script>
