package br.com.ae.jms;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RegistraTratadorNoTopicoProps {

	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext ic = new InitialContext();
		
		TopicConnectionFactory  topicConnectionFactory = (TopicConnectionFactory) ic.lookup("ConnectionFactory");
		
		TopicConnection topicConnection = topicConnectionFactory.createTopicConnection();
		
		TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Topic topic = (Topic) ic.lookup("topico/loja-topico");
	
		TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic, "noticia = 'esporte'", true);
		topicSubscriber.setMessageListener(new TratadorDeMensagens());
		
		topicConnection.start();
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Esperando as mensagens no topico JMS. Aperte ENTER para parar");
		
		teclado.nextLine();
		
		
	}
}
