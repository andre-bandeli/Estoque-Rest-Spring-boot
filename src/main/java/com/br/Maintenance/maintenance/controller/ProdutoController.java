package com.br.Maintenance.maintenance.controller;


import com.br.Maintenance.maintenance.model.ListaCompras;
import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.model.Produto;
import com.br.Maintenance.maintenance.service.ListaCompraService;
import com.br.Maintenance.maintenance.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private ListaCompraService listaCompraService;


    @GetMapping
    public String ProdutoHome(Model model) {

        List<Produto> l = service.ListProduto();
        model.addAttribute("produto", l);

        List<ListaCompras> lista = listaCompraService.ListaCompraList();
        model.addAttribute("lista", lista);

        return "template/pages/estoque/estoque";
    }


    @GetMapping("/add")
    public String addProduto(Model model) {
        // create model attribute to bind form data
        Produto produto = new Produto();
        model.addAttribute("produto", produto);

        return "template/pages/estoque/produtoAddForm";
    }


    @PostMapping("/saveProduto")
    public String saveProduto(@ModelAttribute Produto produto, Model model) {

        service.salvarProduto(produto);
        model.addAttribute("produto", produto);

        return "redirect:/api/produto";
    }

    @GetMapping("/view/{id}")
    public String getProdutoById(@PathVariable("id") Long id, Model model) {

        Produto produto = service.ListProdutoPorId(id);
        model.addAttribute("produto", produto);

        return "template/pages/estoque/produtoDescricao";
    }

//    @PutMapping("/update/{id}")
//    public String updateProduto(@PathVariable("id") Long id, Model model) {
//
//        Produto produto = new Produto();
//        service.updateProduto(id);
//
//        model.addAttribute("produto", produto);
//        return  "template/pages/estoque/produtoUpdateForm";
//    }

    @GetMapping("/remove/{id}")
    public String  removeProduto(@PathVariable Long id) {

        service.deleteProdutoById(id);
        return "/template/index";
    }

//    @PutMapping("/entrada/{id}/{valor}")
//    public Produto entrada(@PathVariable Long id, @PathVariable int valor) {
//        return service.entrada(id, valor);
//    }
//
//    @PutMapping("/saida/{id}/{valor}")
//    public Produto saida(@PathVariable Long id, @PathVariable int valor) {
//        return service.saida(id, valor);
//    }

}
