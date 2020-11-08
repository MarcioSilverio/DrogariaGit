package br.com.drogaria.domain;

public class Fabricante {
	public Long codigo;
	public String descricao;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	//Para imprimir na tela o teste buscarCodigo de forma correta
	@Override
	public String toString() {
		String saida = codigo + " - " + descricao;
		return saida;
	}
	
	
	
	

}
