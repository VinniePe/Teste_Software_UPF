package br.com.compasso.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{

	private Integer id;
	private String email;
	private String senha;
	private String cpf;
	private String nome;
	private String sobrenome;
	private String sexo;
	private String dataNascimento;
	private String telefone;
		
	public Usuario(){
		
	}
	
	public Usuario(String email, String senha, String cpf, String nome, String sobrenome, String sexo,
			String dataNascimento, String telefone) {
		super();
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}
	
	public Usuario(Integer id, String email, String senha, String cpf, String nome, String sobrenome, String sexo,
			String dataNascimento, String telefone) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}