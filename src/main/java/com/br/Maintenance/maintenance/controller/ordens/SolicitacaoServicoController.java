package com.br.Maintenance.maintenance.controller.ordens;

import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.service.OrdemService;
import com.br.Maintenance.maintenance.model.Solicitacao;
import com.br.Maintenance.maintenance.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/so")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class SolicitacaoServicoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @PostMapping("/add")
    public Solicitacao addSolicitacao(@RequestBody Solicitacao solicitacao) {
        return solicitacaoService.addSolicitacao(solicitacao);
    }

    @GetMapping("get/{id}")
    public Optional<Solicitacao> getSolicitacao(@PathVariable Long id) {
        return solicitacaoService.getSolicitacaoById(id);
    }

    @PostMapping("/addlista")
    public List<Solicitacao> addListSolicitacoes(@RequestBody List<Solicitacao> solicitacaoList) {
        return solicitacaoService.addListaSolicitacao(solicitacaoList);
    }

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:3000/ss")
    public List<Solicitacao> solicitacoesList() {
        return solicitacaoService.listAllSolicitacao();
    }

    @DeleteMapping("/remove/{id}")
    @CrossOrigin(origins = "http://localhost:3000/ss")
    public void  removeSolicitacao(@PathVariable Long id) {
        solicitacaoService.deleteSolicitacaoById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Solicitacao> updateSolicitacaoById(@PathVariable(value = "id") Long id,
                                                             @RequestBody Solicitacao solicitacaoDetails) {
        int codigo = solicitacaoDetails.getCodigo();
        String maquina = solicitacaoDetails.getMaquina();
        String setor = solicitacaoDetails.getSetor();
        String nomeSolicitante = solicitacaoDetails.getNomeSolicitante();
        Date dataSolicitacao = solicitacaoDetails.getDataSolicitacao();
        String descricao = solicitacaoDetails.getDescricao();
        boolean isUrgente = solicitacaoDetails.getIs_urgente();
        boolean status = solicitacaoDetails.getStatus();

        solicitacaoService.updateSolicitacaoById(id, codigo, maquina, setor, nomeSolicitante, dataSolicitacao, descricao, isUrgente, status);

        return ResponseEntity.ok().body(solicitacaoDetails);
    }
}
