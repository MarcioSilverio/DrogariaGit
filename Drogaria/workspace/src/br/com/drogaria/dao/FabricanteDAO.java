package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {
	public void salvar(Fabricante f) throws SQLException{ //(Fabricante) é classe domain
		StringBuilder sql = new StringBuilder(); //Serve para concatenar ao invés de usar +
		sql.append("INSERT INTO fabricantes "); //fabricante nome da tabela SQL, espaço depois do fabricante para não juntar
		sql.append("(descricao) "); //Campo da tabela fabricante
		sql.append("VALUES (?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		
		comando.executeUpdate();
	}
	
	// TESTE SALVAR===================================================================================
	/*
	public static void main(String[] args) {
		Fabricante f1 = new Fabricante();
		f1.setDescricao("Embraer");
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("Randon");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try {
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("Fabricantes Salvos com sucesso!!!");
		} catch (SQLException e) {
			System.out.println("Erro ao salvar!!!");
			e.printStackTrace();
		}
		
	} ==================================================================================================*/
	
	// EXCLUIR===========================================================================================
			
	public void excluir(Fabricante f) throws SQLException{ //(Fabricante) é classe domain
		StringBuilder sql = new StringBuilder(); //Serve para concatenar ao invés de usar +
		sql.append("DELETE FROM fabricantes "); //fabricante nome da tabela SQL, espaço depois do fabricante para não juntar
		sql.append("WHERE codigo = ? "); //Campo da tabela fabricante
		
	    Connection conexao = ConexaoFactory.conectar();
	
	    PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
	
		comando.executeUpdate();
}
	
	// TESTE EXCLUIR===================================================================================
		/*
		public static void main(String[] args) {
			Fabricante f1 = new Fabricante();
			f1.setCodigo(1L);
			
			FabricanteDAO fdao = new FabricanteDAO();
			
			try {
				fdao.excluir(f1);
				
				System.out.println("Fabricante Excluído com sucesso!!!");
			} catch (SQLException e) {
				System.out.println("Erro ao Excluir!!!");
				e.printStackTrace();
			}*/	

	//EDITAR===================================================================================

     public void editar(Fabricante f) throws SQLException {
    	 StringBuilder sql = new StringBuilder();
    	 sql.append("UPDATE fabricantes ");
    	 sql.append("SET descricao = ? ");
    	 sql.append("WHERE codigo = ? ");
    	 
    	 Connection conexao = ConexaoFactory.conectar();
    	 
    	 PreparedStatement comando = conexao.prepareStatement(sql.toString());
	     comando.setString(1, f.getDescricao());
	     comando.setLong(2,  f.getCodigo());
	     
	     comando.executeUpdate();
	     
     }
    	 
	   //TESTE EDITAR===================================================================================
      /*  Fabricante f1 = new Fabricante();
        f1.setCodigo(3L);
        f1.setDescricao("Nestlé 3");
        
        FabricanteDAO fdao = new FabricanteDAO(); 
        
        fdao.editar(f1);*/
    
//BUSCAR===========================================================================================
    public Fabricante buscarPorCodigo(Fabricante f) throws SQLException{
    	StringBuilder sql = new StringBuilder();
   	    sql.append("SELECT codigo, descricao ");
   	    sql.append("FROM fabricantes ");
   	    sql.append("WHERE codigo = ? ");
   	 
   	 Connection conexao = ConexaoFactory.conectar();
   	 
   	PreparedStatement comando = conexao.prepareStatement(sql.toString());
    comando.setLong(1, f.getCodigo());
    
    ResultSet resultado = comando.executeQuery();
    
    Fabricante retorno = null;
    
    if(resultado.next()) {
    	retorno = new Fabricante();
    	retorno.setCodigo(resultado.getLong("codigo"));
    	retorno.setDescricao(resultado.getString("descricao"));
    }
    return retorno;
  } 

    //TESTE BUSCAR===============================================
    /*
    public static void main(String[] args) {
		Fabricante f1 = new Fabricante();
		f1.setCodigo(6L);
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(4L);
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try {
			Fabricante f3 = fdao.buscarPorCodigo(f1);
			Fabricante f4 = fdao.buscarPorCodigo(f2);
			
			System.out.println("Resultado 1: " + f3);
			System.out.println("Resultado 2: " + f4);
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao localizar");
			e.printStackTrace();
		}*/
    
    //LISTAR======================================================
    public ArrayList<Fabricante> listar() throws SQLException{
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT codigo, descricao ");
    	sql.append("FROM fabricantes ");
    	sql.append("ORDER BY descricao ASC ");
    	
    	Connection conexao = ConexaoFactory.conectar();
    	
    	PreparedStatement comando = conexao.prepareStatement(sql.toString());
    	
    	ResultSet resultado = comando.executeQuery();
    	
    	ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
    	
    	while(resultado.next()) {
    		Fabricante f = new Fabricante();
    		f.setCodigo(resultado.getLong("codigo"));
    		f.setDescricao(resultado.getString("descricao"));
    		
    		lista.add(f);
    	}
    	return lista;
    }
 
    //TESTE LISTAR=============================================================
    /*    public static void main(String[] args) {
		FabricanteDAO fdao = new FabricanteDAO();
		try {
			ArrayList<Fabricante> lista = fdao.listar();
			
			for(Fabricante f: lista) {
				System.out.println("Resultado: " + f);
			}
					
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar listar!!!");
			e.printStackTrace();
		} 
	}*/
    
	}


















     
