package com.khaling.springsecurityjwt2.services;

import com.khaling.springsecurityjwt2.Entity.ApplicationUser;
import com.khaling.springsecurityjwt2.Entity.Role;
import com.khaling.springsecurityjwt2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String  username) throws UsernameNotFoundException {
        log.info("In the user details service");
//        if(!username.equals("Nabin")) throw new UsernameNotFoundException("Not Nabin");
//
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(1,"USER"));
//
//        return new ApplicationUser(1,"Nabin",encoder.encode("password"),roles);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user is not valid"));

    }
}
