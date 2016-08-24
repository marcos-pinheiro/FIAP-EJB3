package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Remote;

import br.com.entity.Livros;

@Remote
public interface LivrosBeanRemote {
	
	void add(Livros livros);
	List<Livros> getAll();
	
}
