package br.com.farmacia.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;

public class ProdutoDAOTest {
	
	@Ignore
	public void testarSalvar() throws SQLException {
		Produtos p1 = new Produtos();
		p1.setDescricao("Remedio Y");
		p1.setPreco(2.00);
		p1.setQuantidade(20);
		
		Fornecedores f = new Fornecedores();
		f.setCodigo(22L);
		p1.setFornecedores(f);
		
		ProdutosDAO pdao = new ProdutosDAO();
		pdao.salvar(p1);
	}
	
	@Ignore
	public void testarListar() throws SQLException {
		ProdutosDAO pdao = new ProdutosDAO();
		ArrayList < Produtos > lista = pdao.listar();
		
		for (Produtos p : lista) {
			System.out.println("Código do Produto: " + p.getCodigo());
			System.out.println("Descrição do Produto: " + p.getDescricao());
			System.out.println("Preço do Produto: " + p.getPreco());
			System.out.println("Quantidade do Produto: " + p.getQuantidade());
			System.out.println("Código do Fornecedor: " + p.getFornecedores().getCodigo());
			System.out.println("Descrição do Fornecedor: " + p.getFornecedores().getDescricao());
		}
	}
	
	@Ignore
	public void excluir() throws SQLException {
		Produtos p = new Produtos();
		p.setCodigo(14L);
		ProdutosDAO pdao = new ProdutosDAO();
		pdao.excluir(p);
	}
	
	@Ignore
	public void editar() throws SQLException {
		Produtos p = new Produtos();
		p.setCodigo(8L);
		p.setDescricao("Fisiogel");
		p.setPreco(20.99);
		p.setQuantidade(1);
		p.setFornecedores(new Fornecedores());
		p.getFornecedores().setCodigo(32L);
		ProdutosDAO pdao = new ProdutosDAO();
		pdao.editar(p);
	}

}
