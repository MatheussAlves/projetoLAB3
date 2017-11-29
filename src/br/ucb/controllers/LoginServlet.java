package br.ucb.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucb.DAO.UsuarioDAO;
import br.ucb.entidades.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
	 
	      PrintWriter out=response.getWriter();  
	      HttpSession session = request.getSession();
	      Usuario usuario = null;
	      
	      
	      String login=request.getParameter("login");  
	      String senha=request.getParameter("senha");
	      try{
	    	  UsuarioDAO dao = new UsuarioDAO();
	    	  usuario = dao.logaUsuario(login, senha);
	      }catch(Exception e){
	    	  
	      }
	      if(usuario==null){
	    	  session.invalidate();
	    	  request.getRequestDispatcher("erroLogin.jsp").forward(request, response);
	      }else{
	    	  session.setAttribute("usuario", usuario);
	    	  request.getRequestDispatcher("perfil.jsp").forward(request, response);
	    	  
	      }
	    }  
	

}
