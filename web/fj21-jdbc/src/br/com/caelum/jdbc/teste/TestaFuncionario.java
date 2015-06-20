package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaFuncionario {

	public static void main(String[] args) {

		FuncionarioDao dao = new FuncionarioDao();

		System.out.println("------------------- iniciar adiciona ");
		for (int i = 0; i < 19; i++) 
		{
			Funcionario funcionario = new Funcionario();		
			funcionario.setNome("Nome Sobrenome " + i);
			funcionario.setUsuario("usuario"+i);
			funcionario.setSenha("password"+i);
			
			System.out.println(funcionario.toString());
			
			dao.adiciona(funcionario);
		}

		System.out.println("------------------- iniciar lista ");

		List<Funcionario> lista = dao.getLista();
		for (Funcionario funcionario : lista) {
			System.out.println(funcionario.getNome());
			System.out.println(funcionario.getUsuario());
			System.out.println(funcionario.getSenha());
			System.out.println("\n");
		}

		System.out.println("------------------- iniciar pesquisar ");
	
		Funcionario pesquisar = dao.pesquisar(2);
		System.out.println(pesquisar.getNome());
		System.out.println(pesquisar.getUsuario());
		System.out.println(pesquisar.getSenha());
		System.out.println("\n");
	
		System.out.println("------------------- iniciar apagar ");
		
		dao.remove(pesquisar);
	
		System.out.println("------------------- iniciar lista ");

		List<Funcionario> lista2 = dao.getLista();
		for (Funcionario funcionario : lista2) {
			System.out.println(funcionario.getNome());
			System.out.println(funcionario.getUsuario());
			System.out.println(funcionario.getSenha());
			System.out.println("\n");
		}
	}
	
}
