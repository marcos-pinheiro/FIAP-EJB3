package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.entity.Livros;
import br.com.fiap.bean.LivrosBeanRemote;


@WebServlet("/LivrosServlet")
public class LivrosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;   

    public LivrosServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//final PrintWriter out = response.getWriter();
		
		try {
			InitialContext context = new InitialContext();
			
			LivrosBeanRemote remote = (LivrosBeanRemote) context.lookup("ejb:/03_LivrosEJB/LivrosBean!br.com.fiap.bean.LivrosBeanRemote");
			List<Livros> livros = remote.getAll();
			
			request.setAttribute("livros", livros);
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
