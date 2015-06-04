package br.com.ae.fj31.jaxb;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="cat")
public class Categoria {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria [nome=" + nome + "]";
	}
	
	
	
}
