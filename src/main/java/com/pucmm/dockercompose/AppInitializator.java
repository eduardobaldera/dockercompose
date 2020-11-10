package com.pucmm.dockercompose;

import com.pucmm.dockercompose.Servicios.AppUsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AppInitializator {
    @Autowired
    AppUsersServices appUsersServices;

    @PostConstruct
    private void initConfig() { appUsersServices.createUsers(); }
}
