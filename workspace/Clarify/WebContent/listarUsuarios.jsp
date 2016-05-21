<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>




</head> 
<body>       
	 
	<div class="container"> 
	   
		<h1>Usuarios</h1>

		<table border="1">
			<thead>	<!-- Cabe�alho da tabela -->
				<tr> 
					<th>ID</th>
					<th>PRIMEIRO NOME</th> 
					<th>SEGUNDO NOME</th>
					<th>DATA DE NASCIMENTO</th>
					<th>EMAIL</th>
					<th colspan="2">A��O</th> 
				</tr>
			</thead> 
				<tbody><!-- Corpo da tabela -->
					<c:forEach items="${usuarios}" var="usuario"> <!-- for para percorrer todos os objetos recebidos -->
						<tr> <!-- LINHA -->
							<td><c:out value="${usuario.id }" /> </td>
							<td><c:out value="${usuario.primeiroNome }" /> </td>
							<td><c:out value="${usuario.segundoNome }" /> </td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value ="${usuario.dataNascimento}" /> </td>
							
							<td><c:out value="${usuario.email }" /> </td>
							
							<td><a href="UsuarioController?action=edit&id=<c:out value="${usuario.id}" /> "> Atualizar</a></td>
							<td><a href="UsuarioController?action=delete&id=<c:out value="${usuario.id}" /> "> Deletar</a></td>
							
							 
							 			 
						</tr>
					</c:forEach>
				</tbody>
		</table>
		
		  
		<p><a href="UsuarioController?action=inserir">Adicionar usuario</a></p>
		
		
	</div>	


<!-- jQuery (necessario para os plugins Javascript Bootstrap) -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>


</body>
</html>