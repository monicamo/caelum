package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.exception.DAOException;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDao {

	private Connection connection;

	public FuncionarioDao() 
	{
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Funcionario funcionario) 
	{
		String sql = "insert into funcionario  (nome, usuario, senha) values (?, ?, ?)";

		try 
		{
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());

			stmt.execute();
			stmt.close();
		} 
		catch (SQLException e) 
		{
			throw new DAOException();
		}
	}

	public List<Funcionario> getLista() 
	{
		try 
		{
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionario where nome like 'L%'");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) 
			{
				Funcionario funcionario = new Funcionario();

				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));

				funcionarios.add(funcionario);
			}

			rs.close();
			stmt.close();

			return funcionarios;
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public Funcionario pesquisar(int id) 
	{
		try 
		{
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionario where id="+id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) 
			{
				Funcionario funcionario = new Funcionario();

				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("Senha"));

				funcionarios.add(funcionario);
			}

			System.out.println(funcionarios.get(0).toString());

			Funcionario f = funcionarios.get(0);
			
			rs.close();
			stmt.close();

			return f;

		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void altera(Funcionario funcionario) 
	{
		String sql = "update funcionario set " + " nome=?, usuario=?, senha=? where id=?";

		try 
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(5, funcionario.getId());
			stmt.execute();
			stmt.close();
		}
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}

	public void remove(Funcionario funcionario) 
	{
		try 
		{
			PreparedStatement stmt = connection.prepareStatement("delete from funcionario where id=?");
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
			stmt.close();
		} 
		catch (Exception e) 
		{
			throw new DAOException();
		}
	}
}
