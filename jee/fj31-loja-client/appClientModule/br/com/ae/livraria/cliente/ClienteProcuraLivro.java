package br.com.ae.livraria.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ae.loja.entity.Livro;
import br.com.ae.loja.session.GerenciadorLoja;

public class ClienteProcuraLivro {

	public static void main(String[] args) throws NamingException {

		InitialContext ic = new InitialContext();
		GerenciadorLoja gerenciadorLoja = (GerenciadorLoja) ic.lookup("fj31-loja-ear/GerenciadorLojaBean/remote");
		
		Livro livro = gerenciadorLoja.procura("1111");

		System.out.println(livro);
	}

}
