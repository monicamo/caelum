package br.com.mv.ed;

import java.util.Arrays;

public class Vetor {

	private int totalDeAlunos = 0;

	// Declarando e Inicializando um array de Aluno com capacidade 100.
	private Aluno[] alunos = new Aluno[100];

	/**
	 * 
	 * @param aluno
	 */
	public void adiciona(Aluno aluno) 
	{
		this.garanteEspaco();
		this.alunos[this.totalDeAlunos] = aluno;
		this.totalDeAlunos++;
	}

	private void garanteEspaco() 
	{
		if (this.totalDeAlunos == this.alunos.length) 
		{
			Aluno[] novoAlunos = new Aluno[this.alunos.length * 2];
		
			for (int i = 0; i < this.alunos.length; i++) 
			{
				novoAlunos[i] = (Aluno) this.alunos[i];
				this.alunos = novoAlunos;
			}
		}
	}

	public void adiciona(int posicao, Aluno aluno) 
	{
		this.garanteEspaco();
		if (!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posicao inválida");
		}
		
		for (int i = this.totalDeAlunos-1; i >= posicao; i--) {
			this.alunos[i+1] = this.alunos[i];
		}

		this.alunos[posicao] = aluno;
		this.totalDeAlunos++;
	}

	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.totalDeAlunos;
	}

	public Aluno pega(int posicao) 
	{
		if (!posicaoOcupada(posicao)) 
		{
			throw new IllegalArgumentException("Posicao invalida");
		}
		return this.alunos[posicao];
	}

	private boolean posicaoOcupada(int posicao) 
	{
		return posicao >= 0 && posicao < this.totalDeAlunos;
	}

	public void remove(int posicao) 
	{
		if (!this.posicaoValida(posicao)) {
			throw new IllegalAccessError("Posição Inválida");
		}

		for (int i = posicao; i <= this.totalDeAlunos-1; i++) {
			this.alunos[i] = this.alunos[i + 1];
		}
		this.totalDeAlunos--;
	}

	public boolean contem(Aluno aluno) {

		for (int i=0; i<this.totalDeAlunos; i++) 
		{
			if (aluno.equals(this.alunos[i])) 
			{
				return true;
			}
		}
		return false;
	}

	public int tamanho() 
	{
		return this.totalDeAlunos;
	}

	public String toString() 
	{
		if (this.totalDeAlunos == 0) {
			return ""; 
		}
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("[");
		
		for (int i = 0; i < this.totalDeAlunos; i++) 
		{
			builder.append(this.alunos[i]);
			builder.append(",");
		}
		
		builder.append(this.alunos[this.totalDeAlunos]);
		builder.append("]");

		return builder.toString();
	}
}