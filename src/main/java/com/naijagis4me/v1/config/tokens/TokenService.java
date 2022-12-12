package com.naijagis4me.v1.config.tokens;


import org.springframework.security.core.Authentication;

public interface TokenService {
    String generateToken(Authentication authentication);
}
