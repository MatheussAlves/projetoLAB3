package br.ucb.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucb.DAO.CitacaoDAO;
import br.ucb.entidades.Citacao;

/**
 * Servlet implementation class AdicionarCitacaoController
 */
@WebServlet("/AdicionarCitacaoController")
public class AdicionarCitacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarCitacaoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Citacao citacao = new Citacao();
		citacao.setTexto(request.getParameter("texto"));
		citacao.setPagina(Integer.parseInt(request.getParameter("pagina")));
		citacao.setId_materia(Integer.parseInt(request.getParameter("id_materia")));
		citacao.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
		response.sendRedirect("perfil.jsp");
		new CitacaoDAO().salvar(citacao);
		doGet(request, response);
	}

}
