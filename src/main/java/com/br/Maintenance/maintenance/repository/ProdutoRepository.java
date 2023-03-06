package com.br.Maintenance.maintenance.repository;

import com.br.Maintenance.maintenance.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository  extends CrudRepository<Produto, Long> {
}
