package com.example.BookMyShow.service;

import com.example.BookMyShow.Security.CustomUserDetails;
import com.example.BookMyShow.model.User;
import com.example.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {
@Autowired
    private UserRepository urObj;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = urObj.findByUsername(username);
        return new CustomUserDetails(user);

    }
}
