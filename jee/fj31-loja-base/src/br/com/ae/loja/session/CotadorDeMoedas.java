package br.com.ae.loja.session;

public interface CotadorDeMoedas {
	
	double fazCotacao(String moedaOrigem, String moedaDestino, double quantia);
	void inicializa();

}
