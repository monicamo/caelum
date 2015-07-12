package br.com.caelum.ed.vetores.testes;

import java.util.ArrayList;

import br.com.caelum.ed.vetores.Vector;
import br.com.mv.ed.Aluno;
import br.com.mv.ed.Vetor;

public class TesteExercicio {
	
	public static void main(String[] args) {
		
		Vetor vetor = new Vetor();
		Vector vector = new Vector();
		ArrayList lista = new ArrayList();
		
		for (int i = 0; i < 1000; i++) 
		{
			Aluno aluno = new Aluno();
			vetor.adiciona(aluno);
		}
		
		System.out.println("Tamanho do vetor " + vetor.tamanho());
		
		for (int i = 0; i < 1000; i++) 
		{
			Aluno aluno = new Aluno();
			vector.adiciona(aluno);
		}
		
		System.out.println("Tamanho do vetor " + vector.tamanho());
		
		for (int i = 0; i < vector.tamanho(); i++) 
		{
			Aluno aluno = new Aluno();
			lista.add( vector.pega(i) );
		}		
		
		System.out.println("Tamanho do vetor " + lista.size());
		
	}

}
