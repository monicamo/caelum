package br.com.ae.loja.session;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(Mensageiro.class)
public class MensageiroBean implements Mensageiro {

	@Override
	public void enviaMensagem(String mensagem) {
		System.out.println(mensagem);
	}

}
