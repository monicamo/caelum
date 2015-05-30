package br.com.ae.livraria.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ae.loja.entity.Livro;
import br.com.ae.loja.session.Carrinho;

public class ClienteCarrinhoTestaPassivacao {
	
	public static void main(String[] args) throws NamingException {
		
		InitialContext ic = new InitialContext();
		Carrinho carrinho = (Carrinho) ic.lookup("fj31-loja-ear/CarrinhoBean/remote");

		Livro livro1 = new Livro();
		livro1.setNome("Fausto");
		livro1.setPreco(45);
		
		carrinho.addLivro(livro1);

		for (int i = 0; i < 550; i++) {
			
			Carrinho carrinho2 = (Carrinho) ic.lookup("fj31-loja-ear/CarrinhoBean/remote");
			carrinho2.addLivro(livro1);
		}
		
		carrinho.addLivro(livro1);
		
		carrinho.finalizaCompra();
		
	}

}
