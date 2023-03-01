package com.br.Maintenance.maintenance.controller.ordens;

import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.service.OrdemService;
import com.br.Maintenance.maintenance.model.Solicitacao;
import com.br.Maintenance.maintenance.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/so")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class SolicitacaoServicoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:3000/ss")
    public List<Solicitacao> solicitacoesList() {
        return solicitacaoService.ListSolicitacao();
    }
    @GetMapping("get/{id}")
    public Optional<Solicitacao> getSolicitacao(@PathVariable Long id) {
        return Optional.ofNullable(solicitacaoService.ListSolicitacaoPorId(id));
    }

    @PostMapping("/add")
    public Solicitacao addSolicitacao(@RequestBody Solicitacao solicitacao) {
        return solicitacaoService.salvarSolicitacao(solicitacao);
    }

    @PostMapping("/addlista")
    public List<Solicitacao> addListSolicitacoes(@RequestBody List<Solicitacao> solicitacaoList) {
        return solicitacaoService.addListaSolicitacao(solicitacaoList);
    }

    @GetMapping("/remove/{id}")
    public void  removeSolicitacao(@PathVariable Long id) {
        solicitacaoService.deleteSolicitacaoById(id);
    }
}
