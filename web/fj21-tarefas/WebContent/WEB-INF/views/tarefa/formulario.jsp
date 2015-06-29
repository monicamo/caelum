<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<link type="text/css" href="resources/css/tarefas.css" rel="stylesheet" />
</head>
<body>

<c:import url="inc/cabecalho.jsp" />
<h3>Adicionar tarefas</h3>

<form:errors path="tarefa.descricao" cssStyle="color:red" />

<form action="adicionaTarefa" method="post">

Descri��o: <br />

<textarea name="descricao" rows="5" cols="100"></textarea>

<br /> 
<br />
		

<input type="submit" value="Adicionar">

</form>

<c:import url="inc/rodape.jsp" />
</body>
</html>