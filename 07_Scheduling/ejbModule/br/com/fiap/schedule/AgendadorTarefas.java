package br.com.fiap.schedule;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class AgendadorTarefas {

	@Schedule(second = "*/5") //comece agora / a cada 5 segundos
	public void agendar() {
		System.out.println("teste");
	}
}
