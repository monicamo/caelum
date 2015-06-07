package br.com.ae.servlet;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ae.loja.entity.Livro;
import br.com.ae.loja.session.GerenciadorLoja;

/**
 * Servlet implementation class ListaLivros
 */
@WebServlet("/ListaLivros")
public class ListaLivros extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GerenciadorLoja gerenciador;
		
		try 
		{
			gerenciador = (GerenciadorLoja) new InitialContext().lookup("fj31-loja-ear/GerenciadorLojaBean/remote");
			List<Livro> livros = gerenciador.listaLivros();
			request.setAttribute("livros", livros);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
			dispatcher.forward(request, response);
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaLivros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
