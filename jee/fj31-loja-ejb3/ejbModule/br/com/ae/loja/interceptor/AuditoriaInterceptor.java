package br.com.ae.loja.interceptor;

import java.util.Arrays;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * 
 * @author Monicamo
 *
 */
public class AuditoriaInterceptor {

	@AroundInvoke
	public Object log(InvocationContext context) throws Exception 
	{
		String classe = context.getTarget().getClass().getSimpleName();
		String metodo = context.getMethod().getName();
		String params = Arrays.toString(context.getMethod().getParameterTypes());
		
		System.out.println(" ********** AUDITORIA **********");
		System.out.println("Acessando: " + classe + "." + metodo +"."+ "("+ params +")");
		
		return context.proceed();		
	}
	
	
}
