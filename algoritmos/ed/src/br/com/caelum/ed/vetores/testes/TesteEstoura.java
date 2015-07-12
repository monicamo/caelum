package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Vector;
import br.com.mv.ed.Aluno;

public class TesteEstoura {

	public static void main(String[] args) {

		Vector vetor = new Vector();
		
		for (int i = 0; i < 100001; i++) 
		{
			Aluno aluno = new Aluno();
			vetor.adiciona(aluno);
		}
	}

}
