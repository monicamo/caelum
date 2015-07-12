package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Vetor;
import br.com.mv.ed.Aluno;

public class TesteEstoura {

	public static void main(String[] args) {

		Vetor vetor = new Vetor();
		
		for (int i = 0; i < 100001; i++) 
		{
			Aluno aluno = new Aluno();
			vetor.adiciona(aluno);
		}
	}

}
