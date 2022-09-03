package com.br.Estoque.estoque;


import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest(classes = Ordem.class)
public class OrdemTest {

        @Test
        void criarOrdemTeste() {

            Ordem ordem = new Ordem();
            ordem.setCodigo(2020L);
            ordem.setId(50L);
            ordem.setDataAbertura(new Date(29/10/1997));
            ordem.setDataFechamento(new Date(25/03/2021));

            Assertions.assertEquals(2020l, ordem.getCodigo());
            Assertions.assertEquals(50L, ordem.getId());
            Assertions.assertEquals(new Date(29/10/1997), ordem.getDataAbertura());
            Assertions.assertEquals(new Date(25/03/2021), ordem.getDataFechamento());

        }

    }
