package ru.orlovvv.wilt.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.orlovvv.wilt.entity.User;
import ru.orlovvv.wilt.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static User build(User user) {
        List<GrantedAuthority> authorities = user.getRole().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());

        return new User(user.getId(), user.getLogin(), user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
        User user = userRepository.findUserByEmail(login).orElseThrow(() -> new UsernameNotFoundException("Login not found"));
        return build(user);
    }


}
