package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Livros;
import br.com.fiap.bean.LivrosBeanRemote;
import br.com.fiap.bean.LivrosBeanRemoteProxy;

@WebServlet("/LivroServlet")
public class LivroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LivrosBeanRemote service = new LivrosBeanRemoteProxy();
		
		request.setAttribute("livros", service.getAll());
		request.getRequestDispatcher("livros.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LivrosBeanRemote service = new LivrosBeanRemoteProxy();
		
		Livros livro = new Livros();
		livro.setPreco(Double.parseDouble(request.getParameter("preco")));
		livro.setTitulo(request.getParameter("titulo"));
		livro.setAutor(request.getParameter("autor"));
		
		service.add(livro);
		
		request.setAttribute("mensagem", "Salvo com sucesso");
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}
}
