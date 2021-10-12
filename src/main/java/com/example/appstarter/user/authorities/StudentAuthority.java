package com.example.appstarter.user.authorities;

import org.springframework.security.core.GrantedAuthority;

public class StudentAuthority implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "student";
    }
}
