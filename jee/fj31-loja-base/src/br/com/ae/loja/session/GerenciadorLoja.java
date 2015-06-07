package br.com.ae.loja.session;

import java.util.List;

import br.com.ae.loja.entity.Autor;
import br.com.ae.loja.entity.Livro;

public interface GerenciadorLoja {

	Livro procura(String isbn);
	Livro procura(Long id);
	void salva(Livro livro);
	Autor salva(Autor autor);
	List<Autor> getAutoresDoLivro(Livro livro);
	List<Livro> buscaLivrosPeloNomeDoAutor(String nome);
	List<Livro> buscaTodosOsLivros();
	List<Autor> buscaAutoresPeloNomeDoLivro(String nome);
	List<Autor> buscaAutorPeloNome(String nome);
	List<Livro> buscaLivroPaginacao(String nome, int primeira, int maxima);
	List<Livro> buscaLivroPeloNomeEPreco(String nomeDoLivro, double precoDoLivro);
	List<Livro> listaLivros();
}
