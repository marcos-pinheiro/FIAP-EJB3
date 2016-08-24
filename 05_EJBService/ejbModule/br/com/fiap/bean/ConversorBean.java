package br.com.fiap.bean;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(serviceName = "Conversor",
		portName = "ConversorPort",
		targetNamespace = "http://jaxws.exemplos.fiap.com.br") 
public class ConversorBean implements Conversor {

	private double valorDolar = 2.25;
	
	@Override
	public double dolarParaReal(double dolar) {
		return dolar * valorDolar;
	}

	@Override
	public double realParaDolar(double real) {
		return real / valorDolar;
	}
}
