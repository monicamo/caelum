package br.com.ae.webservices;

import javax.xml.ws.Endpoint;

/**
 * http://localhost:10000/calculadoraDeParcela?wsdl
 * 
 * @author Monicamo
 *
 */
public class Publicador {
	
	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:10000/calculadoraDeParcela", new CalculadoraDeParcela());
		
	}

}
