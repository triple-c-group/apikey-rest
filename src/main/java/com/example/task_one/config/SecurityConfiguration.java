package com.example.task_one.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final ApiKeyAuthFilter authFilter;
  private final UnauthorizedHandler unauthorizedHandler;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .cors(AbstractHttpConfigurer::disable)
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .formLogin(AbstractHttpConfigurer::disable)
        .exceptionHandling(configurer -> configurer.authenticationEntryPoint(unauthorizedHandler))
        .securityMatcher("/**")
        .authorizeHttpRequests(registry -> registry
            .requestMatchers("/healthcheck").permitAll()
            .anyRequest().authenticated())
        .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }
}
