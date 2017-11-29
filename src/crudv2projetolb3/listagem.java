package crudv2projetolb3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucb.DAO.UsuarioDAO;
import br.ucb.entidades.Usuario;



/**
 * Servlet implementation class listagem
 */
@WebServlet("/listagem")
public class listagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listagem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		List<Usuario> list = new UsuarioDAO().listar();
		java.io.PrintWriter out = response.getWriter();
		out.print("<body>");
		out.print("<table class='table' border='1'>");
		out.print("<tr>");
		out.print("<th>Login</th>");
		out.print("<th>Email</th>");
		out.print("<th>Senha</th>");
		out.print("</tr>");
		for (Usuario usuario : list) {
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getEmail());
			System.out.println(usuario.getSenha());
		}
		for (Usuario usuario : list) {
			out.print("<tr>");
			out.print("<td>"+usuario.getLogin()+"</td>");
			out.print("<td>"+usuario.getEmail()+"</td>");
			out.print("<td>"+usuario.getSenha()+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
