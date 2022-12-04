package com.naijagis4me.v1.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.naijagis4me.v1.enums.Role.*;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth) -> {
                    auth.antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                            .antMatchers("/api/v1/super-admin/**").hasRole(SUPER_ADMIN.name())
                            .antMatchers("/api/v1/admin/**").hasAnyRole(ADMIN.name(), SUPER_ADMIN.name())
                            .antMatchers("/api/v1/auth/admin/**").hasAnyRole(ADMIN.name(), SUPER_ADMIN.name())
                            .antMatchers("/ap1/v1/auth/user/**").hasAnyRole(CLIENT.name(), ARTISAN.name())
                            .antMatchers("/api/v1/user/**").hasAnyRole(CLIENT.name(), ARTISAN.name())
                            .antMatchers("/api/v1/user/client/**").hasRole(CLIENT.name());

                }).formLogin().and()
                .build();

    }

    //    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails superAdmin = User.builder()
                .username("superAdmin")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN.name())
//                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN.name())
//                .authorities(STUDENT.getGrantedAuthorities())
                .build();

        UserDetails client = User.builder()
                .username("client")
                .password(passwordEncoder.encode("password123"))
                .roles(CLIENT.name())
//                .authorities(STUDENT.getGrantedAuthorities())
                .build();

        UserDetails artisan = User.builder()
                .username("artisan")
                .password(passwordEncoder.encode("password123"))
                .roles(ARTISAN.name())
//                .authorities(ADMINTRAINEE.getGrantedAuthorities())
                .build();


        return new InMemoryUserDetailsManager(superAdmin, admin, artisan, client);
    }
}
