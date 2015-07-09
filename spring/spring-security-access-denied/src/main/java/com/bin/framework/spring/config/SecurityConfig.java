package com.bin.framework.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.bin.framework.spring.controller.MyAccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("mkyong").password("123456")
				.roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("123456")
				.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("123456")
				.roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	MyAccessDeniedHandler accessDeniedHandler = new MyAccessDeniedHandler("403");	
		
	 http.authorizeRequests()
	    .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
	    .and().formLogin()
		.loginPage("/login").failureUrl("/login?error")
		.usernameParameter("username")
		.passwordParameter("password")
	    .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
	    .and()
		.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}

}