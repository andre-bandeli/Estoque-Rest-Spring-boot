package com.br.Maintenance.maintenance.service;


import com.br.Maintenance.maintenance.model.Ativos;
import com.br.Maintenance.maintenance.model.Funcionario;
import com.br.Maintenance.maintenance.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
    public List<Funcionario> funcionariosList() {
        return (List<Funcionario>) funcionarioRepository.findAll();
    }
    public Funcionario funconarioPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }
    public String deleteFuncionarioById(Long id) {
        funcionarioRepository.deleteById(id);
        return "card removido!!" + id;
    }

}
