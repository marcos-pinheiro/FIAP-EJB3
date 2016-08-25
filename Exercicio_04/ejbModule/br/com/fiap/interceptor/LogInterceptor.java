package br.com.fiap.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptor {
	
	@AroundInvoke
	public Object register(InvocationContext context) throws Exception {
		
		Object result = context.proceed();
		System.out.println("Livro registrado às " + 
				new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
		
		return result;
	}
	
}
