package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService
    ) {
        this.userDetailsService = userDetailsService;

    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().disable()
                .cors()

                .and()
                .headers().frameOptions().disable()

                .and()
                .authorizeRequests()
                .antMatchers("/").hasAuthority("student")


                .and()
                .formLogin()
                .loginPage("/user/signin")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutSuccessUrl("/user/signin");







//        http.authorizeRequests()
//                .antMatchers("/").authenticated()
//                .anyRequest().permitAll()
//
//                .and()
//                .csrf().disable()
//                .headers().frameOptions().disable()
//                .and()
//                .formLogin()
////                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
////        .failureForwardUrl("/login?error")
//        .defaultSuccessUrl("/")
//        .and()
//        .logout()
//        .logoutSuccessUrl("/login");
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }


}
