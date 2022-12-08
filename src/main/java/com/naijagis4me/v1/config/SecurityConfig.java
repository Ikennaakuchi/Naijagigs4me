package com.naijagis4me.v1.config;

import com.naijagis4me.v1.config.userDetails.AppUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;

import static com.naijagis4me.v1.enums.Role.*;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    private final String[] WHITE_LISTED_URLS = { "/", "index", "/css/*", "/js/*" };
    private final AppUserDetailsService appUserDetailsService;
    private static final String AUTHORITY_PREFIX = "ROLE_";
    private static final String CLAIM_ROLES = "roles";


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth) -> {
                auth.antMatchers(WHITE_LISTED_URLS).permitAll()
                            .antMatchers("/api/v1/super-admin").hasRole(SUPERADMIN.name())
                            .antMatchers("/api/v1/admin/**").hasAnyRole(ADMIN.name(), SUPERADMIN.name())
                            .antMatchers("/api/v1/auth/admin/**").hasAnyRole(ADMIN.name(), SUPERADMIN.name())
                            .antMatchers("/ap1/v1/auth/user/**").hasAnyRole(USER.name())
                            .antMatchers("/api/v1/user/**").hasAnyRole(USER.name())
                            .antMatchers("/api/v1/user/client/**").hasRole(USER.name())
                            .anyRequest().authenticated();
                })
                .userDetailsService(appUserDetailsService)
                .oauth2ResourceServer(oauth2ResourceServer ->
                        oauth2ResourceServer
                                .jwt(jwt ->
                                        jwt.jwtAuthenticationConverter(getJwtAuthenticationConverter()))
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(withDefaults())
                .build();
    }

    private Converter<Jwt, AbstractAuthenticationToken> getJwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(getJwtGrantedAuthoritiesConverter());
        return jwtAuthenticationConverter;
    }

    private Converter<Jwt, Collection<GrantedAuthority>> getJwtGrantedAuthoritiesConverter() {
        JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
        converter.setAuthorityPrefix(AUTHORITY_PREFIX);
        converter.setAuthoritiesClaimName(CLAIM_ROLES);

        return converter;
    }
}
