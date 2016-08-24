package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.entity.Livros;

@Remote @WebService
public interface LivrosBeanRemote {
	
	@WebMethod
	void add(@WebParam(name = "livro") Livros livros);
	
	@WebMethod
	List<Livros> getAll();	
}
