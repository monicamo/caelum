package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		
		
		ContatoDao dao = new ContatoDao();
		
		
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			
			System.out.println("Nome " + contato.getNome());
			System.out.println("Email " + contato.getEmail());
			System.out.println("Endereco " + contato.getEndereco());
			
			Calendar dataNascimento = contato.getDataNascimento();
			Calendar c = new GregorianCalendar();
			
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			sf.setTimeZone(c.getTimeZone());
			
			String dt = sf.format(dataNascimento.getTime());
			
			System.out.println("Data de nascimento " + dt + "\n");
			
		}
	}
	
}
