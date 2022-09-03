package com.br.Maintenance.maintenance.service;

import com.br.Maintenance.maintenance.model.ListaCompras;
import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.model.Produto;
import com.br.Maintenance.maintenance.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;


    public Produto salvarProduto(Produto produto) {
        return repository.save(produto);
    }
    public List<Produto> ListProduto() {
        return (List<Produto>) repository.findAll();
    }
    public Produto ListProdutoPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    public String deleteProdutoById(Long id) {
        repository.deleteById(id);
        return "Produto removido!!" + id;
    }
}
