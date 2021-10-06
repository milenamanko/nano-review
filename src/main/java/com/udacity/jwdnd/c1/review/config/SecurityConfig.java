package com.udacity.jwdnd.c1.review.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**", "/js/**").permitAll()
                .antMatchers("/chat").authenticated();

        http.formLogin().loginPage("/login").permitAll();

        http.formLogin().defaultSuccessUrl("/chat", true);
    }
}
