package com.in28minutes.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // all requests are authenticated
        httpSecurity.authorizeRequests(auth -> auth.anyRequest().authenticated());

        //if not auth, show block page
        httpSecurity.httpBasic(withDefaults());

        //disable csrf
        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }
}
