<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar usuario</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


		


	<form action="UsuarioController" name="frmAddUser" method="POST">
	
	ID: <input type="text" readonly="readonly"name="id" value="<c:out value="${usuario.id}"/>" > <br />
	Primeira Nome: <input type="text" name="primeiroNome" value="<c:out value="${user.primeiroNome}"/>"  > <br />
	segundo Nome: <input type="text" name="segundoNome" value="<c:out value="${user.segundoNome}"/>"  > <br />
	Data de Nascimento: <input type="text" name="dataNascimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${usuario.dataNascimento}" />"  > <br />
	Email: <input type="text" name="email" value="<c:out value="${usuario.email}"/>"  > <br />
	<input type="submit" value="enviar">
	
	</form>

 
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
