package br.com.ae.loja.jpa;

import javax.persistence.EntityManager;

import br.com.ae.loja.entity.Livro;

public class TestaCarregamentoNull {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().createEntityManager();
		
		Livro livro = manager.find(Livro.class, 8L);
		
		System.out.println(livro);
		
		System.out.println(livro.getNome());
		System.out.println(livro.getPreco());
		
	}
	
}
