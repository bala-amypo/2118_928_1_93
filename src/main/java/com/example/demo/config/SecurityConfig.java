package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            // VERY IMPORTANT
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(auth -> auth
                // 🔓 Swagger allow
                .requestMatchers(
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-ui.html"
                ).permitAll()

                // 🔓 Auth allow
                .requestMatchers("/auth/**").permitAll()

                // 🔐 Everything else secured
                .anyRequest().authenticated()
            )

            // ❌ Disable default login form
            .formLogin(form -> form.disable())

            // ❌ Disable basic auth popup
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
