<%@page import="com.liferay.portal.service.UserGroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.UserGroup"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.GroupLocalService"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Company"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

This is the <b>Custom User</b> portlet in View mode.

<%

// COMPANY -> Config in Portal Setting -> Currently, I only know that there is can a company
List<Company> companies = CompanyLocalServiceUtil.getCompanies();
out.println("<h1>Companies</h1>");
out.println("<p>id : name</p>");
out.println("<ul>");
for(Company c : companies){
	out.println("<li>");
	out.println(c.getCompanyId() + " : " +  c.getName());
	out.println("</li>");
}
out.println("</ul>");


//USER of COMPANY
/* List<User> comUsers = UserLocalServiceUtil.getCompanyUsers(10155, -1, -1);
out.println("<h1>User of COMPANY 10155</h1>");
out.println("<p>email</p>");
out.println("<ul>");
for(User u : comUsers){
	out.println("<li>");
	out.println(u.getEmailAddress());
	out.println("</li>");
}
out.println("</ul>"); */


// ORGANIZATION
List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(-1, -1);
out.println("<h1>Organizations</h1>");
out.println("<p>id : name : parentOrganizationId : companyId</p>");
out.println("<ul>");
for(Organization o : organizations){
	out.println("<li>");
	out.println(o.getOrganizationId() + " : " + o.getName() + " : " + o.getParentOrganizationId() + " : " + o.getCompanyId());
	out.println("</li>");
}
out.println("</ul>");


// GROUP
List<Group> groups = GroupLocalServiceUtil.getGroups(-1, -1);
out.println("<h1>Groups</h1>");
out.println("<p>id : name : parentGroupId : organizationId : companyId</p>");
out.println("<ul>");
for(Group g : groups){
	out.println("<li>");
	out.println(g.getGroupId() + " : " + g.getName() + " : " + g.getParentGroupId() + " : " + g.getOrganizationId()  + " : " + g.getCompanyId() + " ");
	out.println("</li>");
}
out.println("</ul>");


// USER of a group
List<User> users = UserLocalServiceUtil.getGroupUsers(11457);
out.println("<h1>Users of Group 11457</h1>");
out.println("<p>id : email</p>");
out.println("<ul>");
for(User u : users){
	out.println("<li>");
	out.println( u.getUserId() + " : " + u.getEmailAddress());
	out.println("</li>");
}
out.println("</ul>");


//USER GROUP
List<UserGroup> userGroups = UserGroupLocalServiceUtil.getUserGroups(-1, -1);
out.println("<h1>UserGroups</h1>");
out.println("<p>id : name : parentUserGroupId : groupId : companyId</p>");
out.println("<ul>");
for(UserGroup ug : userGroups){
	out.println("<li>");
	out.println(ug.getUserGroupId() + " : " + ug.getName() + " : " + ug.getParentUserGroupId() + " : " + ug.getGroupId() + " : " + ug.getCompanyId());
	out.println("</li>");
}
out.println("</ul>");


// ASSIGN USER TO USERGROUP
//UserGroupLocalServiceUtil.addUserUserGroup(11511, 11563);


//USER of USER GROUP
users = UserLocalServiceUtil.getUserGroupUsers(11563);
out.println("<h1>User of UserGroups 11563</h1>");
out.println("<p>email</p>");
out.println("<ul>");
for(User u : users){
	out.println("<li>");
	out.println(u.getEmailAddress());
	out.println("</li>");
}
out.println("</ul>");

%>
