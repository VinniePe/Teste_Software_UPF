package br.com.compasso.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.compasso.modelo.Usuario;
import br.com.compasso.modelo.UsuarioDAO;

public class CreateUser {

	@Test
	public void testCreateUser() {
		Usuario user = new Usuario();
		user.setEmail("tes");
		user.setSenha("teste1");
		user.setCpf("012.345.789-48");
		user.setNome("João");
		user.setSobrenome("Paulo");
		user.setSexo("Masculino");
		user.setDataNascimento("01/01/2001");
		user.setTelefone("(54)3322-1100");
		
		UsuarioDAO userDao = new UsuarioDAO();
		try {
			if(userDao.validateUser(user)){
				userDao.insere(user);
				System.out.println("Usuário '" + user.getNome() + " " + user.getSobrenome() + "' adicionado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Usuario user2 = new Usuario();
		user2.setEmail("teste4zzzzzz@teste.com");
		user2.setSenha("teste2");
		user2.setCpf("234.466.654-79");
		user2.setNome("Maria");
		user2.setSobrenome("Joan");
		user2.setSexo("Feminino");
		user2.setDataNascimento("02/02/2002");
		user2.setTelefone("(54)9988-7766");
		
		try {
			if(userDao.validateUser(user)){
				userDao.insere(user2);
				System.out.println("Usuário '" + user2.getNome() + " " + user2.getSobrenome() + "' adicionado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String validaEmail = "teste1@teste.com";
		if(userDao.loginAllReadyExists(validaEmail)){
			System.out.println("Email '" + validaEmail + "' já cadastrado na base de dados.");
		}else{
			System.out.println("Email '" + validaEmail + "' não cadastrado na base de dados.");
			for (Usuario getUser : userDao.getLista()) {
				if(getUser.getEmail().equals(user2.getEmail())){
					user2.setId(getUser.getId());
					user2.setEmail("teste1@teste.com");
					userDao.altera(user2);
					System.out.println("Email do usuário '" + user2.getNome() + " " + user2.getSobrenome() +"' foi atualizado de '" + user2.getEmail()							
							+ "' para '" + getUser.getEmail() + "'.");
				}
			}
			

		}
	
		System.out.println("--------------------   Usuários   --------------------");
		for (Usuario getUser : userDao.getLista()) {
			System.out.println("-- Nome: '" + getUser.getNome() + " " + getUser.getSobrenome() + "'");
		}
		System.out.println("--------------------##############---------------------");
		//userDao.find(1);
		
		//userDao.deleta(1);
		
	}

}
