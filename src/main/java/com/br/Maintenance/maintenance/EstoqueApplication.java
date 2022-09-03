package com.br.Maintenance.maintenance;

import com.br.Maintenance.maintenance.DAO.ListaCompraDAO;
import com.br.Maintenance.maintenance.DAO.OrdemDAO;
import com.br.Maintenance.maintenance.DAO.ProdutoDAO;
import com.br.Maintenance.maintenance.DAO.SolicitacaoDAO;
import com.br.Maintenance.maintenance.model.*;
import com.br.Maintenance.maintenance.service.AtivoService;
import com.br.Maintenance.maintenance.service.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class EstoqueApplication {


	public static void main(String[] args) {


		SpringApplication.run(EstoqueApplication.class, args);

//		//Solicitacao
//		Solicitacao solicitacao = new Solicitacao();
//		SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
//		solicitacao.setId(15l);
//		solicitacao.setCodigo(5510);
//		solicitacao.setMaquina("Corte");
//		solicitacao.setSetor("SE");
//		solicitacao.setNomeSolicitante("André Bandeli");
//		solicitacao.setDataSolicitacao(new Date(21-10-1995));
//		solicitacao.setDescricao("Máquina apresentou forte ruído");
//		solicitacao.setActive(true);
//		solicitacaoDAO.criarSolicitacao(solicitacao);
//
//		//Ordem
//		OrdemDAO ordemDAO = new OrdemDAO();
//		Ordem ordem = new Ordem();
//		ordem.setId(10l);
//		ordem.setCodigo(1010l);
//		ordem.setDataAbertura(new Date(25-10-2022));
//		ordem.setDataFechamento(new Date(30-12-2022));
//		ordem.setSolicitacaoServico(solicitacao);
//		ordemDAO.criarOrdem(ordem);
//
//		//Produto
//		ProdutoDAO produtoDAO = new ProdutoDAO();
//		Produto produto = new Produto();
//		produto.setId(55l);
//		produto.setCodigo(1010l);
//		produto.setNome("Rolamento C1K710");
//		produto.setSaldo(100);
//		produto.setSaldoMin(20);
//		produtoDAO.criarProduto(produto);
//
//		//Lista Compra
//		ListaCompraDAO listaCompraDAO = new ListaCompraDAO();
//		ListaCompras listaCompras = new ListaCompras();
//		listaCompras.setId(57l);
//		listaCompras.setCodigo(5510l);
//		listaCompras.setNome("Motor Elétrico 5510l - Bosh");
//		listaCompras.setDeadline("25-10-2022");
//		listaCompraDAO.criarListaCompra(listaCompras);
//
//
//		//Ativo
//
//		Ativos ativos = new Ativos();
//		ativos.setId(10);
//		ativos.setCodigo(5510);
//		ativos.setSetor("COD 10");
//		ativos.setTipo("Elétrico");
//		ativos.setNivelPrioridade(10);


	}

}
