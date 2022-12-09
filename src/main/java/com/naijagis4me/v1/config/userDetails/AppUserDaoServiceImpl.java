package com.naijagis4me.v1.config.userDetails;

import com.google.common.collect.Lists;
import com.naijagis4me.v1.enums.Role;
import com.naijagis4me.v1.models.Person;
import com.naijagis4me.v1.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.naijagis4me.v1.enums.Role.*;

@RequiredArgsConstructor
@Repository
public class AppUserDaoServiceImpl implements AppUserDaoService {
//    private final PasswordEncoder passwordEncoder;
    private final PersonRepository personRepository;
    @Override
    public Optional<AppUserDetails> setAppUserByUsername(String email) {
        Person dbUser = personRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Not Found"));

        AppUserDetails appUserDetails = AppUserDetails.builder()
                .username(dbUser.getEmail())
                .password(dbUser.getPassword())
                .grantedAuthorities(dbUser.getRole().getGrantedAuthorities())
                .build();
        return Optional.of(appUserDetails);
    }
}
