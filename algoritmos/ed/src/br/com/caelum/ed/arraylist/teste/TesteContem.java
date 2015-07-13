package br.com.caelum.ed.arraylist.teste;

import br.com.caelum.ed.arraylist.Lista;

public class TesteContem {

	public static void main(String[] args) {


		Lista lista = new Lista();
		
		lista.adiciona("Paulo");
		lista.adiciona("Rafael");
		
		System.out.println(lista.contem("Paulo"));
		System.out.println(lista.contem("Rafael"));
		
		lista.adiciona("Anne");
		
		System.out.println(lista.contem("Ana"));		
		
	}
}
