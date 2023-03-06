package com.br.Maintenance.maintenance.service;


import com.br.Maintenance.maintenance.model.Maquina;
import com.br.Maintenance.maintenance.repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaquinaService {
    @Autowired
    private MaquinaRepository maquinaRepository;

    public Maquina addMaquina(Maquina maquina) {
        return maquinaRepository.save(maquina);
    }
    public List<Maquina> maquinasList() {
        return (List<Maquina>) maquinaRepository.findAll();
    }
    public Maquina getMaquinaById(Long id) {
        return maquinaRepository.findById(id).orElse(null);
    }
    public String deleteMaquinaById(Long id) {
        maquinaRepository.deleteById(id);
        return "card removido!!" + id;
    }

}
