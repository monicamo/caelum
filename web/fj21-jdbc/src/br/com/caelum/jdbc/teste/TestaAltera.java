package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {
	
		ContatoDao dao = new ContatoDao();
		
		Contato contato = dao.pesquisar(1);
		
		System.out.println("Nome " + contato.getNome());
		System.out.println("Email " + contato.getEmail());
		System.out.println("Endereco " + contato.getEndereco());
		
		Calendar dataNascimento = contato.getDataNascimento();
		Calendar c = new GregorianCalendar();
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		sf.setTimeZone(c.getTimeZone());
		
		String dt = sf.format(dataNascimento.getTime());
		
		System.out.println("Data de nascimento " + dt + "\n");		

		
		contato.setNome("Sky Dimitri");
		
		dao.altera(contato);
		
		Contato contato2 = dao.pesquisar(1);
		
		System.out.println("Nome " + contato2.getNome());
		System.out.println("Email " + contato2.getEmail());
		System.out.println("Endereco " + contato2.getEndereco());
		
		
		Contato contato3 = dao.pesquisar(5);

		System.out.println("Apagar " + contato3.toString());
		
		
		dao.remove(contato3);
		
		
	}
	
}
