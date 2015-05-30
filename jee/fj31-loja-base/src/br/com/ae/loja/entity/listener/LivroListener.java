package br.com.ae.loja.entity.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.ae.loja.entity.Livro;

public class LivroListener {

	@PrePersist
	@PreUpdate
	public void prePersist(Livro livro) {
		
		livro.setDataCriacao(new Date());
		
		System.out.println("Avisa ao bibliotecario que existe um novo livro " + livro);
	}
	
}
