<%@page import="br.com.caelum.jdbc.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, br.com.caelum.jdbc.*, br.com.caelum.jdbc.modelo.*" %>
<html>
	<body>
		<br>
		<br>
		<table border="1">
			<% 
				ContatoDao dao = new ContatoDao();
				List<Contato> contatos = dao.getLista();
				
				for (Contato contato : contatos) {
				%>
				<tr>
					<td><%=contato.getId() %></td>
					<td><%=contato.getNome() %></td>
					<td><%=contato.getEmail() %></td>
					<td><%=contato.getEndereco() %></td>
					<td><%=contato.getDataNascimento().getTime() %></td>
				</tr>			
			<% 		
				}
			
			%>
		</table>
	</body>
</html>