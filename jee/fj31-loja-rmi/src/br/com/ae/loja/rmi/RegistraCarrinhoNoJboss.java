package br.com.ae.loja.rmi;

import java.rmi.RemoteException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RegistraCarrinhoNoJboss {
	
	public static void main(String[] args) throws NamingException, RemoteException {

		InitialContext context = new InitialContext();
		context.rebind("carrinho", new CarrinhoBean());
		
		System.out.println("Carrinho registrado com JBoss");
	}

}
