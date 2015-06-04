package br.com.ae.loja.session;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
@Local(Mensageiro.class)
public class MensageiroBean implements Mensageiro {

	@Resource(mappedName="ConnectionFactory")
	private ConnectionFactory fabrica;
	
	@Resource(mappedName="queue/loja-fila")
	private Queue queue;
	
	@Override
	public void enviaMensagem(String mensagem) 
	{
		System.out.println("enviaMensagem " + mensagem);
		
		try {
			Connection conexao = this.fabrica.createConnection();
			
			Session sessao = conexao.createSession(true, Session.AUTO_ACKNOWLEDGE);

			MessageProducer produtor = sessao.createProducer(this.queue);
			
			TextMessage textMessage = sessao.createTextMessage();

			textMessage.setText(mensagem);

			System.out.println("Vendas enviando: " + mensagem);
			produtor.send(textMessage);
			
			produtor.close();
			conexao.close();
		}
		catch (Exception e) 
		{
			throw new EJBException();
		}
	}
 
}
