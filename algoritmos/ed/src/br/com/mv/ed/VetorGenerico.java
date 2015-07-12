package br.com.mv.ed;

public class VetorGenerico {

	private int totalDeObjetos = 0;

	// Declarando e Inicializando um array de Object com capacidade 100.
	private Object[] objetos = new Object[100];

	/**
	 * 
	 * @param Object
	 */
	public void adiciona(Object objeto) 
	{
		this.garanteEspaco();
		this.objetos[this.totalDeObjetos] = objeto;
		this.totalDeObjetos++;
	}

	private void garanteEspaco() 
	{
		if (this.totalDeObjetos == this.objetos.length) 
		{
			Object[] novosObjetos = new Object[this.objetos.length * 2];
		
			for (int i = 0; i < this.objetos.length; i++) 
			{
				novosObjetos[i] = (Object) this.objetos[i];
				this.objetos = novosObjetos;
			}
		}
	}

	public void adiciona(int posicao, Object objeto) 
	{
		this.garanteEspaco();
		if (!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posicao inválida");
		}
		
		for (int i = this.totalDeObjetos-1; i >= posicao; i--) {
			this.objetos[i+1] = this.objetos[i];
		}

		this.objetos[posicao] = objeto;
		this.totalDeObjetos++;
	}

	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.totalDeObjetos;
	}

	public Object pega(int posicao) 
	{
		if (!posicaoOcupada(posicao)) 
		{
			throw new IllegalArgumentException("Posicao invalida");
		}
		return this.objetos[posicao];
	}

	private boolean posicaoOcupada(int posicao) 
	{
		return posicao >= 0 && posicao < this.totalDeObjetos;
	}

	public void remove(int posicao) 
	{
		if (!this.posicaoValida(posicao)) {
			throw new IllegalAccessError("Posição Inválida");
		}

		for (int i = posicao; i <= this.totalDeObjetos-1; i++) {
			this.objetos[i] = this.objetos[i + 1];
		}
		this.totalDeObjetos--;
	}

	public boolean contem(Object objeto) {

		for (int i=0; i<this.totalDeObjetos; i++) 
		{
			if (objeto.equals(this.objetos[i])) 
			{
				return true;
			}
		}
		return false;
	}

	public int tamanho() 
	{
		return this.totalDeObjetos;
	}

	public String toString() 
	{
		if (this.totalDeObjetos == 0) {
			return ""; 
		}
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("[");
		
		for (int i = 0; i < this.totalDeObjetos; i++) 
		{
			builder.append(this.objetos[i]);
			builder.append(",");
		}
		
		builder.append(this.objetos[this.totalDeObjetos]);
		builder.append("]");

		return builder.toString();
	}
}
