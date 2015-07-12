package br.com.caelum.ed.vetores;

import br.com.mv.ed.Aluno;

public class Vector {

	// Declarando e Inicializando um array de Aluno com capacidade 100.
	private Aluno[] alunos = new Aluno[10000];

	private int totalDeAlunos = 0;

	public void adiciona_lento(Aluno aluno) {
		this.garanteEspaco();
		for (int i = 0; i < alunos.length; i++) {
			if (this.alunos[i] == null) {
				this.alunos[i] = aluno;
				break;
			}
		}
	}

	public void adiciona(Aluno aluno) {
		this.garanteEspaco();

		this.alunos[this.totalDeAlunos] = aluno;
		this.totalDeAlunos++;
	}

	public void adiciona(int posicao, Aluno aluno) {
		this.garanteEspaco();
		if (!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posicao inválida");
		}
		for (int i = this.totalDeAlunos - 1; i >= posicao; i--) {
			this.alunos[i + 1] = this.alunos[i];
		}
		this.alunos[posicao] = aluno;
		this.totalDeAlunos++;
	}

	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.totalDeAlunos;
	}

	public Aluno pega_lento(int posicao) {
		return this.alunos[posicao];
	}

	public Aluno pega(int posicao) {
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		return this.alunos[posicao];
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeAlunos;
	}

	public void remove(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao inválida");
		}
		for (int i = posicao; i < this.totalDeAlunos - 1; i++) {
			this.alunos[i] = this.alunos[i + 1];
		}
		this.totalDeAlunos--;
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
	
	
	public boolean contem(Aluno aluno) {
		for (int i = 0; i < this.totalDeAlunos; i++) {
			if (aluno == this.alunos[i]) {
				return true;
			}
		}
		return false;
	}

	public boolean contem_lento(Aluno aluno) {
		for (int i = 0; i < this.alunos.length; i++) {
			if (aluno == this.alunos[i]) {
				return true;
			}
		}
		return false;
	}

	public int tamanho() {
		return this.totalDeAlunos;
	}

	@Override
	public String toString() {
		if (this.totalDeAlunos == 0) {
			return "";
		}

		StringBuilder builder = new StringBuilder();

		builder.append("[");

		for (int i = 0; i < this.totalDeAlunos; i++) {
			builder.append(this.alunos[i]);
			builder.append(",");
		}

		builder.append(this.alunos[this.totalDeAlunos]);
		builder.append("]");

		return builder.toString();
	}
}
