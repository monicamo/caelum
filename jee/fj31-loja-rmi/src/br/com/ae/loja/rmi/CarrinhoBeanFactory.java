package br.com.ae.loja.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarrinhoBeanFactory extends UnicastRemoteObject implements CarrinhoFactory {

	protected CarrinhoBeanFactory() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Carrinho create() throws RemoteException {
		CarrinhoBean carrinho = new CarrinhoBean();
		return carrinho;
	}

}
