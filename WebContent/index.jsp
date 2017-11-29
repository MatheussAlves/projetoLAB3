<%@page import="br.ucb.entidades.Citacao"%>
<%@page import="java.util.List"%>
<%@page import="br.ucb.DAO.CitacaoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Bootstrap core CSS -->
    
    <!-- Custom fonts for this template -->
    <link href="startbootstrap-freelancer-gh-pages/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="startbootstrap-freelancer-gh-pages/vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link type="text/css" rel="stylesheet" href="resources/estilo.css">
<link href="startbootstrap-freelancer-gh-pages/css/freelancer.min.css" rel="stylesheet">
<title>Insert title here</title>
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
    <ul class="nav navbar-nav navbar-right">
    	<a class="nav navbar-nav " href="perfil.jsp" style="padding-right: 3px">
                        <button type="button" class="btn btn-info navbar-btn">Perfil</button>
        </a>
       <a class="nav navbar-nav " href="loginUsuario.jsp" style="padding-right: 3px">
                        <button type="button" class="btn btn-info navbar-btn">Login</button>
        </a>
         <a class="nav navbar-nav " href="cadastroUsuario.jsp" style="padding-right: 27px">
                        <button type="button" class="btn btn-danger navbar-btn">Cadastro</button>
        </a>
    </ul>
  </div>
</nav>
 <div class="container" style="margin-top: 75px">
 	<%int id = 1;%>
 	<%CitacaoDAO dao = new CitacaoDAO(); 
 	List<Citacao> citacoes = dao.listar();
 	for(Citacao citacao : citacoes){
 	%>
 	<div class="row">
 	
 		<div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="#portifolio-modal-1">Nome do autor</a>
                  </h4>
                  <h4>Nome: nome do livro aqui</h4>
                  <h5>Pagina: <%=citacao.getPagina()%></h5>
                  <p class="card-text"><%=citacao.getTexto() %></p>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>
        
 	</div>
 	<%} %>
 </div>
     <div class="modal fade" id="portfolio-modal-1">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="img/portfolio/cabin.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>
<div id="rodape">
	Copyright2017.
	Todos os direitos reservados a -- Matheus Alves --.
</div>
</body>
</html>