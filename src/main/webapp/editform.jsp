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
	
	<% String id = request.getParameter("id"); 
		Usuario usuario = UsuarioDao.getRegistroById(Integer.parseInt(id));
	
	%>

</body>
</html>