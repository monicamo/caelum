package br.com.caelum.ed.arraylist;

import java.util.ArrayList;

public class Lista {

	// Declarando e Inicializando um array de Aluno com capacidade 100.
	private ArrayList<String> strings = new ArrayList<String>();


	public void adiciona(String string) {
		if (string.isEmpty())
			throw new IllegalArgumentException("String invalida");
		strings.add(string);
	}

	public void adiciona(int posicao, String string) {
		if (string.isEmpty())
			throw new IllegalArgumentException("String invalida");
		strings.add(posicao, string);
	}

	public String pega(int posicao) {
		return strings.get(posicao);
	}

	public void remove(int posicao) {
		strings.remove(posicao);
	}

	public boolean contem(String string) {
		return strings.contains(string);
	}

	public int tamanho() {
		return strings.size();
	}

	@Override
	public String toString() {
		return "Lista [strings=" + strings + "]";
	}
 
	public void clear() {
		this.strings =  new ArrayList<String>();
	}
	
	
	public int indexOf(Object object) {
		int indexOf = strings.indexOf(object);
		return indexOf;
	}
	
	public int lastIndexOf(Object objeto) {
		int lastIndexOf = strings.lastIndexOf(objeto);
		return lastIndexOf;
	}
	
	
	
	
	
}
