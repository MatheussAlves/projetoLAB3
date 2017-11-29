<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:ui="http://xmlns.jcp.org/jsf/facelets">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="resources/estilo.css">
<title>Cadastro de usuarios</title>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" style="min-height: 60px">
  <div class="container-fluid">
    <div class="navbar-header">
    <a class="header-link navbar-brand " href="index.jsp">
                        <img alt="Brand" src="resources/images/LOGO.png"
                             style="margin-top: -8px"
                              width="50" height="50" />
      </a>
    </div>
    <button class="btn btn-info navbar-btn">Buscar especifica</button>
  </div>
</nav>
<center>
 <div class="container" style="margin-top: 60px">
	<h1>Cadastro de Usu�rio</h1>
  <form class="form-horizontal" action="AdicionarUsuarioController" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="login">Login:</label>
      <div class="col-sm-8">
        <input required="true" type="login" class="form-control" id="login" placeholder="Informe o login" name="login">
      </div>
    </div>
    <div class="form-group">
    	<label class="control-label col-sm-2" for="email">Email:</label>
    	<div class="col-sm-8">
    		<input required="true" type="email" class="form-control" id="email" placeholder="Informe o email" name="email">
    	</div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="senha">Senha:</label>
      <div class="col-sm-8">          
        <input required="true" type="password" class="form-control" id="senha" placeholder="Informe a senha" name="senha">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-8 align:center">
        <button type="submit" class="btn btn-default">Cadastrar</button>
        

      </div>
    </div>
  </form>
</div>
<div id="rodape">
	Copyright2017.
	Todos os direitos reservados a -- Matheus Alves --.
</div>
</center>

</body>
</html>