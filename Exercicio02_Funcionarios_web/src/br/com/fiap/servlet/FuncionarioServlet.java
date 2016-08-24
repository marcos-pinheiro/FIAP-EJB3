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

import br.com.fiap.bean.FuncionarioBeanRemote;
import br.com.fiap.entity.Funcionario;

@WebServlet("/FuncionarioServlet")
public class FuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FuncionarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			//final Hashtable<String, String> jndiProperties = new Hashtable<>();
			//jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			
			InitialContext context = new InitialContext();
			FuncionarioBeanRemote remote = (FuncionarioBeanRemote) context.lookup("ejb:/Exercicio02_Funcionarios/FuncionarioBean!br.com.fiap.bean.FuncionarioBeanRemote");
			List<Funcionario> funcionarios = remote.listAll();
			
			request.setAttribute("funcionarios", funcionarios);
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			InitialContext context = new InitialContext();
			FuncionarioBeanRemote remote = (FuncionarioBeanRemote) context.lookup("ejb:/Exercicio02_Funcionarios/FuncionarioBean!br.com.fiap.bean.FuncionarioBeanRemote");
			
			Funcionario funcionario = new Funcionario();
			funcionario.setCpf(request.getParameter("cpf"));
			funcionario.setNome(request.getParameter("nome"));
			funcionario.setCargo(request.getParameter("cargo"));
			funcionario.setSalario(Double.parseDouble(request.getParameter("salario")));
			
			remote.salvar(funcionario);
			
			request.setAttribute("mensagem", "Salvo com sucesso");
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
				
	}

}
