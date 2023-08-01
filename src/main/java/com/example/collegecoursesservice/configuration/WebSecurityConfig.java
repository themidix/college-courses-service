package com.example.collegecoursesservice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity(debug = false) // Compliant
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
}
