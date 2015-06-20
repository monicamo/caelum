package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minhaServlet")
public class MinhaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		
		log("Iniciando a servlet");
		
	}
	
	@Override
	public void destroy() {

		super.destroy();

		log("Finalizando a servlet");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// recebe o writer
		PrintWriter out = response.getWriter();
		
		// escreve o texto
		out.println("<html>");
		out.println("<body>");
		out.println("MINHA SERVLET");
		out.println("</body>");
		out.println("</html>");
		
	
	}
	
}
