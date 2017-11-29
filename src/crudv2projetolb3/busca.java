package crudv2projetolb3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucb.DAO.UsuarioDAO;
import br.ucb.entidades.Usuario;

/**
 * Servlet implementation class busca
 */
@WebServlet("/busca")
public class busca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public busca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		String parametro = request.getParameter("login");
		Usuario user = new UsuarioDAO().buscar(parametro);
		PrintWriter out = response.getWriter();
		out.print("<h3>RESULTADOS</h3>");
		out.print("<h2>"+user.getEmail()+"</h2>");
		out.print("<h2>"+user.getLogin()+"</h2>");
		out.print("<h2>"+user.getSenha()+"</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
