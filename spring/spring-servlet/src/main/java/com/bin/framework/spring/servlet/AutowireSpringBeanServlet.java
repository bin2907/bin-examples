package com.bin.spring.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.bin.spring.servlet.beans.SampleService;

/**
 * Servlet implementation class AutowireSpringBeanServlet
 */
public class AutowireSpringBeanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SampleService sampleService;

    /**
     * Default constructor. 
     */
    public AutowireSpringBeanServlet() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);

		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
			      config.getServletContext());
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().println( sampleService.insert() );

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
