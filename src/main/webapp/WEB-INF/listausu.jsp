<%@page import="java.util.List"%>
<%@page import="br.com.techcurso.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de usuários</title>

<script type="text/javascript">
	function confirmExclusao(id) {
		if (window.confirm('Tem certeza que deseja exclui?')) {
			location.href = "usucontroller.do?acao=deletar&id=" + id;
		}
	}
</script>
</head>
<body>
	<button >Cadastrar</button>
	<%
	List<Usuario> lista = (List<Usuario>) request.getAttribute("listaUsu");
	%>
	<table border="1px">
		<tr>
			<th>id</th>
			<th>nome</th>
			<th>login</th>
			<th>ação</th>
		<tr />
		<%
		for (Usuario u : lista) {
		%>
		<tr>
			<th><%=(u.getId())%></th>
			<th><%=(u.getNome())%></th>
			<th><%=(u.getLogin())%></th>
			<th>
				<a href="javascript:confirmExclusao(<%=(u.getId())%>)">Excluir </a>||
				<a href="usucontroller.do?acao=editar&id=<%=(u.getId())%>">Editar </a>||
			</th>
		<tr />
		<%
		}
		%>
	</table>

</body>
</html>