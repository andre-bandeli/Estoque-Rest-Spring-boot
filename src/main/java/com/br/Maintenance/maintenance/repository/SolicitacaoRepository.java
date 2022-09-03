package com.br.Maintenance.maintenance.repository;

import com.br.Maintenance.maintenance.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoRepository extends CrudRepository<Solicitacao, Long> {
}
