package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Vector;
import br.com.mv.ed.Aluno;

public class TestePegaPorPosicao {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		
		a1.setNome("Rafael");
		a2.setNome("Paulo");
		
		Vector lista = new Vector();
		
		lista.adiciona(a1);
		lista.adiciona(a2);
		
		Aluno aluno1 = lista.pega(0);
		Aluno aluno2 = lista.pega(1);
		
		System.out.println(aluno1);
		System.out.println(aluno2);		
		
		Aluno ad1 = new Aluno();
		
		a1.setNome("Rafael");
		
		Vector lista1 = new Vector();
		
		lista1.adiciona(ad1);
		lista1.pega(0);
		lista1.pega(1);
		lista1.pega(100000000);		
	}

}
