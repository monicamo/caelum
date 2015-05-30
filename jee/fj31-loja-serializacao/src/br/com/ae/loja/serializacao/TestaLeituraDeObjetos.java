package br.com.ae.loja.serializacao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class TestaLeituraDeObjetos {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("livros.txt"));

		@SuppressWarnings("unchecked")
		List<Livro> livros = (List<Livro>) ois.readObject();
		for (Livro livro : livros) {
			System.out.println(livro.getNome());
			System.out.println(livro.getPreco());
		}
		
		ois.close();
	}

}
