package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.exception.DAOException;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {

		String sql = "insert into contatos "
				+ " (nome, email, endereco, dataNascimento) "
				+ " values (?, ?, ?, ?)";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new DAOException();
		}

	}

	public List<Contato> getLista() {

		try {

			List<Contato> contatos = new ArrayList<Contato>();

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from contatos where nome like 'L%'");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Contato contato = new Contato();

				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando data
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));

				contato.setDataNascimento(data);

				contatos.add(contato);

			}

			rs.close();
			stmt.close();

			return contatos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Contato pesquisar(int id) {

		try {

			List<Contato> contatos = new ArrayList<Contato>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id=" + id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando data
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));

				contato.setDataNascimento(data);

				contatos.add(contato);
			}

			System.out.println(contatos.get(0).toString());
			
			Contato c = contatos.get(0);
			
			rs.close();
			stmt.close();

			return c;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato) {
		
		String sql = "update contatos set ~"
				+ " nome=?, email=?, endereco=?, dataNascimento=? "
				+ " where id=?";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
			
		}
		catch (Exception e) 
		{
			throw new DAOException();
		}
		
		
	}

}
