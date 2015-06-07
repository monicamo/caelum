package br.com.ae.fj31.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class TesteMarshal {
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		
		Categoria categoria = new Categoria();
		
		categoria.setNome("esporte");
		
		Produto produto = new Produto();
		
		produto.setPreco(20.34);
		produto.setNome("Bola");
		produto.setDescricao("Uma bola quadrada");
		produto.setCategoria(categoria);
		
		JAXBContext context = JAXBContext.newInstance(Produto.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(produto, new FileOutputStream("bola.xml"));
	}
}
