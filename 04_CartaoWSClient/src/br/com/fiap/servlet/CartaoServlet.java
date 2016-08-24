package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.ws.CartaoWebService;
import br.com.fiap.ws.CartaoWebServiceProxy;


@WebServlet("/CartaoServlet")
public class CartaoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String cartao = request.getParameter("numero");
		final double valor  = Double.parseDouble(request.getParameter("valor"));
		
		CartaoWebService service = new CartaoWebServiceProxy();
		final String mensagem = service.validarCartao(cartao, valor);
		
		request.setAttribute("mensagem", mensagem);
		request.getRequestDispatcher("cartao.jsp").forward(request, response);
	}
}
