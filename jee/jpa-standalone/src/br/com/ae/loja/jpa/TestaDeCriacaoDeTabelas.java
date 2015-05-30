package br.com.ae.loja.jpa;

import javax.persistence.EntityManager;

import br.com.ae.loja.entity.Livro;


public class TestaDeCriacaoDeTabelas {
		
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().createEntityManager();
		
		Livro livro = new Livro();
		livro.setNome("As Luas de Marte");
		livro.setPreco(100.0);
		
		manager.getTransaction().begin();
		manager.persist(livro);
		manager.getTransaction().commit();
		
		System.out.println(livro.getId());
		
		manager.close();		
		System.out.println("Funcionou!");
		
	}

}
