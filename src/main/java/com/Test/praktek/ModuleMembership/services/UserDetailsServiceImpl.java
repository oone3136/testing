package com.Test.praktek.ModuleMembership.services;

import com.Test.praktek.ModuleMembership.entity.Users;
import com.Test.praktek.ModuleMembership.repository.UsersRepository;
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
                .orElseThrow(() -> new UsernameNotFoundException("Username " + email + " tidak ditemukan"));
        return UserDetailsImpl.build(user);

    }

}
