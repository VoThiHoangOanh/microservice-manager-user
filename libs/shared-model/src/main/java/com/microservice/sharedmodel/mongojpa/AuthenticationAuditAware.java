package com.microservice.sharedmodel.mongojpa;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuthenticationAuditAware implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.ofNullable(getUserId());
  }

  protected String getUserId() {
    return "Anonymous";
  }
}
