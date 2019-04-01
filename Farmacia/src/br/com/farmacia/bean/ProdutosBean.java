package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.Util;

@ManagedBean(name = "MBProdutos")
@ViewScoped
public class ProdutosBean {
	
	private Produtos produtos;
	private ArrayList < Produtos > itens;
	private ArrayList < Produtos > itensFiltrados;
	private ArrayList < Fornecedores > comboFornecedores;
	
	/**
	 * 
	 */
	@PostConstruct
	public void prepararPesquisa() {
		ProdutosDAO pdao = new ProdutosDAO();
		try {
			itens = pdao.listar();
		} catch (SQLException e) {
			Util.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void prepararNovo() throws SQLException {
		produtos = new Produtos();
		FornecedoresDAO fdao = new FornecedoresDAO(); 
		comboFornecedores = fdao.listar(); 
	}
	
	/**
	 * @param event
	 */
	public void novo(ActionEvent event) {
		ProdutosDAO pdao = new ProdutosDAO();
		try {
			pdao.salvar(produtos);
			itens = pdao.listar();
			Util.adicionarMensagemSucesso("Salvo com sucesso!");
		} catch (SQLException e) {
			Util.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * @param event
	 */
	public void excluir() {
		ProdutosDAO pdao = new ProdutosDAO();
		try {
			pdao.excluir(produtos);
			itens = pdao.listar();
			Util.adicionarMensagemSucesso("Excluído com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void prepararEditar() throws SQLException {
		FornecedoresDAO fdao = new FornecedoresDAO(); 
		comboFornecedores = fdao.listar(); 
	}
	
	/**
	 * 
	 */
	public void editar() {
		ProdutosDAO pdao = new ProdutosDAO();
		try {
			pdao.editar(produtos);
			itens = pdao.listar();
			Util.adicionarMensagemSucesso("Editado com sucesso!");
		} catch (SQLException e) {
			Util.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}	
	
	
	
	

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Produtos> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}

	public ArrayList<Produtos> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produtos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<Fornecedores> getComboFornecedores() {
		return comboFornecedores;
	}

	public void setComboFornecedores(ArrayList<Fornecedores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}

}
