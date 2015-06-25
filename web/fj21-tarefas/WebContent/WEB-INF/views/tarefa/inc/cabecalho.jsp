<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<link href="resources/css/jquery.css" rel="stylesheet">
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/jquery-ui.js"></script>	
	<script>
		$("#dataFinalizacao").datepicker({ dateFormat: 'dd/mm/yyyy'});
	</script>
</head>

<img src="<c:url value="resources/imagens/caelum.png" />" />
<h2>Tarefas</h2>
<hr />