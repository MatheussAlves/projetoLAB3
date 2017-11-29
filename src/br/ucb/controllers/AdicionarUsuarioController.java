package br.ucb.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucb.DAO.UsuarioDAO;
import br.ucb.entidades.Usuario;

/**
 * Servlet implementation class AdicionarUsuarioController
 */
@WebServlet("/AdicionarUsuarioController")
public class AdicionarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarUsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		String login = request.getParameter("login");
		String email = request.getParameter("email");
		usuario.setLogin(request.getParameter("login"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		if(dao.verificaUsuario(login, email)==true){
			request.setAttribute("mensagemDeErro","Usuario já existe");
			request.getRequestDispatcher("erroCadastro.jsp").forward(request, response);;
		}else{
			dao.salvar(usuario);
		}
		//new UsuarioDAO().salvar(usuario);
		response.sendRedirect("loginUsuario.jsp");
		//System.out.println("entrou");
		doGet(request, response);
	}

}
