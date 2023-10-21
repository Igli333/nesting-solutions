package com.nestingsolutions.nestingsolutions.security.config;

import com.nestingsolutions.nestingsolutions.enums.roles.Role;
import com.nestingsolutions.nestingsolutions.entities.Administrator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class UserInfoUserDetails implements UserDetails {

    private String email;
    private String password;
    private Set<SimpleGrantedAuthority> authorities;

    public UserInfoUserDetails(Administrator userInfo) {
        email=userInfo.getEmail();
        password=userInfo.getPassword();
        authorities= Role.ADMIN.getGrantedAuthorities();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
