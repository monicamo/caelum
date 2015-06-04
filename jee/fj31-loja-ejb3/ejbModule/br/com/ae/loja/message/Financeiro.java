package br.com.ae.loja.message;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@MessageDriven( activationConfig = { 
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/loja-fila") })
public class Financeiro implements MessageListener {

	@Override
	public void onMessage(Message message) {

		try {
			String text = ((TextMessage) message).getText();
			System.out.println("Financeiro processando informação: " + text);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EJBException();
		}
	}
}
