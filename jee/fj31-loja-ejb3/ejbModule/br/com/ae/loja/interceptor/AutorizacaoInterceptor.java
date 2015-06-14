package br.com.ae.loja.interceptor;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.interceptor.InvocationContext;

public class AutorizacaoInterceptor {

	@Resource
	EJBContext ejbContext;
	
	public Object verifica(InvocationContext context) throws Exception {
		
		System.out.println("******************* SECURITY *******************");
		System.out.println("PRINCIPAL: " + ejbContext.getCallerPrincipal().getName());
		System.out.println("EH ADMIN: " + ejbContext.isCallerInRole("administrador"));
	
		return context.proceed();
	}
	
}
