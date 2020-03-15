package com.toumb.employeeappspring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Use JDBC authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/employees/**").hasRole("EMPLOYEE")
			.antMatchers("/security/login*").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/security/login")
				.defaultSuccessUrl("/employees/list", true)
				.failureUrl("/security/login-error")
				.permitAll()
			.and()
			.logout()
			.logoutUrl("/security/logout")
			.deleteCookies("JSESSIONID");
	}
		
}