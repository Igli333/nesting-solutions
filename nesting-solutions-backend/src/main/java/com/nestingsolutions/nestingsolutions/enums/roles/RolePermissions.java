package com.nestingsolutions.nestingsolutions.enums.roles;

public enum RolePermissions {

    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_MODIFY("user:modify"),
    FILE_READ("file:read"),
    FILE_WRITE("file:write"),
    FILE_MODIFY("file:modify");

    private final String permissions;

    RolePermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }
}
