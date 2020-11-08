package br.com.drogaria.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar() throws SQLException{
		Produto p = new Produto();
		p.setDescricao("Colirio com 70ml");
		p.setValor(2.40);
		p.setQuantidade(13D);
		Fabricante f = new Fabricante();
		f.setCodigo(9L);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p);
	}

//LISTAR-----------------------------------------------------
	@Test
	@Ignore
	public void listar() throws SQLException {
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> lista = dao.listar();
	}
//EXCLUIR-----------------------------------------------------	
	@Test
	@Ignore
	public void excluir() throws SQLException {
		Produto p = new Produto();
		p.setCodigo(1L);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(p);
	}
//EDITAR------------------------------------------------------
	@Test
	public void editar() throws SQLException {
		Produto p = new Produto();
		
		p.setCodigo(5L);
		p.setDescricao("Imosec");
		p.setValor(13.00D);
		p.setQuantidade(10D);
		
		Fabricante f = new Fabricante();
		f.setCodigo(4L);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.editar(p);
	}
}
