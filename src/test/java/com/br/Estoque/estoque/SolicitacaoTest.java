package com.br.Estoque.estoque;


import com.br.Maintenance.maintenance.model.Solicitacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = Solicitacao.class)
public class SolicitacaoTest {

    @Test
    void criarSolicitacaoTest() {

        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setId(55l);
        solicitacao.setCodigo(55);
        solicitacao.setMaquina("Corte");
        solicitacao.setSetor("Tecelaria");
        solicitacao.setNomeSolicitante("José");

        Assertions.assertEquals(55, solicitacao.getId());
        Assertions.assertEquals(55, solicitacao.getCodigo());
        Assertions.assertEquals("Corte", solicitacao.getMaquina());
        Assertions.assertEquals("Tecelaria", solicitacao.getSetor());
        Assertions.assertEquals("José", solicitacao.getNomeSolicitante());
        Assertions.assertTrue(true, String.valueOf(true));

    }

}
