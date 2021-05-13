package ru.netology.springsecuritytask.services;

import lombok.val;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.netology.springsecuritytask.entities.Authorities;
import ru.netology.springsecuritytask.entities.Role;
import ru.netology.springsecuritytask.repositories.UsersRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomizedUserDetailService implements UserDetailsService {
    private final UsersRepository usersRepository;

    public CustomizedUserDetailService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        val user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
        return new User(user.getUsername(), user.getPassword(), getAuthorities(user.getRoles()));
    }

    private Set<SimpleGrantedAuthority> getAuthorities(Set<Role> roles) {
        Set<String> authorities = new HashSet<>();
        roles.forEach(role -> authorities.add("ROLE_" + role.getName()));
        roles.forEach(role -> authorities.addAll(role.getAuthorities().stream().map(Authorities::getName).collect(Collectors.toSet())));
        authorities.forEach(System.out::println);
//        roles.forEach(role -> authorities.addAll(role.getAuthorities().f));
        return authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }
}
