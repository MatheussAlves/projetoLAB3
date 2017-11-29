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
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario user = new Usuario();
		user.setEmail(email);
		user.setLogin(login);
		user.setSenha(senha);
		
		new UsuarioDAO().salvar(user);
		
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<h3> DADOS ENVIADOS </h3>");
		out.print("<h2> email: "+email+"</h2>");
		out.print("<h2> login: "+login+"</h2>");
		out.print("<h2> senha: "+senha+"</h2>");
		out.print("<a href='index.html' > <button>Voltar</button> </a><br>");
		//out.print("<input type='button' url='index.html'> voltar </input><br>");
		out.print("</html>");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
