package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Vetor;
import br.com.mv.ed.Aluno;

public class TestePegaPorPosicao {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		
		a1.setNome("Rafael");
		a2.setNome("Paulo");
		
		Vetor lista = new Vetor();
		
		lista.adiciona(a1);
		lista.adiciona(a2);
		
		Aluno aluno1 = lista.pega(0);
		Aluno aluno2 = lista.pega(1);
		
		System.out.println(aluno1);
		System.out.println(aluno2);		
		
		Aluno ad1 = new Aluno();
		
		a1.setNome("Rafael");
		
		Vetor lista1 = new Vetor();
		
		lista1.adiciona(ad1);
		lista1.pega(0);
		lista1.pega(1);
		lista1.pega(100000000);		
	}

}
