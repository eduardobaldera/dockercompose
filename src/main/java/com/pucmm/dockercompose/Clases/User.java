package com.pucmm.dockercompose.Clases;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@EnableAutoConfiguration
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private boolean active;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Rol> roles;

    public User() {}

    public User(String username, String password, boolean active, Set<Rol> roles) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean getActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

    public Set<Rol> getRoles() { return roles; }

    public void setRoles(Set<Rol> roles) { this.roles = roles; }
}
