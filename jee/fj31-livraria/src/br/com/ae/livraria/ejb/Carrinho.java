package br.com.ae.livraria.ejb;

import java.util.List;

import br.com.ae.livraria.modelo.Livro;

public interface Carrinho {

	void addLivro(Livro livro);

	List<Livro> getLivros();

	double getTotal();

	void finalizaCompra();

}
