package br.com.ae.loja.session;

import java.util.List;

import br.com.ae.loja.entity.Livro;

public interface Carrinho {

	void addLivro(Livro livro);
	List<Livro> getLivro();
	double getTotal();
	void finalizaCompra();
	
}
