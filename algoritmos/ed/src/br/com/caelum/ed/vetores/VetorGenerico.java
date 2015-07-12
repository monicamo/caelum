package br.com.caelum.ed.vetores;


public class VetorGenerico {

	// Declarando e Inicializando um array de Object com capacidade 100.
	private Object[] objects = new Object[100000];

	private int totalDeObjects = 0;

	public void adiciona_lento(Object object) {
		this.garanteEspaco();
		for (int i = 0; i < objects.length; i++) {
			if (this.objects[i] == null) {
				this.objects[i] = object;
				break;
			}
		}
	}

	public void adiciona(Object object) {
		this.garanteEspaco();

		this.objects[this.totalDeObjects] = object;
		this.totalDeObjects++;
	}

	public void adiciona(int posicao, Object object) {
		this.garanteEspaco();
		if (!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posicao inválida");
		}
		for (int i = this.totalDeObjects - 1; i >= posicao; i--) {
			this.objects[i + 1] = this.objects[i];
		}
		this.objects[posicao] = object;
		this.totalDeObjects++;
	}

	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.totalDeObjects;
	}

	public Object pega_lento(int posicao) {
		return this.objects[posicao];
	}

	public Object pega(int posicao) {
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		return this.objects[posicao];
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeObjects;
	}

	public void remove(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao inválida");
		}
		for (int i = posicao; i < this.totalDeObjects - 1; i++) {
			this.objects[i] = this.objects[i + 1];
		}
		this.totalDeObjects--;
	}

	private void garanteEspaco() 
	{
		if (this.totalDeObjects == this.objects.length) 
		{
			Object[] novoObjects = new Object[this.objects.length * 2];
		
			for (int i = 0; i < this.objects.length; i++) 
			{
				novoObjects[i] = (Object) this.objects[i];
				this.objects = novoObjects;
			}
		}
	}	
	
	
	public boolean contem(Object object) {
		for (int i = 0; i < this.totalDeObjects; i++) {
			if (object == this.objects[i]) {
				return true;
			}
		}
		return false;
	}

	public boolean contem_lento(Object object) {
		for (int i = 0; i < this.objects.length; i++) {
			if (object == this.objects[i]) {
				return true;
			}
		}
		return false;
	}

	public int tamanho() {
		return this.totalDeObjects;
	}

	@Override
	public String toString() {
		if (this.totalDeObjects == 0) {
			return "";
		}

		StringBuilder builder = new StringBuilder();

		builder.append("[");

		for (int i = 0; i < this.totalDeObjects; i++) {
			builder.append(this.objects[i]);
			builder.append(",");
		}

		builder.append(this.objects[this.totalDeObjects]);
		builder.append("]");

		return builder.toString();
	}
}
