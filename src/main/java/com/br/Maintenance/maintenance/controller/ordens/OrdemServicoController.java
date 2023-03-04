package com.br.Maintenance.maintenance.controller.ordens;

import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.model.Solicitacao;
import com.br.Maintenance.maintenance.service.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/os")
public class OrdemServicoController {

    @Autowired
    private OrdemService ordemService;


    @PostMapping("/add")
    public Ordem saveOrdem(@RequestBody Ordem ordem) {
        return ordemService.addOrdem(ordem);
    }

    @GetMapping("/list")
    public List<Ordem> getListOrdem() {
        return ordemService.getListaOrdem();
    }

    @GetMapping("/getordem/{id}")
    public Optional<Ordem> getOrdem(Long id) {
        return ordemService.getOrdem(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ordem> updateOrdemById(@PathVariable(value = "id") Long id,
                                                             @RequestBody Ordem ordem) {
        int codigo = ordem.getCodigo();
        String maquina = ordem.getMaquina();
        String setor = ordem.getSetor();
        String nomeSolicitante = ordem.getNomeSolicitante();
        Date dataSolicitacao = ordem.getDataSolicitacao();
        String descricao = ordem.getDescricao();
        boolean isUrgente = ordem.getIs_urgente();
        boolean status = ordem.getStatus();
        Date dataFechamento = ordem.getDataFechamento();
        String tecnicoResponsavel = ordem.getTecnicoResponsavel();
        String observacoes = ordem.getObservacoes();

        ordemService.updateOrdemById(id, codigo, maquina, setor, nomeSolicitante, dataSolicitacao, descricao, isUrgente, status, dataFechamento, tecnicoResponsavel, observacoes);

        return ResponseEntity.ok().body(ordem);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrdem(@PathVariable Long id) {
        ordemService.deleteOrdemById(id);
    }


}
