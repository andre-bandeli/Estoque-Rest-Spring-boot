package com.br.Maintenance.maintenance.service;


import com.br.Maintenance.maintenance.model.Ativos;
import com.br.Maintenance.maintenance.repository.AtivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtivoService {


    @Autowired
    private AtivosRepository ativosRepository;

    public Ativos salvarAtivo(Ativos ativos) {
        return ativosRepository.save(ativos);
    }
    public List<Ativos> ativosList() {
        return (List<Ativos>) ativosRepository.findAll();
    }
    public Ativos ativoPorId(Long id) {
        return ativosRepository.findById(id).orElse(null);
    }
    public String deleteAtivoById(Long id) {
        ativosRepository.deleteById(id);
        return "card removido!!" + id;
    }

}
