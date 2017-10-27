package br.com.compasso.modelo;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable{
	private Integer id;
	private Usuario usuario;
	private Produto produto;
	private Integer quantidade;
	private Integer valor;
	
	public Pedido(){
		
	}

	public Pedido(Integer id, Usuario usuario,Produto produto,
			Integer quantidade, Integer valor) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public Pedido(Usuario usuario,Produto produto,
			Integer quantidade,Integer valor) {
		super();
		this.usuario = usuario;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
