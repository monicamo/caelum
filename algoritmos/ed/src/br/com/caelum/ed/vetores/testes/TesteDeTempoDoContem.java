package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Vetor;
import br.com.mv.ed.Aluno;

public class TesteDeTempoDoContem {
	
	public static void main(String[] args) {

		Vetor vetor = new Vetor();
		
		long inicio = System.currentTimeMillis();
		
		// Adicionado 100000 alunos e
		// Verificando se eles foram realmente adicionados.
		for (int i = 1; i < 30000; i++) {
			Aluno aluno = new Aluno();
			vetor.adiciona(aluno);
			if(!vetor.contem(aluno)){
				System.out.println("Erro: aluno " + aluno + " não foi adicionado 1.");		
			}
		}
		
		// Verificando se o Vetor não encontra alunos não adicionados.
		for (int i = 1; i < 30000; i++) {
			Aluno aluno = new Aluno();
			if(vetor.contem(aluno)){
				System.out.println("Erro: aluno " + aluno + " foi adicionado 2.");
			}
		}
		
		long fim = System.currentTimeMillis();
		double tempo = (fim - inicio) / 1000.0;
		System.out.println("Tempo = " + tempo);

	
		/**
		 * 
		 * LENTO
		 * 
		 */
		Vetor vector = new Vetor();
		
		long inicio2 = System.currentTimeMillis();
		
		// Adicionado 100000 alunos e
		// Verificando se eles foram realmente adicionados.
		for (int i = 1; i < 30000; i++) {
			Aluno aluno = new Aluno();
			vector.adiciona_lento(aluno);
			if(!vector.contem_lento(aluno)){
				System.out.println("Erro: aluno " + aluno + " não foi adicionado 1.");		
			}
		}
		
		// Verificando se o Vetor não encontra alunos não adicionados.
		for (int i = 1; i < 30000; i++) {
			Aluno aluno = new Aluno();
			if(vector.contem_lento(aluno)){
				System.out.println("Erro: aluno " + aluno + " foi adicionado 2.");
			}
		}
		
		long fim2 = System.currentTimeMillis();
		double tempo2 = (fim2 - inicio2) / 1000.0;
		System.out.println("Tempo = " + tempo2);
	
	}
}
