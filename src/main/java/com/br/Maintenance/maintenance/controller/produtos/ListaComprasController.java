package com.br.Maintenance.maintenance.controller.produtos;


import com.br.Maintenance.maintenance.model.ListaCompras;
import com.br.Maintenance.maintenance.service.ListaCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/v1/compras")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ListaComprasController {

    @Autowired
    private ListaCompraService listaCompraService;

    @PostMapping("/add")
    public ListaCompras addListaCompras(@RequestBody ListaCompras produto) {
        return listaCompraService.addListaCompras(produto);
    }

    @GetMapping("get/{id}")
    public Optional<ListaCompras> getListaCompras(@PathVariable Long id) {
        return listaCompraService.getListaComprasById(id);
    }

    @PostMapping("/addlista")
    public List<ListaCompras> addListaListaCompras(@RequestBody List<ListaCompras> listaCompraList) {
        return listaCompraService.addListaListaCompras(listaCompraList);
    }

    @GetMapping("/list")
    @CrossOrigin(origins = {"http://localhost:3000/ss", "http://localhost:3000/new-ordem"})
    public List<ListaCompras> listaCompraList() {
        return listaCompraService.listaComprasList();
    }

    @DeleteMapping("/remove/{id}")
    @CrossOrigin(origins = "http://localhost:3000/ss")
    public void  removeListaCompra(@PathVariable Long id) {
        listaCompraService.deleteListaComprasById(id);
    }

}
