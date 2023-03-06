package com.br.Maintenance.maintenance.repository;

import com.br.Maintenance.maintenance.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitacaoRepository extends CrudRepository<Solicitacao, Long> {

    @Query("SELECT s FROM Solicitacao s WHERE s.status = 'aberto'")
    List<Solicitacao> findSolicitacoesAbertas();
}
