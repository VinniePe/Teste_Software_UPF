<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<!-- definir charset como utf-8 -->
<meta charset="UTF-8">
<!-- META viewport -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- favicom -->
<link rel="icon" href="img/logoGremio.png" sizes="16x16">

<title>Treinamento Compasso - Perfil</title>

<!-- meta tags: description, keywords, author -->
<meta name="description" content="Produtos Oficias do Grêmio">
<meta name="keywords" content="Grêmio, Produtos">
<meta name="author" content="Vinícius Pedroso">
<meta http-equiv="refresh" content="30000">
<!-- opengraph-->
<meta property="og:locale" content="pt_BR">
<meta property="og:url" content="index.html">
<meta property="og:title" content="Grêmio FBPA Produtos Oficiais">
<meta property="og:site_name" content="Grêmio FBPA">
<meta property="og:description"
	content="Todos os produtos oficiais e licenciados pelo Grêmio FBPA.">
<meta property="og:image" content="img/logoGremio.png">
<meta property="og:image:type" content="image/png">
<meta property="og:image:width" content="800">
<meta property="og:image:height" content="600">
<meta property="og:type" content="website">
<meta property="fb:admins" content="Facebook" />
<!-- Twitter -->
<meta name="twitter:card" content="summary_large_image">
<meta name="twitter:site" content="@Vinnie_Pe">
<meta name="twitter:title" content="Grêmio FBPA">
<meta name="twitter:description"
	content="Todos os produtos oficiais e licenciados pelo Grêmio FBPA.">
<meta name="twitter:creator" content="@Vinnie_Pe">
<link href="css/bootstrap.min.css" rel="stylesheet">	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<div class="div-header">
		<a name="topoPagina"></a>
		<!-- Cabeçalho -->
		<header class="container center">
			<div class="div-logomarca">
				<img alt="Logo Oficial Grêmio" width="370" height=""
					src="img/logoMenu.png" />
			</div>
			<div class="div-slogan">
				<img alt="Logo Umbro" width="220" height="" src="img/logoUmbro.png" />
			</div>
		</header>
		<!-- Fim Cabeçalho -->
	</div>

	<div class="container-menu-topo">
		<!-- Menu Horizontal -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"  style="padding: 2px;"><img src="img/logoGremio.png" width="45"></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Inicio</a></li>
                        <li><a href="produtos.jsp">Produtos</a></li>
                        <li><a href="pedidos.jsp">Meus Pedidos</a></li>
                    </ul>

                    <div id="navbar" class="navbar-collapse collapse">
						<%HttpSession status = request.getSession();
                		//if(status.getAttribute("email") == null){
                			//response.sendRedirect("index.html");
                		//}
                		out.print("<ul class='nav navbar-nav navbar-right'><li><a href='perfil.jsp'>"+status.getAttribute("email")+"</a></li>" +
                		"<li><a href='UsuarioControle?acao=sair'>Sair</a></li></ul>");%>
                    </div><!--/.navbar-collapse -->
                </div>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

		<!-- Fim Menu Horizontal -->
	</div>

	<!-- Container Principal -->
	<section class="container center">

		<!-- Conteudo principal -->
		<main class="conteudo-principal">
		<h2 class="title">Seus Dados</h2>
				<form action="UsuarioControle" method="GET" class="frm">
					<input type="hidden" id="acao" name="acao" value="update" /><br>
           			<input type="hidden" id="id" name="id" value=<%out.println(status.getAttribute("id"));%> /><br>
           			
              		<div class="form-group">
						<label for="email">E-mail:</label> <input type="email"  id="email"  name="email" 
						value=<%out.print(status.getAttribute("email"));%> maxlength="50" required>
					</div>
              	
              		<div class="form-group">
						<label for="pwd">Senha:</label> <input type="password"  id="pwd"  name="pwd" 
						value=<%out.print(status.getAttribute("senha"));%> minlength="6" maxlength="10" required>
					</div>
              	              	
					<div class="form-group">
						<label for="cpf">CPF:</label> <input type="text" name="cpf" id="cpf" minlength="2" maxlength="50" 
						value=<%out.print(status.getAttribute("cpf"));%> required>
					</div>
						
					<div class="form-group">
						<label for="name">Nome:</label> <input type="text" name="name" id="name" minlength="2" maxlength="50" 
						value=<%out.print(status.getAttribute("nome"));%> required>
					</div>
					
					<div class="form-group">
						<label for="mName">Sobrenome:</label> <input type="text" name="mName" id="mName" minlength="1" maxlength="50" 
						value=<%out.print(status.getAttribute("sobrenome"));%> required>
					</div>
					
					<div class="form-group">
						<label>Sexo:</label> 
						<input type="radio" name="gender" value="Feminino" <%if(status.getAttribute("sexo").equals("Feminino")){out.print("checked");}%>> Feminino &nbsp&nbsp
						<input type="radio" name="gender" value="Masculino" <%if(status.getAttribute("sexo").equals("Masculino")){out.print("checked");}%>> Masculino
					</div>

					<div class="form-group">
						<label for="birthday">Data de Nascimento:</label> <input type="text" name="birthday" id="birthday" placeholder="Preencha no formato: 00/00/0000" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}" maxlength="10" 
						value=<%out.print(status.getAttribute("dataNascimento"));%> required>
					</div>
					
					<div class="form-group">
						<label for="phone">Telefone:</label> <input type="text" name="phone" id="phone" maxlength="16" 
						 placeholder="Preencha no formato: (DDD)99999-9999" pattern="\([0-9]{2}\)[0-9]{4,6}-[0-9]{3,4}" 
						value=<%out.print(status.getAttribute("telefone"));%> required>
					</div>

					<div class="form-group">
						<input checked="checked" type="checkbox" name="receberCopia">
						Desejo receber uma cópia deste e-mail.
					</div>
					<div class="row">
					<div class="form-group">
						<button class="btn-preto" type="submit">Atualizar</button>
						<%out.print("<a class='btn btn-preto' href='UsuarioControle?acao=delete&id="+status.getAttribute("id")+"'>");%>Excluir Conta</a>
					</div>
					</div>
				</form>
				<br>
		</main>
	</section>
	<!-- Fim Container Principal -->


	<div class="container-footer">
		<!-- rodape -->
		<footer class="container center">
			<div class="col w-50 menu-vertical">
				<h3>
					<span class="title-footer">Mapa do Site</span>
				</h3>
				<ul class="menu-vertical footer">
					<li><a href="index.html">Inicial</a></li>
					<li><a href="quem-somos.html">Quem Somos</a></li>
					<li><a href="produtos.html">Produtos</a></li>
					<li><a href="localizacao.html">Localização</a></li>
					<li><a href="contato.html">Contato</a></li>
				</ul>
			</div>
			<div class="col w-50 txt-right">
				<img alt="Logo Oficial Grêmio" width="70" height=""
					src="img/logoGremio.png" /> <img alt="Logo Oficial Grêmio"
					width="100" height="" src="img/logoUmbro2.png" /> <img
					alt="Logo Oficial Grêmio" width="100" height=""
					src="img/logoArena.png" />
			</div>
		</footer>
		<!-- Fim rodape -->
	</div>

	<div class="txt-center ancora">
		<a href="#"> Voltar para o topo </a>
	</div>

	<div class="banner-fale-conosco">
		<a href="contato.html"><img src="img/faleConosco.png"></a>
	</div>

	<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<link href="css/estilo.css" rel="stylesheet" type="text/css">
</body>
</html>