package br.com.ae.livraria.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ae.loja.entity.Livro;
import br.com.ae.loja.session.GerenciadorLoja;

public class ClienteGerenciador {

	public static void main(String[] args) throws NamingException {
		
		InitialContext ic = new InitialContext();
		
		GerenciadorLoja gerenciadorLoja = (GerenciadorLoja) ic.lookup("fj31-loja-ear/GerenciadorLojaBean/remote");
		
		Livro livro = new Livro();
		
		livro.setNome("Carpatos");
		livro.setPreco(100.0); 
		
		gerenciadorLoja.salva(livro);
		
	}
	
}
