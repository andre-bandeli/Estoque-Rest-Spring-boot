package com.br.Maintenance.maintenance.controller;


import com.br.Maintenance.maintenance.model.Funcionario;
import com.br.Maintenance.maintenance.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/")
    public String index() {
        return "Funcionarios";
    }

    @GetMapping("/add")
    public Funcionario save(Funcionario funcionario) {
        return funcionarioService.salvarFuncionario(funcionario);
    }
    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable Long id) {
        return funcionarioService.funconarioPorId(id);
    }

    @GetMapping("/remove/{id}")
    public String  removeFuncionario(@PathVariable Long id) {
        return funcionarioService.deleteFuncionarioById(id);
    }

//    @PutMapping("/update/{id}")
//    public Funcionario updateFuncionario(Funcionario funcionario) {
//        return  funcionarioService.updateFuncionario(funcionario);
//    }


}
