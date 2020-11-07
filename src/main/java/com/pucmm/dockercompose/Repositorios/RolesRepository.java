package com.pucmm.dockercompose.Repositorios;

import com.pucmm.dockercompose.Clases.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Rol, String> {
    public Rol findByRole(String role);
}
