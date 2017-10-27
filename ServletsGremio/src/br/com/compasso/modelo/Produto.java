package br.com.compasso.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Produto implements Serializable {
	private Integer id;
	private String nome;
	private String marca;
	private String tamanho;
	private String cor;
	private String imagem;
	private Integer valor;



	static Produto p1;
	static Produto p2;
	static Produto p3;
	static Produto p4;
	
	static {
		 p1 = new Produto(1, "Camisa Tricolor Masc. I 2016", "Umbro", "P", "Tricolor", "camisa3.JPG", 249);
		 p2 = new Produto(2, "Camisa Penta Campeão Rei de Copas", "Independente", "M", "Preta", "camisa4.PNG", 49);
		 p3 = new Produto(3, "Camisa Umbro Grêmio Retrô","Umbro", "G", "Tricolor", "camisa1.jpg", 189);
		 p4 = new Produto(4, "Camisa Tricolor Masc. I 2017", "Umbro", "PP", "Tricolor", "camisa2.PNG", 299);
	};

	public List<Produto> getAll(){
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
		produtos.add(p4);
		return produtos;
	}
	
	public Produto find(Integer id){
		List<Produto> produtos = new ArrayList<Produto>();
		Produto p = new Produto();
		produtos = p.getAll();
		for(int i=0 ; i < produtos.size() ; i++){
			p = produtos.get(i);
			if(p.getId() == id){
				i = produtos.size()+1;
			}
		}
		return p;
	}
	public Produto(){
		
	}

	public Produto(String nome, String marca, String tamanho, String cor, String imagem, Integer valor) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.tamanho = tamanho;
		this.cor = cor;
		this.imagem = imagem;
		this.valor = valor;
	}

	public Produto(Integer id, String nome, String marca, String tamanho, String cor, String imagem, Integer valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.tamanho = tamanho;
		this.cor = cor;
		this.imagem = imagem;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	
}
