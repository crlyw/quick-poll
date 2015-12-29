package com.apress;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter{

	public void configure(ResourceServerSecurityConfigurer resources){
		resources.resourceId("QuickPoll_Resources");
	}
	
	public void configure(HttpSecurity http) throws Exception{
		http
			.requestMatchers().antMatchers("/oauth2/v3/polls/**")
			.and()
			.authorizeRequests().antMatchers("/oauth2/v3/polls/**").authenticated();
	}
}
