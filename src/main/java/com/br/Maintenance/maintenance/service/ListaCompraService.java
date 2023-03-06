package com.br.Maintenance.maintenance.service;

import com.br.Maintenance.maintenance.model.ListaCompras;
import com.br.Maintenance.maintenance.repository.ListaCompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ListaCompraService {

    @Autowired
    private ListaCompraRepositorio listaCompraRepositorio;

    public ListaCompras addListaCompras(ListaCompras solicitacao) {
        return listaCompraRepositorio.save(solicitacao);
    }
    public List<ListaCompras> listaComprasList() {
        return (List<ListaCompras>) listaCompraRepositorio.findAll();
    }

    public Optional<ListaCompras> getListaComprasById(Long id) {
        return listaCompraRepositorio.findById(id);
    }

    public List<ListaCompras> addListaListaCompras(List<ListaCompras> solicitacaoList) {
        return (List<ListaCompras>) listaCompraRepositorio.saveAll(solicitacaoList);
    }
    public void deleteListaComprasById(Long id) {
        listaCompraRepositorio.deleteById(id);
    }

}
