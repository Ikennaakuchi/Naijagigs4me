package com.naijagis4me.v1.config.userDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    private final AppUserDaoService appUserDaoService;

    @Autowired
    public AppUserDetailsService(AppUserDaoService appUserDaoService) {
        this.appUserDaoService = appUserDaoService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("TRYING TO LOAD BY USERNAME!!!!!!!!! " + username);
        return appUserDaoService.setAppUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found.", username)));
    }

}
