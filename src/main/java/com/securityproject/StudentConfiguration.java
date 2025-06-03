package com.securityproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class StudentConfiguration extends WebSecurityConfigurerAdapter {
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("hari").password("$2a$12$Tl4Rwk8abEr9cPKQLIE5u.wvAglxxxjJj4fScp9MerPVkRwfMqomC").roles("Student");
//	}
//	
////	@Bean 
////	public PasswordEncoder getPass() {
////		return NoOpPasswordEncoder.getInstance();
////	}
//	
//	@Bean
//	public PasswordEncoder getPass() {
//		return new BCryptPasswordEncoder(12);
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("hari").password("$2a$12$Tl4Rwk8abEr9cPKQLIE5u.wvAglxxxjJj4fScp9MerPVkRwfMqomC").roles("Student").
		and().withUser("ajay").password("$2a$12$B3.w0wxMcAXrN6eNnZ4p4.TqtT6x3VLO2piqfN2eHnQi/vIahEKjG").roles("Trainer").
		and().withUser("nisha").password("$2a$12$emBTv8/l0NM.1NByFZ1aO.octxkhoEDlJjY16WrvrS1ViOq8az7Ny").roles("manager");		
		
	}
	
	@Bean
	public PasswordEncoder getPass() {
		return new BCryptPasswordEncoder(12);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/getManager").hasRole("manager");
		http.authorizeRequests().antMatchers("/getTrainer").hasAnyRole("manager","Trainer");
		http.authorizeRequests().antMatchers("/getStudent").permitAll().and().formLogin();
		
	}

}