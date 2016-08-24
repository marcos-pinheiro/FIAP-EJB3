package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Funcionario;


@Stateless
public class FuncionarioBean implements FuncionarioBeanRemote {

	@PersistenceContext(unitName = "fiapPU")
	private EntityManager entityManager;
	
    public FuncionarioBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void salvar(Funcionario funcionario) {
		entityManager.persist(funcionario);
	}

	@Override
	public List<Funcionario> listAll() {
		TypedQuery<Funcionario> query = entityManager.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
		return query.getResultList();
	}
}
