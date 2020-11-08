package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.factory.ConexaoFactory;

//MÉTODO SALVAR PRODUTOS-------------------------------------
public class ProdutoDAO {
	public void salvar(Produto p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtos ");
		sql.append("(descricao, valor, quantidade, fabricantes_codigo) ");
		sql.append("VALUES (?, ?, ?, ?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, p.getDescricao());
		comando.setDouble(2, p.getValor());
		comando.setDouble(3,p.getQuantidade());
		comando.setLong(4, p.getFabricante().getCodigo());
		
		comando.executeUpdate();
	}
//LISTAR--------------------------------------------------------------------------------	 
	public ArrayList<Produto> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.codigo, p.descricao, p.valor, p.quantidade, f.codigo, f.descricao ");
		sql.append("FROM produtos p ");
		sql.append("INNER JOIN fabricantes f ON f.codigo = p.fabricantes_codigo ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Produto> itens = new ArrayList<Produto>();
		
		while(resultado.next()) {
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("f.codigo"));
			f.setDescricao(resultado.getString("f.descricao"));
			
			Produto p = new Produto();
			p.setCodigo(resultado.getLong("p.codigo"));
			p.setDescricao(resultado.getString("p.descricao"));
			p.setValor(resultado.getDouble("p.valor"));
			p.setQuantidade(resultado.getDouble("p.quantidade"));
			p.setFabricante(f);
			
			itens.add(p);
		}
		return itens;
	}
//DELETAR------------------------------------------------------------------------------
	public void excluir(Produto p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM produtos ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1,  p.getCodigo());
		
		comando.executeUpdate();
	}
//EDITAR
	public void editar(Produto p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produtos ");
		sql.append("SET descricao = ?, valor = ?, quantidade = ?, fabricantes_codigo = ? ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, p.getDescricao());
		comando.setDouble(2, p.getValor());
		comando.setDouble(3, p.getQuantidade());
		comando.setLong(4, p.getFabricante().getCodigo());
		comando.setLong(5, p.getCodigo());
		
		comando.executeUpdate();
		
	}

}
