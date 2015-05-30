package br.com.ae.livraria.cliente;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ae.loja.entity.Autor;
import br.com.ae.loja.entity.Livro;
import br.com.ae.loja.session.GerenciadorLoja;

public class ClienteGerenciador4 {
	
	public static void main(String[] args) throws NamingException {
		
		InitialContext ic = new InitialContext();
		
		GerenciadorLoja gerenciadorLoja = (GerenciadorLoja) ic.lookup("fj31-loja-ear/GerenciadorLojaBean/remote");
		List<Autor> autoresPeloNomeDoLivro = gerenciadorLoja.buscaAutoresPeloNomeDoLivro("Sombr");

		for (Autor autor : autoresPeloNomeDoLivro) {
			
			System.out.println("Autor " + autor);
		}
		
		List<Autor> buscaAutorPeloNome = gerenciadorLoja.buscaAutorPeloNome("Fee");
		
		for (Autor autor : buscaAutorPeloNome) {
			
			System.out.println("Busca autor pelo nome " + autor);
		}
		
		
		List<Livro> livros = gerenciadorLoja.buscaLivroPaginacao("Sombria", 3, 5);
		for (Livro livro : livros) {
			System.out.println("Paginacao " + livro);
		}
		
		List<Livro> livross = gerenciadorLoja.buscaLivroPeloNomeEPreco("Sombrio", 109);
		for (Livro livro : livross) {
			System.out.println("Livros com preco " + livro);
		}
		
	}
}
