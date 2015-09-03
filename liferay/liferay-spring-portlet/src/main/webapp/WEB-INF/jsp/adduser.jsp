
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />


<portlet:actionURL var="saveUserUrl">
	<portlet:param name="action" value="add" />
</portlet:actionURL>


<h1>Hello Liferay Spring MVC Portlet</h1>
<h2>Add User</h2>


<a href="<portlet:renderURL />"> List User </a>

<br />

<form:form method="post" modelAttribute="user" action="${ saveUserUrl }">
	Name: <input name="name" value="${ user.name }">
	
	<input type="submit" value="Save" />
	
</form:form>