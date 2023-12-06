/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kls.auth;

import com.kls.data.User;
import com.kls.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bsystems4
 */
@Service
public class BankUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    public User user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Cannot find user " + username);
        }
        return new UserPrincipal(user);
//        return new UserPrincipal(new AuthUser("gentlest"));
    }

}
