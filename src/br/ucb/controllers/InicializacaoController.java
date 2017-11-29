package br.ucb.controllers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.ucb.DAO.CitacaoDAO;
import br.ucb.DAO.MateriaDAO;
import br.ucb.enums.Tipo;
@WebListener
public class InicializacaoController implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		/*event.getServletContext().setAttribute("tipos", Tipo.values());
		System.out.println("entraste");*/
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
	
		event.getServletContext().setAttribute("tipos", Tipo.values());
		event.getServletContext().setAttribute("materiasCadastradas",new MateriaDAO().listar());
		//System.out.println("entraste");
		
	}

}
