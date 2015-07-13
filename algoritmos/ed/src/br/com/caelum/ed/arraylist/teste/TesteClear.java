package br.com.caelum.ed.arraylist.teste;

import br.com.caelum.ed.arraylist.Lista;

public class TesteClear {

	public static void main(String[] args) {
		
		Lista lista = new Lista();
		
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");

		System.out.println(lista);
		

		lista.clear();
		
		System.out.println(lista);
	
	}
}