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

<title>Treinamento Compasso</title>

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
                        <li class="active"><a href="index.jsp">Inicio</a></li>
                        <li><a href="produtos.jsp">Produtos</a></li>
                        <li><a href="pedidos.jsp">Meus Pedidos</a></li>
                    </ul>

                    <div id="navbar" class="navbar-collapse collapse">
						<%HttpSession status = request.getSession();
                		if(status.getAttribute("email") == null){
                			response.sendRedirect("index.html");
                		}
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
		<h2 class="title">Bem Vindo</h2>
		<p class="txt-justify">
			<img src="img/normal/titulo.jpg" width="300"
				style="float: left; margin: 0px 15px 10px 10px;"
				alt="Camisa Oficial Grêmio Umbro I Comemorativa"> Lorem ipsum
			dolor sit amet, consectetur adipiscing elit. Donec tellus arcu,
			gravida in ante sed, lacinia facilisis urna. Aenean est lacus,
			commodo in tellus eget, tempor tempor turpis. Vestibulum sit amet
			erat nec erat ultrices dignissim. Quisque nec arcu ut lectus
			tristique euismod sit amet iaculis nunc. Pellentesque congue sem eu
			nibh sollicitudin, non molestie massa mollis. Nullam bibendum mattis
			magna eget fringilla. Cras fermentum eget enim at molestie. Mauris
			tincidunt eleifend mollis. Aenean et interdum dui. Integer lobortis
			nibh sit amet mattis aliquam. Vestibulum at nunc dapibus, ornare nisi
			quis, blandit ligula.
		</p>

		<h2 class="title">Produtos</h2>

		<!-- Container produto -->
		<div class="container-produtos">
			<!-- linha com 3 produtos -->
			<div class="linha-produtos">

				<!-- box produto -->
				<div class="box-produto">
					<div class="img-produto">
						<img src="img/camisa3.JPG" width="207" height="283"
							alt="Camisa Oficial Grêmio Umbro I 2016">
					</div>
					<div class="title-produto">Camisa Tricolor Masc. I 2016</div>
					<div class="price-produto">
						<span>R$</span> 249,90
					</div>
					<div class="btn-detalhes txt-center">
						<a href="adicionaPedido.jsp?prod=1" class="btn-preto"> Pedir </a>
					</div>
				</div>
				<!-- Fim box produto -->

				<!-- box produto -->
				<div class="box-produto">
					<div class="img-produto">
						<img src="img/camisa4.PNG" width="207" height="283"
							alt="Camisa Oficial Grêmio Rei de Copas">
					</div>
					<div class="title-produto">Camisa Penta Campeão Rei de Copas
						Preta</div>
					<div class="price-produto">
						<span>R$</span> 49,90
					</div>
					<div class="btn-detalhes txt-center">
						<a href="adicionaPedido.jsp?prod=2" class="btn-preto"> Pedir </a>
					</div>
				</div>
				<!-- Fim box produto -->

				<!-- box produto -->
				<div class="box-produto">
					<div class="img-produto">
						<img src="img/camisa1.jpg" width="207" height="283"
							alt="Camisa Oficial Grêmio">
					</div>
					<div class="title-produto">Camisa Umbro Grêmio Retrô</div>
					<div class="price-produto">
						<span>R$</span> 189,90
					</div>
					<div class="btn-detalhes txt-center">
						<a href="adicionaPedido.jsp?prod=3" class="btn-preto"> Pedir </a>
					</div>
				</div>
				<!-- Fim box produto -->

				<!-- box produto -->
				<div class="box-produto">
					<div class="img-produto">
						<img src="img/camisa2.PNG" width="207" height="283"
							alt="Camisa Oficial Grêmio Umbro I 2017">
					</div>
					<div class="title-produto">Camisa Tricolor Masc. I 2017</div>
					<div class="price-produto">
						<span>R$</span> 299,90
					</div>
					<div class="btn-detalhes txt-center">
						<a href="adicionaPedido.jsp?prod=4" class="btn-preto"> Pedir </a>
					</div>
				</div>
				<!-- Fim box produto -->

			</div>
			<!-- Fim linha com 3 produtos -->

		</div>
		 </main>
		<!-- Fim Conteudo principal -->

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
					<li><a href="index.jsp">Inicio</a></li>
					<li><a href="produtos.jsp">Produtos</a></li>
					<li><a href="pedidos.jsp">Meus Pedidos</a></li>
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
		<a href="#"><img src="img/faleConosco.png"></a>
	</div>


	<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<link href="css/estilo.css" rel="stylesheet" type="text/css">
</body>
</html>