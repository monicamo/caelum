<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
	<body>
	
		<c:import url="inc/cabecalho.jsp" />
	
		<h3>Alterar tarefa - ${tarefa.id}</h3>
		<form action="alteraTarefa" method="post">

			<input type="hidden" name="id" value="${tarefa.id}"/>

			Descrição:<br />
			<textarea name="descricao" cols="100" rows="5">${tarefa.descricao}</textarea>
			<br />

			Finalizado? <input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado? 'checked' : '' }/> <br />
			
			Data de finalização: <br />
			<!-- value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}"  pattern="dd/MM/yyyy"  />"   -->
		 
			<caelum:campoData id="dataFinalizacao" />
			<br />
			<input type="submit" value="Alterar"/>
		</form>
		
		<c:import url="inc/rodape.jsp" />
	</body>
</html>