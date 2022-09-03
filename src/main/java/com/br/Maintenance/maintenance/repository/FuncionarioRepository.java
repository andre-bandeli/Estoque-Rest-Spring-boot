package com.br.Maintenance.maintenance.repository;

import com.br.Maintenance.maintenance.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long > {
}
