package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricante; // fabricante variável criada para a conexão salvar fabricante
	private ArrayList<Fabricante> itens; // <Fabricante> é o nome da classe Fabricante que está no pacote domain
	private ArrayList<Fabricante> itensFiltrados;
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ArrayList<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fabricante> itens) {
		this.itens = itens;
	}

	public ArrayList<Fabricante> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fabricante> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct // Atualiza a tela sem precisar clicar em um botão
	public void prepararPsquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			itens = dao.listar();
			} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void prepararNovo() {
		fabricante = new Fabricante();
	}

	public void novo() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);

			itens = dao.listar();
			} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void excluir() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.excluir(fabricante);

			itens = dao.listar();
			// JSFUtil.adicionarMensagemSucesso("Fabricante removido com sucesso");
		} catch (SQLException ex) {
			ex.printStackTrace();
			// JSFUtil.adicionarMensagemErro(ex.getMessage());

		}
	}

	public void editar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fabricante);

			itens = dao.listar();
			// JSFUtil.adicionarMensagemSucesso("Fabricante removido com sucesso");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}