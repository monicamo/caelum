package br.com.ae.jms;

import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FileBrowser {

	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext ic = new InitialContext();
		
		QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) ic.lookup("ConnectionFactory");
		
		QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
		
		QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Queue queue = (Queue) ic.lookup("queue/loja-fila");
		
		QueueBrowser queueBrowser = queueSession.createBrowser(queue);
		
		Enumeration enumeration = queueBrowser.getEnumeration();
		
		while (enumeration.hasMoreElements()) {	
			TextMessage textMessage = (TextMessage) enumeration.nextElement();
			System.out.println(textMessage.getText());
		}
	}
	
}
