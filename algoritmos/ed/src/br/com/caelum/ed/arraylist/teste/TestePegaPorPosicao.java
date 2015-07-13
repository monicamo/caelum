package br.com.caelum.ed.arraylist.teste;

import br.com.caelum.ed.arraylist.Lista;

public class TestePegaPorPosicao {

	public static void main(String[] args) {
		
		Lista lista = new Lista();
		
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		
		String pega1 = lista.pega(0);
		String pega2 = lista.pega(1);
		
		System.out.println(pega1);
		System.out.println(pega2);		
		
	}

}
