package br.com.caelum.ed.arraylist.teste;

import br.com.caelum.ed.arraylist.Lista;

public class TesteAdicionaNoFim {
	
	public static void main(String[] args) 
	{

		
		Lista lista = new Lista();
		
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
	
		System.out.println(lista);
	}

}
