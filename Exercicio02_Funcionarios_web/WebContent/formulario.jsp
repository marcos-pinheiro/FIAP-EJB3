<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="FuncionarioServlet">Lista</a>
	</div>
	<div>
		<form action="FuncionarioServlet" method="POST">
			<div>
				<label>Nome</label> <input type="text" name="nome">
			</div>
			<div>
				<label>CPF</label> <input type="text" name="cpf">
			</div>
			<div>
				<label>Cargo</label> <input type="text" name="cargo">
			</div>
			<div>
				<label>Salário</label> <input type="text" name="salario">
			</div>
			<div>
				<button>Enviar</button>
			</div>
		</form>
	</div>
	<div>
		${mensagem}
	</div>
</body>
</html>