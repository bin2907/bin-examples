package com.bin.liferay.portlet.portalrole;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PortalRolePortlet
 */
public class PortalRolePortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		renderRequest.setAttribute("isAdministrator", renderRequest.isUserInRole("administrator"));
		renderRequest.setAttribute("isPowerUser", renderRequest.isUserInRole("power-user"));
		renderRequest.setAttribute("isUser", renderRequest.isUserInRole("user"));
		renderRequest.setAttribute("isGuest", renderRequest.isUserInRole("guest")); // -> PROBLEM
		
		super.doView(renderRequest, renderResponse);
	}
 
	

}
