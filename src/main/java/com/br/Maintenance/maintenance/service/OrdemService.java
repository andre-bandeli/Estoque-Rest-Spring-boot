package com.br.Maintenance.maintenance.service;

import com.br.Maintenance.maintenance.model.ListaCompras;
import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.repository.OrdemRepository;
import com.br.Maintenance.maintenance.model.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemService {

    @Autowired
    private OrdemRepository ordemRepository;

   // CRUD - CREATE READ UPDATE DELETE

    public Ordem addOrdem(Ordem ordem) {
        return ordemRepository.save(ordem);
    }

    public List<Ordem> getListaOrdem() {
        return (List<Ordem>) ordemRepository.findAll();
    }

    public Optional<Ordem> getOrdem(Long id) {
        return ordemRepository.findById(id);
    }

    public void updateOrdemById(Long id, int codigo, String maquina, String setor, String nomeSolicitante, Date dataSolicitacao, String descricao, boolean isUrgente, boolean status, Date dataFechamento, String tecnicoResponsavel, String observacoes ) {
        ordemRepository.findById(id).ifPresent(ordem -> {
            ordem.setCodigo(codigo);
            ordem.setMaquina(maquina);
            ordem.setSetor(setor);
            ordem.setNomeSolicitante(nomeSolicitante);
            ordem.setDataSolicitacao(dataSolicitacao);
            ordem.setDescricao(descricao);
            ordem.setIs_urgente(isUrgente);
            ordem.setStatus(status);
            ordem.setDataFechamento(dataFechamento);
            ordem.setTecnicoResponsavel(tecnicoResponsavel);
            ordem.setObservacoes(observacoes);
            ordemRepository.save(ordem);
        });
    }

    public void deleteOrdemById(Long id) {
        deleteOrdemById(id);
    }
}
