package br.com.ae.livraria.cliente;

import br.com.ae.loja.entity.Livro;

public class ClienteFazendoChamadaLocal {
	
	public static void main(String[] args) {
		
		Livro livro = new Livro();
		
		long inicio = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			livro.getPreco();
		}
		long fim = System.currentTimeMillis();

		System.out.println(fim-inicio);		
		
	}

}
