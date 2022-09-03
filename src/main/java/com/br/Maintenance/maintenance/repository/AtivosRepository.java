package com.br.Maintenance.maintenance.repository;

import com.br.Maintenance.maintenance.model.Ativos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AtivosRepository extends CrudRepository<Ativos, Long> {
}
