package com.br.Maintenance.maintenance.service;

import com.br.Maintenance.maintenance.model.Fornecedor;
import com.br.Maintenance.maintenance.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor addFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listFornecedor() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> getFornecedorById(Long id) {
        return fornecedorRepository.findById(id);
    }

    public List<Fornecedor> addListaFornecedor(List<Fornecedor> fornecedorList) {
        return fornecedorRepository.saveAll(fornecedorList);
    }

    public void deleteFornecedorById(Long id){
        fornecedorRepository.deleteById(id);
    }
}
