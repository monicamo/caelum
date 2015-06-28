<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<body>	
	<script type="text/javascript">
		function finalizaAgora(id) {
			$.post("finalizaTarefa", {'id' : id}, function(resposta) {
				// selecionando o elemento html atrav�s da
				// ID e alterando o HTML dele
				//$("#finalizaTarefa_"+id).html("Finalizado");
				$("#tarefa_"+id).html(resposta);
			});
		}
	
		function removeAgora(id) {
			$.post("removeTarefa", {'id' : id}, function() 
			{
				$("#removeTarefa_"+id).closest("tr").hide();
				 
			});
		}
	</script>	
		<c:import url="inc/cabecalho.jsp" />
		<a href="novaTarefa">Criar nova tarefa</a>
		<br /> <br />
		<table>
			<tr>
				<th>Id</th>
				<th>Descri��o</th>
				<th>Finalizado?</th>
				<th>Data de finaliza��o</th>
			</tr>
			<c:forEach items="${tarefas}" var="tarefa">
				<tr id="tarefa_${tarefa.id}">
					<td>${tarefa.id}</td>
					<td>${tarefa.descricao}</td>
					<c:if test="${tarefa.finalizado eq false}">
						<!--  id="finalizaTarefa_${tarefa.id}" -->
						<td>
						<a href="#" onClick="finalizaAgora(${tarefa.id})">N�o Finalizado</a>
					</td>
					</c:if>
					<c:if test="${tarefa.finalizado eq true}">
					<td>Finalizado </td>
					</c:if>
					<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}" 
						pattern="dd/MM/yyyy"/> 
					</td>
					<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
					<td>
					<a href="removeTarefa?id=${tarefa.id}">
						Remover
					</a></td>
					<td id="removeTarefa_${tarefa.id}">
					<a href="#" onClick="removeAgora(${tarefa.id})">
						Excluir
					</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<c:import url="inc/rodape.jsp" />
	</body>
</html>
