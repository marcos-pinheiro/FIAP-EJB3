package br.com.fiap.bean;

import javax.ejb.Remote;
import javax.jws.WebService;

@Remote @WebService(name  = "ConversorPortType", targetNamespace = "http://jaxws.exemplos.fiap.com.br")
public interface Conversor {

	double dolarParaReal(double valor);
	double realParaDolar(double valor);	
}
