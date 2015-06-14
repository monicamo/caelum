package br.com.ae.livraria.cliente;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ae.loja.session.GerenciadorLoja;

public class ClienteGerenciadorLojaJass {
	
	public static void main(String[] args) throws NamingException {
		
		Properties env = new Properties();
		
		env.setProperty(Context.SECURITY_PRINCIPAL, "joao");
		env.setProperty(Context.SECURITY_CREDENTIALS, "pass");
		env.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.security.jndi.JndiLoginInitialContextFactory");
		
		InitialContext ic =  new InitialContext(env);

		GerenciadorLoja gerenciador = (GerenciadorLoja) ic.lookup("fj31-loja-ear/GerenciadorLojaBean/remote");
		
		System.out.println(gerenciador.listaLivros());
	}
}
