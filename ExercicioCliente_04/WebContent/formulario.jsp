<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="LivroServlet">Lista</a>
	<form action="LivroServlet" method="POST">
		<div>
			<input type="text" name="titulo" placeholder="Título">
		</div>
		<div>
			<input type="text" name="autor" placeholder="Autor">
		</div>
		<div>
			<input type="text" name="preco" placeholder="Preço">
		</div>
		<div>
			<button>Salvar</button>
		</div>
	</form>
	<div>
		${mensagem}
	</div>
</body>
</html>