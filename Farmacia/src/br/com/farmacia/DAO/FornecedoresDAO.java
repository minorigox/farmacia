package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConexaoFactory;

public class FornecedoresDAO {
	
	public void salvar(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();
	}
	
	public void excluir (Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1,  f.getCodigo());
		comando.executeUpdate();
	}
	
	public void editar (Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2,  f.getCodigo());
		comando.executeUpdate();
	}
	
	public Fornecedores buscarPorCodigo (Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1,  f.getCodigo());
		ResultSet resultado = comando.executeQuery();
		Fornecedores retorno = null;
		if (resultado.next()) {
			retorno = new Fornecedores();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		} 
		
		return retorno;
	}
	
	public ArrayList < Fornecedores > listar () throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("ORDER BY codigo ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		ArrayList < Fornecedores > retorno = new ArrayList < Fornecedores > ();
		Fornecedores fornecedor = null;
		while (resultado.next()) {
			fornecedor = new Fornecedores();
			fornecedor.setCodigo(resultado.getLong("codigo"));
			fornecedor.setDescricao(resultado.getString("descricao"));
			retorno.add(fornecedor);
		}
		
		return retorno;
	}
	
	public List < Fornecedores > buscarPorDescricao (Fornecedores f) throws SQLException {
		List < Fornecedores > retorno = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + f.getDescricao() + "%");
		ResultSet resultado = comando.executeQuery();
		retorno = new ArrayList < Fornecedores > ();
		Fornecedores fornecedor = null;
		while (resultado.next()) {
			fornecedor = new Fornecedores();
			fornecedor.setCodigo(resultado.getLong("codigo"));
			fornecedor.setDescricao(resultado.getString("descricao"));
			retorno.add(fornecedor);
		} 
		return retorno;
	}
	
	
	
	public static void main(String[] args) {
		
//		Listar por Descricao
//		List < Fornecedores > lista = new ArrayList < Fornecedores > ();
//		FornecedoresDAO fdao = new FornecedoresDAO();
//		Fornecedores f = new Fornecedores();
//		f.setDescricao("i");
//		try {
//			lista = fdao.buscarPorDescricao(f);
//			
//			for (Fornecedores f2 : lista) {
//				System.out.println("Resultado: " + f2);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		Listar
//		ArrayList < Fornecedores > lista = new ArrayList < Fornecedores > ();
//		FornecedoresDAO fdao = new FornecedoresDAO();
//		try {
//			lista = fdao.listar();
//			
//			for (Fornecedores f : lista) {
//				System.out.println("Resultado: " + f);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		Buscar por código
//		Fornecedores f1 = new Fornecedores();
//		f1.setCodigo(1L);
//		
//		FornecedoresDAO fdao = new FornecedoresDAO();
//		try {
//			f1 = fdao.buscarPorCodigo(f1);
//			System.out.println("CÓDIGO: " + f1.getCodigo() + " - DESCRIÇÃO: " + f1.getDescricao());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		Editar
//		Fornecedores f1 = new Fornecedores();
//		f1.setCodigo(3L);
//		f1.setDescricao("JAIME EVANDRO TERCEIRO");
//		
//		FornecedoresDAO fdao = new FornecedoresDAO();
//		try {
//			fdao.editar(f1);
//			System.out.println("EDITADO COM SUCESSO!");
//		} catch (SQLException e) {
//			System.out.println("ERRO AO EDITADO!");
//			e.printStackTrace();
//		}
				
		
//		Deletar
//		Fornecedores f1 = new Fornecedores();
//		f1.setCodigo(1L);
//		
//		FornecedoresDAO fdao = new FornecedoresDAO();
//		try {
//			fdao.excluir(f1);;
//			System.out.println("DELETADO COM SUCESSO!");
//		} catch (SQLException e) {
//			System.out.println("ERRO AO DELETAR!");
//			e.printStackTrace();
//		}
		
//		Incluir
		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("Joana Prado");
		
		Fornecedores f2 = new Fornecedores();
		f2.setDescricao("GUSTAGOL");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("FORNCECEDOR INCLUÍDO COM SUCESSO!");
		} catch (SQLException e) {
			System.out.println("ERRO AO SALVAR!");
			e.printStackTrace();
		}
	}

}
