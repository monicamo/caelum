package br.com.ae.loja.session;

import java.util.Random;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
@Remote(CotadorDeMoedas.class)
public class CotadorDeMoedaBean implements CotadorDeMoedas {

	private double fatorDeCotacao = 1.63;
	
	@Resource
	private TimerService timerService;
	
	@Override
	public double fazCotacao(String moedaOrigem, String moedaDestino, double quantia) {
	
		
		if ("dollar".equals(moedaOrigem) && "real".equals(moedaDestino)) {
			// pega o fator de cotacao de algum lugar sempre atualizado
			return quantia * this.fatorDeCotacao;
			
		}
		return 0;
	}

	@Override
	public void inicializa() {
		timerService.createTimer(3000L, "timeout");
	}
	
	@Timeout
	public void atualizaFatorDeCotacao(Timer timer) {
		this.fatorDeCotacao += (new Random().nextDouble() - 0.5) / 100;
		System.out.printf("Atualizando o fator de cotacao para:  %.3f", this.fatorDeCotacao);
	}

}
