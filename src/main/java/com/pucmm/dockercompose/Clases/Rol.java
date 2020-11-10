package com.pucmm.dockercompose.Clases;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@EnableAutoConfiguration
public class Rol implements Serializable {
    @Id
    String rol;

    public Rol() {}

    public Rol(String rol) { this.rol = rol; }

    public String getRol() { return rol; }

    public void setRol(String rol) { this.rol = rol; }
}
