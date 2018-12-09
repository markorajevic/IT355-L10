/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 *
 * @author Vlada
 */
@Configuration
@EnableWebSecurity
public class TodoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("vlada").password("user").authorities("USER")
                .and()
                .withUser("admin").password("admin").authorities("USER", "ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/todos*").hasAuthority("ADMIN")
                .antMatchers("/todos*").hasAuthority("USER")
                .and()
                .formLogin();
        /*   .and();
        .csrf().disable();*/
 /*HttpSessionCsrfTokenRepository repo = new HttpSessionCsrfTokenRepository();
        repo.setSessionAttributeName("csfr_token");
        repo.setParameterName("csfr_token");
        http.csrf().csrfTokenRepository(repo);*/

    }

}
