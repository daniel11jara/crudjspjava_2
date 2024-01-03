<%@ page import = "com.crudjspjava_2.dao.UsuarioDao"%>
<jsp:useBean id = "u" class = "com.crudjspjava_2.bean.Usuario"></jsp:useBean>
<jsp: setProperty property="*" name="u"/>

<%
int i = UsuarioDao.updateUsuario(u);
response.sendRedirect("viewusuario.jsp");

%>