package com.br.Maintenance.maintenance.service;

import com.br.Maintenance.maintenance.model.Funcionario;
import com.br.Maintenance.maintenance.model.ListaCompras;
import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.repository.ListaCompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaCompraService {

    @Autowired
    private ListaCompraRepositorio repository;


    public ListaCompras salvarListaCompra(ListaCompras listaCompras) {
        return repository.save(listaCompras);
    }
    public List<ListaCompras> ListaCompraList() {
        return (List<ListaCompras>) repository.findAll();
    }
    public ListaCompras ListaCompraPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    public String deleteListaCompraById(Long id) {
        repository.deleteById(id);
        return "lista de compras removido!!" + id;
    }

}
