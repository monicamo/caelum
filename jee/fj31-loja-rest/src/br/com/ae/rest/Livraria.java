package br.com.ae.rest;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.ae.loja.entity.Livro;
import br.com.ae.loja.session.GerenciadorLoja;

@Path("/")
public class Livraria {

	private GerenciadorLoja criarGerenciador() {
		try {
			Properties env = new Properties();
			env.setProperty(Context.SECURITY_PRINCIPAL, "joao");
			env.setProperty(Context.SECURITY_CREDENTIALS, "pass");
			env.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.security.jndi.JndiLoginInitialContextFactory");
			
			GerenciadorLoja gerenciador = (GerenciadorLoja) new InitialContext(env).lookup("fj31-loja-ear/GerenciadorLojaBean/remote");
			
			return gerenciador;
			
		} catch (NamingException e) {
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
	}
	
	@GET
	@Path("livro/{id}")
	@Produces({"application/xml","application/json"})
	public Livro getLivro(@PathParam("id") Long id) 
	{
		GerenciadorLoja gerenciadorLoja = criarGerenciador();
		Livro livro = gerenciadorLoja.procura(id);
		if(livro == null) 
		{
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return livro;
	}
	
	
	@GET
	@Path("/livros")
	@Produces("application/xml")
	public List<Livro> getLivrosXml() 
	{
		GerenciadorLoja gerenciadorLoja = criarGerenciador();
		List<Livro> livros = gerenciadorLoja.listaLivros();
		
		return livros;
	}
	
	
}
