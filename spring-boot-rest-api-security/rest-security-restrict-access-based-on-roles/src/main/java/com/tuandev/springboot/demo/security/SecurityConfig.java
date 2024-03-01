package com.tuandev.springboot.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails tuan = User.builder()
                .username("tuan")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(tuan, john,susan);
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
