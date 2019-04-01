package br.com.farmacia.domain;

public class Produtos {
	
	private Long codigo;
	private String descricao;
	private Integer quantidade;
	private Double preco;
	private Fornecedores fornecedores = new Fornecedores();
	
	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	/**
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
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
	

}
