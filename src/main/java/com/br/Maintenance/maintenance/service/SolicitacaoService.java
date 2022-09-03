package com.br.Maintenance.maintenance.service;


import com.br.Maintenance.maintenance.model.Produto;
import com.br.Maintenance.maintenance.model.Solicitacao;
import com.br.Maintenance.maintenance.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    public Solicitacao salvarSolicitacao(Solicitacao solicitacao) {
        return solicitacaoRepository.save(solicitacao);
    }
    public List<Solicitacao> ListSolicitacao() {
        return (List<Solicitacao>) solicitacaoRepository.findAll();
    }
    public Solicitacao ListSolicitacaoPorId(Long id) {
        return solicitacaoRepository.findById(id).orElse(null);
    }
    public String deleteSolicitacaoById(Long id) {
        solicitacaoRepository.deleteById(id);
        return "Solicitacao removido!!" + id;
    }
}
