package br.com.fiap.main;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import br.com.fiap.exemplos.jaxws.Conversor;
import br.com.fiap.exemplos.jaxws.ConversorLocator;
import br.com.fiap.exemplos.jaxws.ConversorPortType;

public class Main {

	public static void main(String[] args) throws ServiceException, RemoteException {
		
		Conversor service = new ConversorLocator();
		ConversorPortType conversor = service.getConversorPort();
		
		System.out.println("Dolar para real -> " + conversor.dolarParaReal(100));
		System.out.println("Real para dolar -> " + conversor.realParaDolar(100));
		
	}

}
