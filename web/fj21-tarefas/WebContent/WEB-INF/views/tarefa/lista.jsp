<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

	<body>
	
	<script type="text/javascript">
	
		function finalizaAgora(id) {
			$.post("finalizaTarefa", {'id' : id}, function() {
				// selecionando o elemento html através da
				// ID e alterando o HTML dele
				$("#finalizaTarefa_"+id).html("Finalizado");
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
				<th>Descrição</th>
				<th>Finalizado?</th>
				<th>Data de finalização</th>
			</tr>
			<c:forEach items="${tarefas}" var="tarefa">
				<tr>
					<td>${tarefa.id}</td>
					<td>${tarefa.descricao}</td>
					<c:if test="${tarefa.finalizado eq false}">
						<td id="finalizaTarefa_${tarefa.id}">
						<a href="#" onClick="finalizaAgora(${tarefa.id})">Não Finalizado</a>
					</td>
					</c:if>
					<c:if test="${tarefa.finalizado eq true}">
						<td id="finalizaTarefa_${tarefa.id}">Finalizada</td>
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
