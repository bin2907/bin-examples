<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h1>USING PORTAL ROLES IN A PORTLET</h1>

<div> isAdministrator : ${ isAdministrator }</div>
<div> isPowerUser : ${ isPowerUser }</div>
<div> isUser : ${ isUser }</div>
<div> isGuest : ${ isGuest } <span style="color: red"> ->PROBLEM</span></div>


<%

out.println( "<div>");
out.println( "getRemoteUser: " + renderRequest.getRemoteUser() );
out.println( "</div>");

out.println( "<div>");
out.println( "getUserPrincipal: " + renderRequest.getUserPrincipal() );
out.println( "</div>");


%>
