package com.nestingsolutions.nestingsolutions.dto.roles;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Sets.newHashSet(RolePermissions.USER_READ,RolePermissions.USER_MODIFY,RolePermissions.FILE_WRITE,RolePermissions.FILE_MODIFY,RolePermissions.FILE_READ)),
    ADMIN(Sets.newHashSet(RolePermissions.USER_READ, RolePermissions.USER_WRITE,
            RolePermissions.USER_MODIFY, RolePermissions.FILE_READ, RolePermissions.FILE_MODIFY, RolePermissions.FILE_WRITE));

    private final Set<RolePermissions> permissions;

    Role(Set<RolePermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<RolePermissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority>  getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermissions()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
