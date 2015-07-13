package br.com.caelum.ed.arraylist.teste;

import br.com.caelum.ed.arraylist.Lista;

public class TesteTamanhoLista {
	
	public static void main(String[] args) {

		Lista lista = new Lista();
		
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		
		System.out.println(lista.tamanho());
		
		lista.adiciona("Roberto");
		
		System.out.println(lista.tamanho());		
		
	}

}
