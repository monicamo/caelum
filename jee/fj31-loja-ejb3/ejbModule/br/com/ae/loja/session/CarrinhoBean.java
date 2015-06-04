package br.com.ae.loja.session;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.ExcludeDefaultInterceptors;

import org.jboss.ejb3.annotation.CacheConfig;

import br.com.ae.loja.entity.Livro;

@Stateful
@Remote(Carrinho.class)
@CacheConfig(maxSize=50, idleTimeoutSeconds=120, removalTimeoutSeconds=360)
public class CarrinhoBean implements Carrinho {
	
	@EJB
	private Mensageiro mensageiro;
	
	private List<Livro> livros = new ArrayList<Livro>();
	private double total = 0.0;
	
	@ExcludeDefaultInterceptors
	@Override
	public void addLivro(Livro livro) {
		this.livros.add(livro);
		this.total += livro.getPreco();

		System.out.printf("Livro %s adicionado com sucesso... \n", livro.getNome());
	}

	@Override
	public List<Livro> getLivro() {
		return this.livros;
	}

	@ExcludeClassInterceptors
	@Override
	public double getTotal() {
		return this.total;
	}

	@Remove
	@Override
	public void finalizaCompra() {
		for (Livro livro : livros) {
			System.out.println("Comprando livro: " + livro);
			this.mensageiro.enviaMensagem("MSG: " + livro.getNome());
		}
	}
	
	@PreDestroy
	public void destroy() {	
		System.out.println("Removendo uma instancia do CarrinhoBean do Container ...");
	}
	
	@PostActivate
	public void ativando() {
		System.out.println("Ativando " + this);
	}
	
	@PrePassivate
	public void passivando() {
		System.out.println("Passivando " + this);
	}
}