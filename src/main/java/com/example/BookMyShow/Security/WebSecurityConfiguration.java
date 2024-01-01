package com.example.BookMyShow.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.cors().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                //store room part
                .antMatchers("/addMovie").hasAuthority("manager")
                .antMatchers("/displayAllMovie").hasAnyAuthority( "manager", "customer")
                .antMatchers("/displayMovieByName/{mname}").hasAnyAuthority("manager", "customer")
                .antMatchers("/displayMovieById/{mid}").hasAnyAuthority("manager", "customer")
                .antMatchers("/deleteAllMovie").hasAuthority("manager")
                .antMatchers("/deleteMovieByID/{mid}").hasAuthority("manager")
                .antMatchers("/updateMovie/{mid}").hasAuthority("manager")
                //order part
                .antMatchers("/addOrder").hasAuthority("customer")
                .antMatchers("/displayAllOrder").hasAuthority( "manager")
                .antMatchers("/displayOrderByID/{oid}").hasAnyAuthority("manager", "customer")
                .antMatchers("/deleteAllOrder").hasAuthority("manager")
                .antMatchers("/deleteOrderByID/{oid}").hasAnyAuthority("manager")
                .antMatchers("/updateOrder/{oid}").hasAnyAuthority( "manager", "customer")
                .anyRequest().authenticated().and().httpBasic();

    }

}
