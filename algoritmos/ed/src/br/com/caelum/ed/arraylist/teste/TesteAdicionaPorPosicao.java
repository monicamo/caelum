package br.com.caelum.ed.arraylist.teste;

import br.com.caelum.ed.arraylist.Lista;

public class TesteAdicionaPorPosicao {

	public static void main(String[] args) {
		
		Lista lista = new Lista();
		
		lista.adiciona("Paulo");
		lista.adiciona(0, "Rafael");
		lista.adiciona(1, "Ana");
		lista.adiciona(0, "Roberto");
		
		System.out.println(lista);		
	}		
	
}
