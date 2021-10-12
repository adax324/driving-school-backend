package com.example.appstarter.user.authorities;

import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.function.Supplier;

public enum AuthorityWrapper {
    ADMIN("admin", AdminAuthority::new),
    STUDENT("student",StudentAuthority::new);
    private final String roleName;
    private final Supplier<GrantedAuthority> authority;

    AuthorityWrapper(String roleName, Supplier<GrantedAuthority> authority) {
        this.roleName=roleName;
        this.authority =authority;
    }
    public static GrantedAuthority getAuthorityByName(String name){
        return Arrays.stream(values()).filter(authorityWrapper -> authorityWrapper.roleName.equals(name))
                .findFirst().get().authority.get();
    }
}
