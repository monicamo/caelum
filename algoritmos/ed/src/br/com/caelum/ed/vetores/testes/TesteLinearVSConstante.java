package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Vector;
import br.com.mv.ed.Aluno;

public class TesteLinearVSConstante {
	
	public static void main(String[] args) {
		
		Vector vetor = new Vector();
		
		long inicio = System.currentTimeMillis();
		
		for (int i = 1; i < 100000; i++) {
			Aluno aluno = new Aluno();
			vetor.adiciona(aluno);
		}
		
		long fim = System.currentTimeMillis();
		
		double tempo = (fim - inicio) / 1000.0;
		
		System.out.println("Tempo em segundos = " + tempo);		
		
	}

}
