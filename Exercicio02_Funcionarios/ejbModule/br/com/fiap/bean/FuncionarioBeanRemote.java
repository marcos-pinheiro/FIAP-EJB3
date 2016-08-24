package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.entity.Funcionario;

@Remote
public interface FuncionarioBeanRemote {
	
	void salvar(Funcionario funcionario);
	
	List<Funcionario> listAll();	
}
