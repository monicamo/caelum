package br.com.ae.loja.jpa;

import javax.persistence.EntityManager;

import br.com.ae.loja.entity.Livro;

public class TestaCarregamentoFind {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().createEntityManager();

		Livro livro = manager.getReference(Livro.class, 1L);
		
		System.out.println("Select feito!");
		
		System.out.println(livro.getNome());
		System.out.println(livro.getPreco());

	}

}
