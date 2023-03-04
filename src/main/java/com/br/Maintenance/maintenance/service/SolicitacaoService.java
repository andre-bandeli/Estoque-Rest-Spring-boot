package com.br.Maintenance.maintenance.service;


import com.br.Maintenance.maintenance.model.Solicitacao;
import com.br.Maintenance.maintenance.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    public Solicitacao addSolicitacao(Solicitacao solicitacao) {
        return solicitacaoRepository.save(solicitacao);
    }

    public Optional<Solicitacao> getSolicitacaoById(Long id) {
        return solicitacaoRepository.findById(id);
    }

    public List<Solicitacao> addListaSolicitacao(List<Solicitacao> solicitacaoList) {
        return (List<Solicitacao>) solicitacaoRepository.saveAll(solicitacaoList);
    }

    public List<Solicitacao> listAllSolicitacao() {
        return (List<Solicitacao>) solicitacaoRepository.findAll();
    }
    public String deleteSolicitacaoById(Long id) {
        solicitacaoRepository.deleteById(id);
        return "Solicitacao removido!!" + id;
    }

    public void updateSolicitacaoById(Long id, int codigo, String maquina, String setor, String nomeSolicitante, Date dataSolicitacao, String descricao, boolean isUrgente, boolean status) {
        solicitacaoRepository.findById(id).ifPresent(solicitacao -> {
            solicitacao.setCodigo(codigo);
            solicitacao.setMaquina(maquina);
            solicitacao.setSetor(setor);
            solicitacao.setNomeSolicitante(nomeSolicitante);
            solicitacao.setDataSolicitacao(dataSolicitacao);
            solicitacao.setDescricao(descricao);
            solicitacao.setIs_urgente(isUrgente);
            solicitacao.setStatus(status);
            solicitacaoRepository.save(solicitacao);
        });
    }
}
