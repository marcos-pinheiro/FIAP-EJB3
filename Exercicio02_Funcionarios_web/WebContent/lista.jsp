<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="formulario.jsp">Formulário</a>
	<table width="500px">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Salário</th>
				<th>IRPF</th>
				<th>INSS</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${funcionarios}" var="funcionario">
				<tr style="text-align: center;">
					<td>${funcionario.nome}</td>
					<td>${funcionario.salario}</td>
					<td>${funcionario.irpf}</td>
					<td>${funcionario.inss}</td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
</body>
</html>