package com.br.Maintenance.maintenance.controller.produtos;


import com.br.Maintenance.maintenance.model.ListaCompras;
import com.br.Maintenance.maintenance.model.Produto;
import com.br.Maintenance.maintenance.model.Solicitacao;
import com.br.Maintenance.maintenance.service.ListaCompraService;
import com.br.Maintenance.maintenance.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/v1/produto")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping("/add")
    public Produto addProduto(@RequestBody Produto produto) {
        return service.addProduto(produto);
    }

    @GetMapping("get/{id}")
    public Optional<Produto> getProduto(@PathVariable Long id) {
        return service.getProdutoById(id);
    }

    @PostMapping("/addlista")
    public List<Produto> addListaProduto(@RequestBody List<Produto> produtoList) {
        return service.addListaProduto(produtoList);
    }

    @GetMapping("/list")
    @CrossOrigin(origins = {"http://localhost:3000/ss", "http://localhost:3000/new-ordem"})
    public List<Produto> produtoList() {
        return service.produtoList();
    }

    @DeleteMapping("/remove/{id}")
    @CrossOrigin(origins = "http://localhost:3000/ss")
    public void  removeSolicitacao(@PathVariable Long id) {
        service.deleteProdutoById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Produto> updateProdutoById(@PathVariable(value = "id") Long id,
                                                             @RequestBody Produto produto) {
        Long codigo = produto.getCodigo();
        String nome = produto.getNome();
        int saldo = produto.getSaldo();
        int saldoMin = produto.getSaldoMin();

        service.updateProdutoById(id, codigo, nome, saldo, saldoMin);

        return ResponseEntity.ok().body(produto);
    }
}
