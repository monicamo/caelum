package br.com.caelum.ed.arraylist.teste;

import br.com.caelum.ed.arraylist.Lista;

public class TesteLastIndexOf {

	public static void main(String[] args) {
		
		Lista lista = new Lista();
		
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		lista.adiciona("Roberto");
		lista.adiciona("Jorge");
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		lista.adiciona("Roberto");
		lista.adiciona("Jorge");
		lista.adiciona("Paulo");
		lista.adiciona("Roberto");
		lista.adiciona("Rafael");

		System.out.println( lista.lastIndexOf("Roberto") );
		
		
	}
	
}
