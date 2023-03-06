package com.br.Maintenance.maintenance.service;

import com.br.Maintenance.maintenance.model.Produto;
import com.br.Maintenance.maintenance.model.Produto;
import com.br.Maintenance.maintenance.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto addProduto(Produto solicitacao) {
        return produtoRepository.save(solicitacao);
    }
    public List<Produto> produtoList() {
        return (List<Produto>) produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> addListaProduto(List<Produto> solicitacaoList) {
        return (List<Produto>) produtoRepository.saveAll(solicitacaoList);
    }
    public void deleteProdutoById(Long id) {
        produtoRepository.deleteById(id);
    }

    public void updateProdutoById(Long id, Long codigo, String nome, int saldo, int saldoMin) {
        produtoRepository.findById(id).ifPresent(produto -> {
            produto.setCodigo(codigo);
            produto.setNome(nome);
            produto.setSaldo(saldo);
            produto.setSaldoMin(saldoMin);

            produtoRepository.save(produto);
        });
    }
}
