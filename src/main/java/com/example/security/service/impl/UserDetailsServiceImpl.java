package com.example.security.service.impl;

import com.example.security.entity.Users;
import com.example.security.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepo.findByName(username).orElseThrow(() -> new RuntimeException("User not found"));
        UserDetails userDetails = User.builder()
                .username(users.getName())
                .password(users.getPassword())
                .authorities()
                .build();
        return
    }
}
