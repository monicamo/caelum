package br.com.ae.livraria.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ae.loja.session.CotadorDeMoedas;

public class ClienteCotadorDeMoeda {

	public static void main(String[] args) throws NamingException {
		
		InitialContext ic = new InitialContext();
		CotadorDeMoedas cotadorDeMoedas = (CotadorDeMoedas) ic.lookup("fj31-loja-ear/CotadorDeMoedaBean/remote");
		
		System.out.println( cotadorDeMoedas.fazCotacao("dollar", "real", 1250.00)  );
	}
	
}
