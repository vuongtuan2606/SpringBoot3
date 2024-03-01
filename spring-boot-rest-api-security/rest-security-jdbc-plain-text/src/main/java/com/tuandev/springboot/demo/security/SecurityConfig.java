package com.tuandev.springboot.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    // add suport for JDBC ... no more hardcoded user

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"api/employee").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"api/employee/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"api/employee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"api/employee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"api/employee/**").hasRole("ADMIN")
        );
        // use HTTP Basic anthentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general , not required for stateless REST APIs use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
