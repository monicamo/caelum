package br.com.ae.livraria.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ae.loja.session.Carrinho;

public class ClienteFuzilandoServidor {
	
	public static void main(String[] args) throws NamingException {
		
		InitialContext context = new InitialContext();
		Carrinho carrinhoRemoto = (Carrinho) context.lookup("fj31-loja-ear/CarrinhoBean/remote");
		
		long inicio = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			carrinhoRemoto.getTotal();
		}
		long fim = System.currentTimeMillis();

		System.out.println(fim-inicio);
	}

}
