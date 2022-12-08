package com.naijagis4me.v1.config.userDetails;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.naijagis4me.v1.enums.Role.*;

@RequiredArgsConstructor
@Repository("fake")
public class AppUserDaoServiceImpl implements AppUserDaoService {
    private final PasswordEncoder passwordEncoder;
    @Override
    public Optional<AppUserDetails> setAppUserByUsername(String username) {
        Optional<AppUserDetails> user = getUsersFromMockDB().stream().filter(x -> x.getUsername().equals(username)).findFirst();
        System.out.println("APP DAO IMPL: " + user.orElseThrow(() -> new UsernameNotFoundException("Not Found")));
        return user;
    }

    public List<AppUserDetails> getUsersFromMockDB() {
        return Lists.newArrayList(
            AppUserDetails.builder()
                    .username("superAdmin")
                    .password(passwordEncoder.encode("password123"))
                    .grantedAuthorities(SUPERADMIN.getGrantedAuthorities())
                    .build(),

                AppUserDetails.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("password123"))
                        .grantedAuthorities(ADMIN.getGrantedAuthorities())
                        .build(),
            AppUserDetails.builder()
                    .username("client")
                    .password(passwordEncoder.encode("password123"))
                    .grantedAuthorities(CLIENT.getGrantedAuthorities())
                    .build(),

            AppUserDetails.builder()
                    .username("artisan")
                    .password(passwordEncoder.encode("password123"))
                    .grantedAuthorities(ARTISAN.getGrantedAuthorities())
                    .build()
        );
    }
}
