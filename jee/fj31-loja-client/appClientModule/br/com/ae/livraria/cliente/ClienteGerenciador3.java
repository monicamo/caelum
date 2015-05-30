package br.com.ae.livraria.cliente;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ae.loja.entity.Autor;
import br.com.ae.loja.entity.Livro;
import br.com.ae.loja.session.GerenciadorLoja;

public class ClienteGerenciador3 {
	
	public static void main(String[] args) throws NamingException {
		
		InitialContext ic = new InitialContext();
		
		GerenciadorLoja gerenciadorLoja = (GerenciadorLoja) ic.lookup("fj31-loja-ear/GerenciadorLojaBean/remote");
		
		Livro livro = gerenciadorLoja.procura(2L);
		
		List<Autor> autores = livro.getAutores();
		
		for (Autor autor : autores) {
			System.out.println("Autor " + autor.getNome());
		}
		
		System.out.println("---------------------------");
		
		List<Autor> autoresDoLivro = gerenciadorLoja.getAutoresDoLivro(livro);
		
		
		for (Autor autor : autoresDoLivro) {
			System.out.println("Autor 2 : " + autor.getNome());
		}
		
		
		List<Livro> l2 = gerenciadorLoja.buscaTodosOsLivros();
		for (Livro livro2 : l2) {
			System.out.println("TODOS: " + livro2);
		}
		List<Livro> busca = gerenciadorLoja.buscaLivrosPeloNomeDoAutor("Feehan");
		
		for (Livro livro2 : busca) {
			
			System.out.println(" busca livros pelo nome do autor " + livro2);
		}
		
 		
	}	
}
