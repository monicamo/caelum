package br.com.ae.livraria.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import br.com.ae.livraria.modelo.Livro;

@Stateful
@Remote(Carrinho.class)
public class CarrinhoBean implements Carrinho {

	private List<Livro> livros = new ArrayList<Livro>();
	private double total;
	
	@Override
	public void addLivro(Livro livro) {
		System.out.println("Adicionado o livro " + livro.getNome() + "ao carrinho.");
		this.livros.add(livro);
		this.total += livro.getPreco();
	}

	@Override
	public List<Livro> getLivros() {
		System.out.println("Carrinho devolvendo a lista de livros");
		return this.livros;
	}

	@Override
	public double getTotal() {
		System.out.println("Carrinho devolvendo o total " + this.total );
		return this.total;
	}

	@Override
	public void finalizaCompra() {
		System.out.println("Finalizando a compra de: ");
		for (Livro livro : livros) {
			System.out.println(livro.getPreco() +" - "+livro.getNome() );
		}
	}

	
}
