package br.ucb.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucb.DAO.MateriaDAO;
import br.ucb.entidades.Materia;
import br.ucb.enums.Tipo;

/**
 * Servlet implementation class AdicionarMateriaController
 */
@WebServlet("/AdicionarMateriaController")
public class AdicionarMateriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarMateriaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Materia materia = new Materia();
		Tipo tipo;
		materia.setAutor(request.getParameter("autor"));
		//System.out.println(request.getParameter("autor"));
		materia.setEditora(request.getParameter("editora"));
		materia.setNome(request.getParameter("nome"));
		tipo  = Enum.valueOf(Tipo.class, request.getParameter("tipo"));
		materia.setTipo(tipo);
		new MateriaDAO().salvar(materia);
		System.out.println("cadstrou materia");
		response.sendRedirect("perfil.jsp");
		doGet(request, response);
		
	}

}
