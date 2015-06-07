package br.com.ae.loja.ws;

import java.util.List;

import br.com.ae.loja.entity.Livro;

public interface ConsultaDeLivros {

	List<Livro> buscaLivro(String nome);
	
}
