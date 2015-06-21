<%@page import="java.util.*" %>
<%@page import="br.com.caelum.jdbc.modelo.Contato"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<body>

<c:import url="cabecalho.jsp"></c:import>


<!-- cria o DAO -->
<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao" />

 

<table>
			<tr>
				<td>Id</td>
				<td>Nome</td>
				<td>Email</td>
				<td>Endere�o</td>
				<td>Data de nascimento</td>
			</tr>

	<c:forEach var="contato" items="${dao.lista}" varStatus="id">
		<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
		<td>${id.count}</td>
		<td>
			<c:if test="${not empty contato.nome}">
				${contato.nome}
			</c:if>
			<c:if test="${empty contato.nome}">
				Nome n�o infomardo
			</c:if>
		</td>
		<td>
			<c:choose>
				<c:when test="${not empty contato.email}">
					<a href="mailto:${contato.email}">${contato.email}</a>
				</c:when>
				<c:otherwise>
					Email n�o informado
				</c:otherwise>
			</c:choose>
		</td>
		<td>${contato.endereco}</td>
		<td>
			<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
		</td>
		</tr>	
	</c:forEach>
</table>


<c:import url="rodape.jsp"></c:import>

</body>
</html>