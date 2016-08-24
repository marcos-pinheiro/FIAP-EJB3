package br.com.fiap.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MonitorInterceptor {
	
	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		
		final String methodName = context.getMethod().getName();
		final String clazzName	= context.getTarget().getClass().getName();
		
		long start = System.currentTimeMillis();
		Object object = context.proceed();		
		System.out.println(String.format("[Class: %s] - [Method: %s] - [Time in milis: %d]", clazzName, methodName, System.currentTimeMillis() - start));
		
		return object;
	}
	
}
