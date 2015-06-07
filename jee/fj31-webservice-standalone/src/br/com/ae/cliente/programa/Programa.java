package br.com.ae.cliente.programa;

import br.com.ae.cliente.CalculadoraDeParcela;
import br.com.ae.cliente.CalculadoraDeParcelaService;
 

public class Programa {

	public static void main(String[] args) {
		
		CalculadoraDeParcela calculadora =  new CalculadoraDeParcelaService().getCalculadoraDeParcelaPort();
		System.out.println(calculadora.calculaParcela(100, 2));
		
	}
	
}
