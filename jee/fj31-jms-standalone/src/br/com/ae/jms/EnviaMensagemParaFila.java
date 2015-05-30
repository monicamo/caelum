package br.com.ae.jms;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EnviaMensagemParaFila {

	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext ic = new InitialContext();
		
		QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) ic.lookup("ConnectionFactory");
		
		QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
		
		QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		
		TextMessage textMessage = queueSession.createTextMessage();
		
		textMessage.setText("Mensagem de texto para uma Queue");
		
		Queue queue = (Queue) ic.lookup("queue/loja-fila");
		
		QueueSender sender = queueSession.createSender(queue);
		
		sender.send(textMessage);
		
	}
	
}
