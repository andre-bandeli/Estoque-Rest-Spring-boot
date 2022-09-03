package com.br.Estoque.estoque;


import com.br.Maintenance.maintenance.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Produto.class)
public class ProdutoTeste {

    @Test
    void criarProdutoTeste() {

       Produto produto = new Produto();
       produto.setCodigo(2020L);
       produto.setSaldo(50);
       produto.setNome("Teste");
       produto.setId(1L);

       Assertions.assertEquals(2020l, produto.getCodigo());
       Assertions.assertEquals(50, produto.getSaldo());
       Assertions.assertEquals("Teste", produto.getNome());
       Assertions.assertEquals(1L, produto.getId());

    }

}
