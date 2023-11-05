package com.binarfud.challenge6.Service.Impl;

import com.binarfud.challenge6.Model.UserDetailsImpl;
import com.binarfud.challenge6.Model.Users;
import com.binarfud.challenge6.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Users user = userRepository.findByUsername(username)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("User not found with username " + username));
            UserDetails userDetails = UserDetailsImpl.build(user);
            log.info("User details loaded for username: {}", username);
            return userDetails;
        } catch (UsernameNotFoundException e) {
            log.error("User not found: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Error while loading user details: " + e.getMessage(), e);
            throw new UsernameNotFoundException("Error while loading user details for username " + username, e);
        }
    }
}
