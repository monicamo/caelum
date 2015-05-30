package br.com.ae.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TratadorDeMensagens implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		System.out.println("Teste tratador de mensagens");
		TextMessage textMessage = (TextMessage) msg;
		try {
			System.out.println("Tratador recebendo mensagens: " + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
