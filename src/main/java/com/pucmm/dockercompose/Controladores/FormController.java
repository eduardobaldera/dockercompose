package com.pucmm.dockercompose.Controladores;

import com.pucmm.dockercompose.Clases.Form;
import com.pucmm.dockercompose.Servicios.FormsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class FormController {
    @Autowired
    FormsServices formsServices;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexForm() {
        ModelAndView model = new ModelAndView();
        model.setViewName("form");

        return model;
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam("question-1") int first, @RequestParam("question-2") int second,
                             @RequestParam("question-3") int third, @RequestParam("comment") String comment
    ) {
        formsServices.saveForm(new Form(first, second, third, comment));

        return "redirect:/bye";
    }

    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    public ModelAndView endOfForm() {
        ModelAndView model = new ModelAndView();
        model.setViewName("bye");

        return model;
    }
}

