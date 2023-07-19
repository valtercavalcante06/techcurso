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
		if (window.confirm('Tem certeza que deseja excluir?')) {
			location.href = "usucontroller.do?acao=deletar&id=" + id;
		}
	}
</script>
</head>
<body>
	<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	%>
	<form action="usucontroller.do" method="POST">
		<input hidden="hidden" name="id" type="text" value="<%=usuario.getId() %>" />
		Nome:
		<input name="nome" type="text"  value="<%=usuario.getNome() %>"/>
		<br />
		Usuario:
		<input name="login" type="text"  value="<%=usuario.getLogin() %>" />
		<br />
		Senha:
		<input name="senha" type="password"  value="<%=usuario.getSenha() %>" />
		<br />
		<input type="submit" value="Alterar" />
	</form>

</body>
</html>