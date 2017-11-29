<%@page import="br.ucb.entidades.Materia"%>
<%@page import="br.ucb.DAO.MateriaDAO"%>
<%@page import="br.ucb.entidades.Citacao"%>
<%@page import="java.util.List"%>
<%@page import="br.ucb.DAO.CitacaoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="resources/estilo.css">
<title>Perfil</title>
</head>
<body>
	<c:choose>
	<c:when test="${usuario eq null }">
		<jsp:forward page="index.html"></jsp:forward>
	</c:when>
	<c:otherwise>
	<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Pagina inicial</a>
    </div>
    <button class="btn btn-info navbar-btn" data-toggle="modal" data-target="#exampleModal">Adicionar livro / artigo</button>
    <button class="btn btn-info navbar-btn" data-toggle="modal" data-target="#modalDeCitacao">Adicionar citação</button>
    <ul class="nav navbar-nav navbar-right">
      <li><p><span class="navbar-brand">Logado como: ${usuario.login }</span></p></li>
      <li><a href="LogoutServlet"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Adicionar um livro ou artigo</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <form class="form-horizontal" role="form" action="AdicionarMateriaController" method="post">
                  <div class="form-group">
                    <label  class="col-sm-2 control-label"
                              for="autor">Autor</label>
                    <div class="col-sm-10">
                        <input required="true" type="autor" class="form-control" 
                        id="autor" placeholder="Informe o autor" name="autor"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label"
                          for="editora" >Editora</label>
                    <div class="col-sm-10">
                        <input required="true" type="Editora" class="form-control"
                            id="inputPassword3" placeholder="Editora" name="editora"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label"
                          for="nome" >Nome do livro/artigo</label>
                    <div class="col-sm-10">
                        <input required="true" type="Nome" class="form-control"
                            id="inputNome" placeholder="Nome do livro" name="nome"/>
                    </div>
                  </div>
                   <div class="form-group">
                    <label class="col-sm-2 control-label"
                          for="tipo" >Tipo</label>
                    <div class="col-sm-10">
                        <select required="true"  name="tipo" itemLabel="Selecione o tipo">
                  			<c:forEach items="${tipos}" var="tipo">
                  				<option value="${tipo}">${tipo.tipoLivro}</option>
                  			</c:forEach>
                  		</select>
                    </div>
                  </div>
                  <div class="modal-footer">
       				 <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        			 <button type="submit" class="btn btn-primary" >Cadastrar</button>
      			</div>
            </form>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="modalDeCitacao" tabindex="-1" role="dialog" aria-labelledby="modalDeCitacao" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modalDeCitacao">Adicionar uma citacao</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <form class="form-horizontal" role="form" action="AdicionarCitacaoController" method="post">
          		    <div class="form-group">
                    <label class="col-sm-2 control-label"
                          for="tipo" >Livro/Artigo</label>
                    <div class="col-sm-10">
                        <select name="id_materia" itemLabel="Selecione a materia">
                        <%MateriaDAO Mdao = new MateriaDAO(); 
 						List<Materia> materias = Mdao.listar();
 						for(Materia materia : materias){
 						%>
                  			
                  				<option value="<%=materia.getId() %>"><%=materia.getNome()%> - <%=materia.getAutor()%> / <%=materia.getTipo()%></option>
                  			
                  		<%} %>
                  		</select>
                    </div>
                  </div>
                  <input type="hidden" name="id_usuario" value="${usuario.id }"/>
                  <div class="form-group">
                    <label  class="col-sm-2 control-label"
                              for="autor">Texto que deseja citar</label>
                    <div class="col-sm-10">
                        <textarea required="true"  type="text" class="form-control" cols="40" rows="5"
                        id="texto" placeholder="Informe aqui o texto que deseja citar" name="texto"></textarea>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label"
                          for="editora" >Pagina do texto</label>
                    <div class="col-sm-10">
                        <input required="true" type="number" class="form-control"
                            id="pagina" placeholder="Pagina" name="pagina"/>
                    </div>
                  </div>
                  <div class="modal-footer">
       				 <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        			 <button type="submit" class="btn btn-primary" >Cadastrar</button>
      			</div>
            </form>
      </div>
    </div>
  </div>
</div>
<center>
 <div class="container" style="margin-top: 75px">
 	<div class="row">
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
 </div>
 </center>
 <div id="rodape">
	Copyright2017.
	Todos os direitos reservados a -- Matheus Alves --.
</div>
    </c:otherwise>	
	</c:choose>
</body>
</html>