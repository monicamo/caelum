package br.com.ae.jms;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Registrar o tratador de mensagens na Queu loja-fila
 * @author Monicamo
 *
 */
public class RegistraTratadorNaFila {

	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext ic = new InitialContext();
		
		QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) ic.lookup("ConnectionFactory");

		QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
		
		QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Queue queue = (Queue) ic.lookup("queue/loja-fila");
		
		QueueReceiver queueReceiver = queueSession.createReceiver(queue);
		
		queueReceiver.setMessageListener(new TratadorDeMensagens());
		
		queueConnection.start();
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Esperando as mensagens na fila JMS. Aperte ENTER para parar");
		
		teclado.nextLine();
		
		queueConnection.close();
		
		
	}
	
}
