package br.com.fiap.scheduler;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import br.com.fiap.bean.LivrosBean;


//@Startup
@Singleton //@Stateless
public class QuantidadeDeLivrosScheduler {
	
	@EJB
	private LivrosBean bean;
	
	@Schedule(second = "*/30", minute = "*", hour = "*")
	public void consultarQuantidade() {
		System.out.println("Quantidade de livros -> " + bean.getAll().size());
	}	
}
