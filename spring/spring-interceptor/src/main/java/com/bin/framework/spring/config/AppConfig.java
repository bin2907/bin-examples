package com.bin.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.bin.spring.interceptor.ExecuteTimeInterceptor;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.bin.spring" })
public class AppConfig extends WebMvcConfigurerAdapter{
	
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(executeTimeInterceptor());
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public ExecuteTimeInterceptor executeTimeInterceptor() {
		return new ExecuteTimeInterceptor();
	}
	
}