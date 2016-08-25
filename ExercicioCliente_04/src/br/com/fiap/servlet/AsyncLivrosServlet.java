package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.entity.Livros;
import br.com.fiap.bean.LivrosBeanRemote;


@WebServlet("/AsyncLivrosServlet")
public class AsyncLivrosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "java:/queue/LivrosQ")
	private Queue queue;

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory factory;	   

	public AsyncLivrosServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			Connection connection = factory.createConnection();
			
			try {
				
				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

				MessageProducer messageProducer = session.createProducer(queue);
				
				Livros livro = new Livros();
				livro.setPreco(Double.parseDouble(request.getParameter("preco")));
				livro.setTitulo(request.getParameter("titulo"));
				livro.setAutor(request.getParameter("autor"));
				
				ObjectMessage message = session.createObjectMessage();
				message.setObject(livro);
				
				messageProducer.send(message);				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				connection.close();
			}
			
			request.setAttribute("mensagem", "Salvo com sucesso");
		} 
		catch (JMSException e1) {
			e1.printStackTrace();
		}
		
		request.getRequestDispatcher("lista.jsp").forward(request, response);
	}

}
