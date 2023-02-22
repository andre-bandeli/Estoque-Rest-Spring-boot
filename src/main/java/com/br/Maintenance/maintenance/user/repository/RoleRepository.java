package com.br.Maintenance.maintenance.user.repository;

import com.br.Maintenance.maintenance.model.user.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Roles, Long> {
    Roles findByRole(String role);
}