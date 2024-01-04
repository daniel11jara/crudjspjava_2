<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edicao de Usuario</title>
</head>
<body>
<%@ page import = "com.crudjspjava_2.bean.Usuario, com.crudjspjava_2.dao.UsuarioDao" %>
	
<%
String id  = request.getParameter("id");
Usuario usuario = UsuarioDao.getRegistroById(Integer.parseInt(id));

%>
	
<h1>Edicao do formulario</h1>

<form action="editusuario.jsp" >

<input type="hidden" name = "id" value = "<%=usuario.getId()%>"/>
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type = "text" name = "nome" value = "<%=usuario.getNome()%>"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type = "password" name = "password" value = "<%=usuario.getPassword()%>"/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type = "email" name = "email" value = "<%=usuario.getEmail()%>"/></td>
		</tr>
		<tr>
			<td>Sexo:</td>
			<td><input type = "radio" name = "sexo" value = "masculino"/>Masculino</td>
			<td><input type = "radio" name = "sexo" value = "feminino"/>Feminino</td>
		</tr>
		<tr>
			<td>Pais:</td>
				<td>
					<select name = "pais">
						<option>Brasil</option>
						<option>Eua</option>
						<option>Portugal</option>
						<option>Argentina</option>
						<option>Outro</option>
					</select>
				</td>
		</tr>
		<tr>
			<td><input type = "submit" value = "Editar Usuario"></td>
		</tr>
	</table>

</form>

</body>
</html>