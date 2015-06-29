<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<c:import url="tarefa/inc/cabecalho.jsp" />
	<body>
		<h2>Página de Login das Tarefas</h2>
		<form action="efetuaLogin" method="post">
			Login: <input type="text" name="login" /> <br />
			Senha: <input type="password" name="senha" /> <br />
			<input type="submit" value="Entrar nas tarefas" />
		</form>
		
		<c:import url="tarefa/inc/rodape.jsp" />
	</body>
</html>