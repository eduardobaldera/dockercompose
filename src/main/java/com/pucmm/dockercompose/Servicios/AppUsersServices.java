package com.pucmm.dockercompose.Servicios;

import com.pucmm.dockercompose.Clases.Rol;
import com.pucmm.dockercompose.Clases.User;
import com.pucmm.dockercompose.Repositorios.RolesRepository;
import com.pucmm.dockercompose.Repositorios.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class AppUsersServices {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RolesRepository rr;

    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    @Transactional
    public void createUsers() {
        if (usersRepository.findByUsername("admin") == null) {

            rr.save(new Rol("ADMIN"));
            rr.save(new Rol("USER"));
            usersRepository.save(
                    new User("admin",
                            bcrypt.encode("admin"),
                            true,
                            new HashSet<>(Arrays.asList(rr.findByRol("ADMIN")))
                    )
            );

            usersRepository.save(
                    new User("user",
                            bcrypt.encode("password"),
                            true,
                            new HashSet<>(Arrays.asList(rr.findByRol("USER")))
                    )
            );
        }
    }
}
