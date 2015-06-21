<%@page import="br.com.caelum.jdbc.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.*, java.util.*, br.com.caelum.jdbc.*, br.com.caelum.jdbc.modelo.*" %>
<html>
	<body>
		<br>
		<br>
		<table border="1">
			<tr>
				<td>Id</td>
				<td>Nome</td>
				<td>Email</td>
				<td>Endereço</td>
				<td>Data de nascimento</td>
			</tr>
			<% 
				ContatoDao dao = new ContatoDao();
				List<Contato> contatos = dao.getLista();
				for (Contato contato : contatos) 
				{
					Calendar data = contato.getDataNascimento();
					String dataNascimento = new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());			
				%>
				<tr>
					<td><%=contato.getId() %></td>
					<td><%=contato.getNome() %></td>
					<td><%=contato.getEmail() %></td>
					<td><%=contato.getEndereco() %></td>
					<td><%=dataNascimento %></td>
				</tr>			
			<% 		
				}
			
			%>
		</table>
	</body>
</html>