package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class AlteraTarefa {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		
		Tarefa tarefa = manager.find(Tarefa.class, 3L);
		
		tarefa.setDescricao("TAREFA MODIFICADA");
		
		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
		System.out.println("ID da tarefa: " + tarefa.getId());		
		
		
		manager.close();
		factory.close();
		
	}
	
}
