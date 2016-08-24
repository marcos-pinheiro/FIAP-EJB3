package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.entity.Livros;

@Stateless
@WebService(serviceName = "LivroEndPoint")
public class LivrosBean implements LivrosBeanRemote {
	
	@PersistenceContext(unitName = "fiapPU")
	private EntityManager entityManager;


	@Override
	public void add(Livros livros) {
		entityManager.persist(livros);
		
	}

	@Override
	public List<Livros> getAll() {
		final String sql = "SELECT livros FROM Livros livros"; 
		
		TypedQuery<Livros> query = entityManager.createQuery(sql, Livros.class);
		return query.getResultList();
	}
}
