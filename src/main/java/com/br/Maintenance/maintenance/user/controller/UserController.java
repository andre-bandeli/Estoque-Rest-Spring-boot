package com.br.Maintenance.maintenance.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class UserController {

    @RequestMapping("/entrar")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping("/")
    public String index() {
        return "template/pages/solicitacao/solicitacao";
    }
}
