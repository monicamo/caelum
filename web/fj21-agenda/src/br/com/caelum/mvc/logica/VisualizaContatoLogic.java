package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class VisualizaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		long id = ( req.getParameter("id") != null ) ? Long.parseLong(req.getParameter("id") ) : 0 ;
		Connection connection = (Connection) req.getAttribute("conexao");
		
		if ( id > 0) {
			
			ContatoDao dao =  new ContatoDao(connection);
			
			Contato contato = dao.pesquisar(id);
			
			req.setAttribute("contato", contato);
		}
		
		return "/WEB-INF/jsp/adiciona-contato-mvc.jsp";
	}

}
