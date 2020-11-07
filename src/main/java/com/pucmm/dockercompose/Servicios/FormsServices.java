package com.pucmm.dockercompose.Servicios;

import com.pucmm.dockercompose.Clases.Form;
import com.pucmm.dockercompose.Repositorios.FormsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FormsServices {
    @Autowired
    private FormsRepository formsRepository;

    @Transactional
    public Form saveForm(Form form) {
        formsRepository.save(form);
        return form;
    }
}
