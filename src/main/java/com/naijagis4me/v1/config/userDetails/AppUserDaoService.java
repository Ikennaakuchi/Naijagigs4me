package com.naijagis4me.v1.config.userDetails;

import java.util.Optional;

public interface AppUserDaoService {
    Optional<AppUserDetails> setAppUserByUsername(String username);
}
