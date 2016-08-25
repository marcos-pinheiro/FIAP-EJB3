package br.com.fiap.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.com.entity.Livros;
import br.com.fiap.bean.LivrosBean;

@MessageDriven(
	activationConfig = { 
		@ActivationConfigProperty(
			propertyName = "destination", 	  propertyValue = "queue/LivrosQ"), @ActivationConfigProperty(
			propertyName = "destinationType", propertyValue = "javax.jms.Queue")
	})	
public class LivrosMDB implements MessageListener {
    
	//@EJB
	private LivrosBean bean;
	
	public LivrosMDB() {
		
    }
	
    public void onMessage(Message message) {
    	try {
			Livros livro = (Livros) ((ObjectMessage)message).getObject();
			bean.add(livro);
		} 
    	catch (JMSException e) {
			e.printStackTrace();
		}
    }
}
