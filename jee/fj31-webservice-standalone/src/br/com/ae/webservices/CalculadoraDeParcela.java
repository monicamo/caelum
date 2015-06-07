package br.com.ae.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


/**
 * 
 * gere a classes que representam as mensagens a serem trocadas
 * wsgen -cp bin -s src -wsdl br.com.ae.webservices.CalculadoraDeParcela
 * 
 * gere as classes cliente do servico
 * wsimport -s src -d bin -p br.com.ae.cliente http://localhost:10000/calculadoraDeParcela?wsdl
 * 
 *
 */


@WebService
public class CalculadoraDeParcela {

	@WebMethod
	public double calculaParcela(
			@WebParam(name="valorTotal") double valorTotal, 
			@WebParam(name="quantidade") int quantidade) 
	{
		if (quantidade < 0) 
		{
			return 0;
		}
		
		double oValorTotal = valorTotal * ( 1 + (quantidade / 100.0));
		
		return oValorTotal / quantidade;
	}
	
}
