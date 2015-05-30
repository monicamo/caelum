package br.com.ae.loja.cliente;

import java.rmi.RemoteException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ae.loja.rmi.Carrinho;
import br.com.ae.loja.rmi.Livro;

public class ClienteLojaCarrinhoNoJBoss {

	
	public static void main(String[] args) throws NamingException, RemoteException {
		
		InitialContext context = new InitialContext();
		Carrinho carrinho = (Carrinho) context.lookup("carrinho");
		

		Livro l1 = new Livro();
		l1.setNome("Pais e Filhos");
		l1.setPreco(100.0);
		
		Livro l2 = new Livro();
		l2.setNome("Noites brancas");
		l2.setPreco(200.0);
		
		carrinho.addLivro(l1);
		carrinho.addLivro(l2);

		carrinho.addLivro(l1);
		carrinho.addLivro(l2);
		
		System.out.println(carrinho.getTotal());
	}
}
