package br.com.ae.loja.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RegistraCarrinhoFactoryNoServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		LocateRegistry.createRegistry(1099);
		
		Naming.rebind("loja/carrinho", new CarrinhoBeanFactory());
		System.out.println("servico registrado");
		
	}
	
}
