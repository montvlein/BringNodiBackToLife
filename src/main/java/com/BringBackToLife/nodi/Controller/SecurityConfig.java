package com.BringBackToLife.nodi.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .antMatcher("/user").authorizeRequests() // endpoints que requiere autorización
                .antMatchers().permitAll() // endpoints que no requiere autorización
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }



}