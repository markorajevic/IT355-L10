/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Vlada
 */
@Configuration
@EnableWebSecurity
public class TodoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("mem:board")
                .addScript("classpath:/schema.sql")
                .addScript("classpath:/data.sql")
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).dataSource(dataSource());
    }*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .passwordEncoder(passwordEncoder())
                .dataSource(dataSource());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/todos*").hasAuthority("USER")
                .antMatchers(HttpMethod.DELETE, "/todos*").hasAuthority("ADMIN")
                .and()
                .httpBasic().disable()
                .formLogin()
                .loginPage("/login.jsp")
                .loginProcessingUrl("/login")
                .failureUrl("/login.jsp?error=true")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/logout-success.jsp");
    }

    /* public TodoSecurityConfig() {
        supe*/

 /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("vlada").password("user").authorities("USER")
                .and()
                .withUser("admin").password("admin").authorities("USER", "ADMIN")
                .and()
                .withUser("student").password("student").disabled(true).authorities("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/todos*").hasAuthority("USER")
                .antMatchers(HttpMethod.DELETE, "/todos*").hasAuthority("ADMIN")
            .and()
                .anonymous()
            .and()
                .servletApi()
            .and()
                .securityContext()
            .and()
                .exceptionHandling()
            .and()
                .rememberMe()
            .and()
                .formLogin()
                    .loginPage("/login.jsp")
                    .loginProcessingUrl("/login")
                    .failureUrl("/login.jsp?error=true")
                    .defaultSuccessUrl("/todos")
                .permitAll()
            .and()
                .logout().logoutSuccessUrl("/logout-success.jsp")
            .and()
                .headers()
            .and()
                .csrf();
    }*/
 /*   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("vlada").password("user").authorities("USER")
                .and()
                .withUser("admin").password("admin").authorities("USER", "ADMIN");

    }*/

 /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/todos*").hasAuthority("ADMIN")
                .antMatchers("/todos*").hasAuthority("USER")
                .and()
                .formLogin();*/
 /*   .and();
        .csrf().disable();*/
 /*HttpSessionCsrfTokenRepository repo = new HttpSessionCsrfTokenRepository();
        repo.setSessionAttributeName("csfr_token");
        repo.setParameterName("csfr_token");
        http.csrf().csrfTokenRepository(repo);*/
    //}
}
