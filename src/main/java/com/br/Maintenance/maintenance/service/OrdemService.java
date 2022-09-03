package com.br.Maintenance.maintenance.service;

import com.br.Maintenance.maintenance.model.ListaCompras;
import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.repository.OrdemRepository;
import com.br.Maintenance.maintenance.model.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemService {

    @Autowired
    private OrdemRepository ordemRepository;

    public Ordem salvarOrdem(Ordem ordem) {
        return ordemRepository.save(ordem);
    }
    public List<Ordem> ListOrdem() {
        return (List<Ordem>) ordemRepository.findAll();
    }
    public Ordem ListOrdemPorId(Long id) {
        return ordemRepository.findById(id).orElse(null);
    }
    public String deleteOrdemById(Long id) {
        ordemRepository.deleteById(id);
        return "Ordem removido!!" + id;
    }
}
