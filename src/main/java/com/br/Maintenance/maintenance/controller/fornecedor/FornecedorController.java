package com.br.Maintenance.maintenance.controller.fornecedor;

import com.br.Maintenance.maintenance.model.Fornecedor;
import com.br.Maintenance.maintenance.service.FornecedorService;
import com.br.Maintenance.maintenance.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fornecedor")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping("/add")
    public Fornecedor saveFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.addFornecedor(fornecedor);
    }
    @GetMapping("/list")
    public List<Fornecedor> getListFornecedor() {
        return fornecedorService.listFornecedor();
    }

    @GetMapping("/getfornecedor/{id}")
    public Optional<Fornecedor> getFornecedor(Long id) {
        return fornecedorService.getFornecedorById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFornecedor(@PathVariable Long id) {
        fornecedorService.deleteFornecedorById(id);
    }


}
