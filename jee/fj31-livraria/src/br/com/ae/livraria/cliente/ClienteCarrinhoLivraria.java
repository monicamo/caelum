package br.com.ae.livraria.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ae.livraria.ejb.Carrinho;
import br.com.ae.livraria.modelo.Livro;

public class ClienteCarrinhoLivraria {

	public static void main(String[] args) throws NamingException {
		
		InitialContext ic = new InitialContext();
		
		Carrinho carrinho = (Carrinho) ic.lookup("CarrinhoBean/remote");
		
		Livro livro = new Livro();
		livro.setNome("Alice no país dos quanta");
		livro.setPreco(15.0);
		
		carrinho.addLivro(livro);
		
		System.out.println(carrinho.getTotal());
		
		carrinho.finalizaCompra();
	}
}
