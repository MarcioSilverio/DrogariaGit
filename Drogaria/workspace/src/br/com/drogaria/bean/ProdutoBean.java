package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private ArrayList<Produto> itens;
	private ArrayList<Produto>itensFiltrados; 
	
	private Produto produto;
	

	public ArrayList<Produto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}

	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public void carregarListagem() {
		try {
		ProdutoDAO dao = new ProdutoDAO();
		itens = dao.listar();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
