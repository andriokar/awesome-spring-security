package com.andriokar.springsecex.service;

import com.andriokar.springsecex.entities.User;
import com.andriokar.springsecex.entities.UserPrincipal;
import com.andriokar.springsecex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            System.out.printf("User with user name %s was not found%n", userName);
            throw new UsernameNotFoundException("User with user name %s was not found".formatted(userName));
        }

        return new UserPrincipal(user);
    }
}
