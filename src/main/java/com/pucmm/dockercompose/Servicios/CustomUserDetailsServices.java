package com.pucmm.dockercompose.Servicios;

import com.pucmm.dockercompose.Clases.Rol;
import com.pucmm.dockercompose.Clases.User;
import com.pucmm.dockercompose.Repositorios.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsServices implements UserDetailsService {
    @Autowired
    private UsersRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = ur.findByUsername(username);

        Set<GrantedAuthority> roles = new HashSet<>();
        for (Rol role : user.getRoles())
            roles.add(new SimpleGrantedAuthority(role.getRol()));


        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                user.getActive(),
                true,
                true,
                true,
                grantedAuthorities
        );
    }
}
