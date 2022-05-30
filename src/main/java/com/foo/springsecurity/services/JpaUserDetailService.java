package com.foo.springsecurity.services;

import com.foo.springsecurity.entity.User;
import com.foo.springsecurity.model.CustomerUserDetails;
import com.foo.springsecurity.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

/**
 * @author foo
 * @since 2022-05-30
 */
@Service
@RequiredArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public CustomerUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Problem during authentication!");
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(s);
        return new CustomerUserDetails(user);
    }
}
