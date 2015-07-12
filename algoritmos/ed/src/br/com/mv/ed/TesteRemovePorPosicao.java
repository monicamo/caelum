package br.com.mv.ed;

public class TesteRemovePorPosicao {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		Aluno a4 = new Aluno();
		Aluno a5 = new Aluno();
		Aluno a6 = new Aluno();
		
		a1.setNome("Rafael");
		a2.setNome("Paulo");
		a3.setNome("Ana");
		a4.setNome("Luiz");
		a5.setNome("Maria");
		a6.setNome("Pedro");
		
		Vetor lista = new Vetor();
		
		lista.adiciona(a1);
		lista.adiciona(a2);
		lista.adiciona(a3);
		lista.adiciona(a4);
		lista.adiciona(a5);
		lista.adiciona(a6);
		
		lista.remove(0);
		lista.remove(4);
		lista.remove(3);
		
		System.out.println(lista);		
		
	}

}
