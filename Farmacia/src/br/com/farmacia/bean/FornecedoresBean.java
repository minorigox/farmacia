package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.Util;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {
	
	private Fornecedores fornecedores;
	private ArrayList < Fornecedores > itens;
	private ArrayList < Fornecedores > itensFiltrados;
	
	/**
	 * 
	 */
	@PostConstruct
	public void prepararPesquisa() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			itens = fdao.listar();
		} catch (SQLException e) {
			Util.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void prepararNovo() {
		fornecedores = new Fornecedores();
	}
	
	/**
	 * @param event
	 */
	public void novo(ActionEvent event) {
		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			fdao.salvar(fornecedores);
			itens = fdao.listar();
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
		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			fdao.excluir(fornecedores);
			itens = fdao.listar();
			Util.adicionarMensagemSucesso("Excluído com sucesso!");
		} catch (SQLException e) {
			Util.adicionarMensagemErro("Não é possível excluir um fornecedor associado");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void editar() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			fdao.editar(fornecedores);
			itens = fdao.listar();
			Util.adicionarMensagemSucesso("Editado com sucesso!");
		} catch (SQLException e) {
			Util.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}	

	/**
	 * @return the fornecedores
	 */
	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	/**
	 * @param fornecedores the fornecedores to set
	 */
	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	/**
	 * @return the itens
	 */
	public ArrayList<Fornecedores> getItens() {
		return itens;
	}

	/**
	 * @param itens the itens to set
	 */
	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}

	/**
	 * @return the itensFiltrados
	 */
	public ArrayList<Fornecedores> getItensFiltrados() {
		return itensFiltrados;
	}

	/**
	 * @param itensFiltrados the itensFiltrados to set
	 */
	public void setItensFiltrados(ArrayList<Fornecedores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
}
