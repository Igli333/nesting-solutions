package com.nestingsolutions.nestingsolutions.security.config;

import com.nestingsolutions.nestingsolutions.entities.Administrator;
import com.nestingsolutions.nestingsolutions.repository.AdministratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserInfoUserDetailsService implements UserDetailsService {

    private final AdministratorRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Administrator> userInfo = repository.findByEmail(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
