package br.com.caelum.ed.arraylist.teste;

import br.com.caelum.ed.arraylist.Lista;

public class TesteRemovePorPosicao {

	public static void main(String[] args) {
		
		Lista lista = new Lista();
		
		lista.adiciona("Roberto");
		lista.adiciona("Paulo");
		lista.remove(0);
		
		System.out.println(lista);		
		
	}	
	
}
