package com.Test.praktek.moduleMembership.service;

import com.Test.praktek.moduleMembership.entity.Users;
import com.Test.praktek.moduleMembership.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Users user = repository.findById(email)
                .orElseThrow(() -> new UsernameNotFoundException("email " + email + " tidak ditemukan"));
        return UserDetailsImpl.build(user);

    }

}
