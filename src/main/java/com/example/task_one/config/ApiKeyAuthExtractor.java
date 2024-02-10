package com.example.task_one.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class ApiKeyAuthExtractor {
  @Value("${application.security.api-key}")
  private String apiKey;
  private final String API_KEY_HEADER = "X-API-KEY";

  public Optional<Authentication> extract(HttpServletRequest request) {
    String providedKey = request.getHeader(API_KEY_HEADER);
    if (providedKey == null || !providedKey.equals(apiKey))
      return Optional.empty();

    return Optional.of(new ApiKeyAuthentication(providedKey, AuthorityUtils.NO_AUTHORITIES));
  }
}
