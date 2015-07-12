package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Vector;
import br.com.mv.ed.Aluno;

public class TesteAdicionaNoFim 
{
	public static void main(String[] args) 
	{
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
	
		a1.setNome("Rafael");
		a2.setNome("Paulo");
		
		Vector lista = new Vector();
		
		lista.adiciona(a1);
		lista.adiciona(a2);
		
		System.out.println(lista);
	}
}
