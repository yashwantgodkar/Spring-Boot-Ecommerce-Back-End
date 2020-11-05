package com.ecommerce.app.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ecommerce.app.service.impl.UserDetailsServiceImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;	
	
	@Autowired
	private AuthenticationEntryPoint pauthenticationEntryPoint;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		    .authorizeRequests()
		  	.antMatchers("/ecomm/**").hasAnyRole("ADMIN","USER")
			.and().httpBasic();
			
			//.httpBasic().realmName("security application Realm")
			//.authenticationEntryPoint(pauthenticationEntryPoint);
	} 
	
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
    
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
	}
}