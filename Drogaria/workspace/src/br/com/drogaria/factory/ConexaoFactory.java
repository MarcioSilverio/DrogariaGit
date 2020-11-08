package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "brulau";
	private static final String URL = "jdbc:mysql://localhost:3306/vendas";
	
	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Não é obtigatório, somente quando der erro de conexão, versão 6 para baixo
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	/* TESTE DE CONEXÂO=======================================================
	public static void main(String[] args) {
		try {
			Connection conexao = ConexaoFactory.conectar();
		System.out.println("Conexão realizada com sucesso!!!");
		
		} catch (SQLException e) {
			System.out.println("Conexão Falhou!!!");
			e.printStackTrace();
		} ====================================================================*/
	}


