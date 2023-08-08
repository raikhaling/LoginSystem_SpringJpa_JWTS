package com.khaling.springsecurityjwt2.services;

import com.khaling.springsecurityjwt2.Entity.ApplicationUser;
import com.khaling.springsecurityjwt2.Entity.Role;
import com.khaling.springsecurityjwt2.repository.RoleRepository;
import com.khaling.springsecurityjwt2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public ApplicationUser registerUser(String username, String password){
        log.info("in the register user");
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepository.save(new ApplicationUser(1,username,encodedPassword,authorities));
    }

}
