package com.br.Maintenance.maintenance.repository;

import com.br.Maintenance.maintenance.model.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrdemRepository extends CrudRepository<Ordem, Long> {
}
