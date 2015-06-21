package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Long id = Long.parseLong(req.getParameter("id") );
		req.setAttribute("id", id);
			
		System.out.println("Alterando contato...");
		
		return "mvc?logica=VisualizaContatoLogic";
	}

}
