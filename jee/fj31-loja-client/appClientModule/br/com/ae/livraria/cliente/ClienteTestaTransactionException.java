package br.com.ae.livraria.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ae.loja.entity.Livro;
import br.com.ae.loja.session.GerenciadorLoja;

public class ClienteTestaTransactionException {

	public static void main(String[] args) throws NamingException {
		
		InitialContext ic = new InitialContext();
		
		GerenciadorLoja gerenciadorLoja = (GerenciadorLoja) ic.lookup("fj31-loja-ear/GerenciadorLojaBean/remote");

		Livro livro = new Livro();
		
		gerenciadorLoja.salva(livro);
		
	}
	
}
