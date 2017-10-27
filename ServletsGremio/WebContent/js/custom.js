	if(window.location.hash == "#errorRegister"){
		alert("E-mail informado já possui cadastro! Informe um novo e-mail ou então faça o login na sua conta!");
	}

	if(window.location.hash == "#errorLogin"){
		alert("Combinação de usuário e senha incorreta. Tente novamente!");
	}

	$( ".btn-preto.addToCart" ).on( "click", function( event ) {
		alert("Para adicionar o item ao pedido é necessário efetuar o login. Cadastre-se caso não possua cadastro.");
		});

$( '.frm' ).submit(function( event ) {
	if($('#inputPwd').val().length <= 5){
		alert("Senha deve conter no mínimo 6 caracteres!");
	}

});


$(document).on('keypress', '.onlyLetter', function (event) {
    var regex = new RegExp("^[a-zA-Z \^~]+$");
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
    if (!regex.test(key)) {
        event.preventDefault();
        return false;
    }
});

$(document).on('keypress', '.validaNum', function (event) {
    var regex = new RegExp("^[a-zA-Z0-9]+$");
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
    if (!regex.test(key)) {
        event.preventDefault();
        return false;
    }
});

$(document).on('keypress', '.validaEnd', function (event) {
    var regex = new RegExp("^[a-zA-Z0-9 \^~,]+$");
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
    if (!regex.test(key)) {
        event.preventDefault();
        return false;
    }
});

$(document).on('keypress', '.validaCep', function (event) {
    var regex = new RegExp("^[0-9]+$");
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
    if (!regex.test(key)) {
        event.preventDefault();
        return false;
    }
});


function mascara(t, mask){
	var i = t.value.length;
	var saida = mask.substring(1,0);
	var texto = mask.substring(i)
	if (texto.substring(0,1) != saida){
		t.value += texto.substring(0,1);
	};
};

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

$(function(){
	var $frmCad = $("#frmCad"),
	$txtNomeN = $("#txtNomeN"),
	$txtEmailN = $("#txtEmailN"),
	$frmLogin = $("#frmLogin"),
	$txtNome = $("#txtNome"),
	$txtEmail = $("#txtEmail"),
	$txtSenha = $("#txtSenha"),
	$txtSenhaC = $("#txtSenhaC"),
	$txtCep = $("#txtCep"),
	$txtEnd = $("#txtEnd"),
	$txtNum = $("#txtNum"),
	$txtComp = $("#txtComp"),
	$msgErro1 = $("#msgErro1");
	$msgErro2 = $("#msgErro2");
	$msgErro3 = $("#msgErro3");
	$msgErro4 = $("#msgErro4");
	$msgErro5 = $("#msgErro5");
	$msgErro6 = $("#msgErro6");
	$msgErro7 = $("#msgErro7");
	$msgErro8 = $("#msgErro8");
	$msgErro9 = $("#msgErro9");
	$msgErro10 = $("#msgErro10");
	$msgErro11 = $("#msgErro11");
	$msgErro12 = $("#msgErro12");
	$msgErro13 = $("#msgErro13");
	$msgErro14 = $("#msgErro14");
	$msgErro15 = $("#msgErro15");
	$msgErro16 = $("#msgErro16");
	$msgErro17 = $("#msgErro17");
	$msgErro18 = $("#msgErro18");
	$msgErro19 = $("#msgErro19");

	$frmCad.submit(function(e){
		console.log('SubmitNewsletter');
		e.preventDefault();
		
		var $nomeN = $txtNomeN.val().trim();
		var $emailN = $txtEmailN.val().trim();
		
		if($nomeN === ""){
			e.preventDefault();
			$msgErro16.removeClass('hidden');
		} else if($nomeN.length < 4){
			e.preventDefault();
			$msgErro16.addClass('hidden');
			$msgErro17.removeClass('hidden');
		} else{
			$msgErro16.addClass('hidden');
			$msgErro17.addClass('hidden');
		};
		
		if($emailN === ""){
			e.preventDefault();
			$msgErro18.removeClass('hidden');
		} else if(!validateEmail($email)){
			e.preventDefault();
			$msgErro18.addClass('hidden');
			$msgErro19.removeClass('hidden');
		} else{
			$msgErro18.addClass('hidden');
			$msgErro19.addClass('hidden');
		};
		
	});
	
	$frmLogin.submit(function(e){
		console.log('Submit');
		e.preventDefault();
		
		var $nome = $txtNome.val().trim();
		var $email = $txtEmail.val().trim();
		var $senha = $txtSenha.val().trim();
		var $senhaC = $txtSenhaC.val().trim();
		var $cep = $txtCep.val().trim();
		var $end = $txtEnd.val().trim();
		var $num = $txtNum.val().trim();
		var $comp = $txtComp.val().trim();
		
		if($nome === ""){
			e.preventDefault();
			$msgErro1.removeClass('hidden');
		} else if($nome.length < 4){
			e.preventDefault();
			$msgErro1.addClass('hidden');
			$msgErro2.removeClass('hidden');
		} else{
			$msgErro1.addClass('hidden');
			$msgErro2.addClass('hidden');
		};
		
		if($email === ""){
			e.preventDefault();
			$msgErro3.removeClass('hidden');
		} else if(!validateEmail($email)){
			e.preventDefault();
			$msgErro4.addClass('hidden');
			$msgErro3.removeClass('hidden');
		} else{
			$msgErro4.addClass('hidden');
			$msgErro3.addClass('hidden');
		};
		
		if($senha === ""){
			e.preventDefault();
			$msgErro5.removeClass('hidden');
		} else if($senha.length < 6){
			e.preventDefault();
			$msgErro5.addClass('hidden');
			$msgErro6.removeClass('hidden');
		}else{
			$msgErro5.addClass('hidden');
			$msgErro6.addClass('hidden');
		};
		
		if($senhaC != $senha){
			e.preventDefault();
			$msgErro7.removeClass('hidden');
		}else{
			$msgErro7.addClass('hidden');
		};
		
		if($cep === ""){
			e.preventDefault();
			$msgErro8.removeClass('hidden');
		} else if($cep.length < 8){
			e.preventDefault();
			$msgErro8.addClass('hidden');
			$msgErro9.removeClass('hidden');
		}else{
			$msgErro8.addClass('hidden');
			$msgErro9.addClass('hidden');
		};
		
		if($end === ""){
			e.preventDefault();
			$msgErro10.removeClass('hidden');
		} else if($end.length < 4){
			e.preventDefault();
			$msgErro10.addClass('hidden');
			$msgErro11.removeClass('hidden');
		}else{
			$msgErro10.addClass('hidden');
			$msgErro11.addClass('hidden');
		};
		
		if($num === ""){
			e.preventDefault();
			$msgErro12.removeClass('hidden');
		} else if($num.length < 2){
			e.preventDefault();
			$msgErro12.addClass('hidden');
			$msgErro13.removeClass('hidden');
		}else{
			$msgErro12.addClass('hidden');
			$msgErro13.addClass('hidden');
		};
		
		if($comp === ""){
			e.preventDefault();
			$msgErro14.removeClass('hidden');
		} else if($comp.length < 4){
			e.preventDefault();
			$msgErro14.addClass('hidden');
			$msgErro15.removeClass('hidden');
		}else{
			$msgErro14.addClass('hidden');
			$msgErro15.addClass('hidden');
		};

	});
	
});