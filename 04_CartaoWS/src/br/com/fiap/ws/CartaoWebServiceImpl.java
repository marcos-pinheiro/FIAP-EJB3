package br.com.fiap.ws;

import static java.util.Objects.nonNull;

import javax.jws.WebService;

@WebService(serviceName = "CartaoEndPoint")
public class CartaoWebServiceImpl implements CartaoWebService {

	@Override
	public String validarCartao(String numeroCartao, double valor) {
		if(nonNull(numeroCartao) && numeroCartao.length() == 16) {
			return "D�bito de " + valor + " efetuado com sucesso";
		}
		
		return "Cart�o inv�lido";
	}
}
