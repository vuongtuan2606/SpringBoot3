package com.tuandev.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // adding usser, passwords and roles use InMemoryUserDetailsManager
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

         UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // restrict access based on the HTTP request
        http.authorizeHttpRequests(configurer ->
                        configurer
                                // Any request to the app must be auhthenticated( in logged in)
                                .anyRequest().authenticated()
                )
                // We are customizing the form login process
                .formLogin(form ->
                        form
                                //show our custom form at the request mapping
                                .loginPage("/showMyLoginPage")
                                // Login form should POST data to this URL for processing
                                // ( check user id and password)
                                .loginProcessingUrl("/authenticateTheUser")
                                // Allow everyone to see login page.
                                // no need to be logged in
                                .permitAll()
                );

        return http.build();
    }
}












