package br.com.ae.livraria.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ae.loja.entity.Autor;
import br.com.ae.loja.entity.Livro;
import br.com.ae.loja.session.GerenciadorLoja;

public class ClienteGerenciador2 {
	
	public static void main(String[] args) throws NamingException {
		
		InitialContext ic = new InitialContext();
		
		GerenciadorLoja gerenciadorLoja = (GerenciadorLoja) ic.lookup("fj31-loja-ear/GerenciadorLojaBean/remote");
		
		Autor autor = new Autor();
		autor.setNome("Christine Feehan");
		
		Autor autorSalvo = gerenciadorLoja.salva(autor);
		System.out.println("Autor salvo esta com ID: " + autorSalvo.getId());
		
		Livro livro = new Livro();
		livro.setNome("Futuro Sombrio");
		livro.setPreco(69.0);
		
		livro.getAutores().add(autorSalvo);
		
		gerenciadorLoja.salva(livro);
		
	}

}
