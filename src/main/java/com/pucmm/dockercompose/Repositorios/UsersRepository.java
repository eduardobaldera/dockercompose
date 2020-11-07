package com.pucmm.dockercompose.Repositorios;

import com.pucmm.dockercompose.Clases.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
