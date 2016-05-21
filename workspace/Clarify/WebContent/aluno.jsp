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

 
		


	<form action="AlunoController" name="frmAddUser" method="POST">
	
	ID: <input type="text" readonly="readonly"name="id" value="<c:out value="${aluno.id}"/>" > <br />
	Primeira Nome: <input type="text" name="primeiroNome" value="<c:out value="${aluno.primeiroNome}"/>"  > <br />
	segundo Nome: <input type="text" name="segundoNome" value="<c:out value="${aluno.segundoNome}"/>"  > <br /> 
	Email: <input type="text" name="email" value="<c:out value="${aluno.email}"/>"  > <br />
	Curso: <input type="text" name="curso" value="<c:out value="${aluno.curso}"/>"  > <br /> 
	Cpf: <input type="text" name="cpf" value="<c:out value="${aluno.cpf}"/>"  > <br />
	Rg: <input type="text" name="rg" value="<c:out value="${aluno.rg}"/>"  > <br /> 
	<input type="submit" value="enviar"> 
	
	</form>
 
 
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
